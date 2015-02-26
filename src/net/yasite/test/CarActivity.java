package net.yasite.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.yasite.adapter.CarListAdapter;
import net.yasite.entity.CarItemEntity;
import net.yasite.entity.CarListEntity;
import net.yasite.model.CarModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

public class CarActivity extends BaseNewActivity {
	/**
	 * 购物车
	 */
	CarModel carModel;
	ListView listview;
	CarListEntity carListEntity;
	CarListAdapter adapter;
	Button btn_confirm, btn_del;
	TextView text_sum;
	CheckBox cb_all;
	MyReceiver receiver;
	String ids;

	@Override
	public void setupView() {
		listview = getListView(R.id.listview_car);
		btn_confirm = getButton(R.id.btn_car_confirm);
		btn_del = getButton(R.id.btn_car_del);
		text_sum = getTextView(R.id.text_car_sum);
		cb_all = getCheckBox(R.id.cb_car_all);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_carlist);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		carModel = new CarModel(context);
		new CarHandler(context).execute();
		adapter = new CarListAdapter(context);
		listview.setAdapter(adapter);
		receiver = new MyReceiver();
		registerReceiver(receiver, new IntentFilter("net.yasite.adapter.sum"));

		// 全选功能
		cb_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				for (CarItemEntity item : carListEntity.getData()) {
					item.setChecked(isChecked);
				}
				adapter.notifyDataSetChanged();
			}
		});
		//购买
		btn_confirm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				List<CarItemEntity> carlist = new ArrayList<CarItemEntity>();
				for (CarItemEntity carItemEntity : carListEntity.getData()) {
					if (carItemEntity.isChecked()) {
						carlist.add(carItemEntity);
					}
				}
				Intent intent = new Intent(context, CheckOutActivity.class);
				intent.putExtra("info", (Serializable) carlist);
				startActivity(intent);
			}
		});
		//删除
		btn_del.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuffer sb = new StringBuffer();
				for (CarItemEntity carItemEntity : carListEntity.getData()) {
					if (carItemEntity.isChecked()) {
						sb.append(carItemEntity.getRec_id());
						sb.append(",");
					}
				}
				sb.deleteCharAt(sb.length() - 1);
				ids = "[" + sb.toString() + "]";
				System.out.println("``````" + ids);
				new DelHandler(context).execute();
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class CarHandler extends HandlerHelp {

		public CarHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(carListEntity.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String id = new RegistModel(context).getSp("user_id");
			String token = new RegistModel(context).getToken();
			carListEntity = (CarListEntity) carModel.getCarList(id, token);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}

	class DelHandler extends HandlerHelp {

		public DelHandler(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(carListEntity.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String user_id = new RegistModel(context).getSp("user_id");
			String token = new RegistModel(context).getToken();
			carListEntity = (CarListEntity) carModel.deleteGood(user_id, ids,
					token);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}

	}

	public class MyReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			double sum = intent.getDoubleExtra("sum", 0);
			text_sum.setText("合计：" + sum + "元");
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
	}

}
