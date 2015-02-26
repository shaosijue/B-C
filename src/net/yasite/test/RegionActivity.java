package net.yasite.test;

import net.yasite.adapter.RegionAdapter;
import net.yasite.api.params.AddressParams;
import net.yasite.entity.RegionListEntity;
import net.yasite.model.RegionModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class RegionActivity extends BaseNewActivity {
	/**
	 * 增加地址列表
	 */
	RegionModel model;
	ListView listView;
	TextView textView;
	RegionListEntity regionListEntity;
	RegionAdapter adapter;
	StringBuffer sb;
	AddressParams addressParams = new AddressParams();;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		textView = getTextView(R.id.text_region);
		listView = getListView(R.id.listview_region);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_region);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		sb = new StringBuffer();
		sb.append("中国");
		addressParams.setCountry(1 + "");
		model = new RegionModel(context);
		new MyHandler(context, 1 + "").execute();
		adapter = new RegionAdapter(context);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				new MyHandler(context, regionListEntity.getData().get(position)
						.getRegion_id()).execute();
				sb.append(regionListEntity.getData().get(position)
						.getRegion_name());
				if (regionListEntity.getData().get(position).getRegion_type()
						.equals("1")) {
					addressParams.setProvince(regionListEntity.getData()
							.get(position).getRegion_id());
				} else if (regionListEntity.getData().get(position)
						.getRegion_type().equals("2")) {
					addressParams.setCity(regionListEntity.getData()
							.get(position).getRegion_id());
				} else if (regionListEntity.getData().get(position)
						.getRegion_type().equals("3")) {
					addressParams.setDistrict(regionListEntity.getData()
							.get(position).getRegion_id());
					addressParams.setTemp(sb.toString());
					Intent intent = new Intent();
					intent.putExtra("info", addressParams);
					setResult(1, intent);
					finish();
				}
				textView.setText(sb.toString());
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class MyHandler extends HandlerHelp {

		String id;

		public MyHandler(Context context, String id) {
			super(context);
			this.id = id;
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			if (regionListEntity.getData() == null
					|| regionListEntity.getData().size() == 0) {
			}
			adapter.setList(regionListEntity.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			regionListEntity = (RegionListEntity) model.getRegion(id + "");
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}
	}
}
