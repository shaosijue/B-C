package net.yasite.test;

import java.util.List;

import net.yasite.adapter.CheckOutAdapter;
import net.yasite.entity.AddressEntity;
import net.yasite.entity.CarItemEntity;
import net.yasite.model.OrderModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class CheckOutActivity extends BaseNewActivity {
	/**
	 * 结算
	 */
	ListView listView;
	Button btn_confirm, btn_select;
	EditText ed_name, ed_address;
	TextView text_sum;
	CarItemEntity carItemEntity;
	List<CarItemEntity> list;
	CheckOutAdapter adapter;
	MyReceiver receiver;
	OrderModel orderModel;
	AddressEntity addressEntity;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listView = getListView(R.id.listview_checkout);
		btn_confirm = getButton(R.id.btn_checkout);
		btn_select = getButton(R.id.btn_select_address);
		ed_name = getEdit(R.id.ed_select_name);
		ed_address = getEdit(R.id.ed_select_address);
		text_sum = getTextView(R.id.text_checksum);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_checkout);
	}

	@Override
	public void setModel() {
		orderModel = new OrderModel(context);
		adapter = new CheckOutAdapter(context);
		adapter.setList(list);
		listView.setAdapter(adapter);
		receiver = new MyReceiver();
		registerReceiver(receiver, new IntentFilter(
				"net.yasite.adapter.checkoutsum"));
		btn_select.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, ChoseAddressActivity.class);
				startActivityForResult(intent, 4);
			}
		});

		btn_confirm.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (addressEntity != null) {
					new CreateOrderHandler(context).execute();
				} else {
					ActivityUtil.showToast(context, "请选择地址");
				}
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		list = (List<CarItemEntity>) getIntent().getSerializableExtra("info");
		if (list != null) {
			return true;
		} else {
			ActivityUtil.showToast(context, "请选择要购买的商品");
			return false;
		}
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		if (arg0 == 4 && arg1 == 4) {
			addressEntity = (AddressEntity) arg2.getSerializableExtra("info");
			ed_name.setText(addressEntity.getConsignee());
			ed_address.setText(addressEntity.getAddress());
		}
		super.onActivityResult(arg0, arg1, arg2);
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

	class CreateOrderHandler extends HandlerHelp {

		public CreateOrderHandler(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub

		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String user_id = new RegistModel(context).getSp("user_id");
			String add = addressEntity.getConsignee()
					+ addressEntity.getCountry() + addressEntity.getProvince()
					+ addressEntity.getCity() + addressEntity.getDistrict()
					+ addressEntity.getAddress() + addressEntity.getTel()
					+ addressEntity.getMobile() + "0";
			orderModel.createOrder(user_id, add);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}
}
