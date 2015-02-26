package net.yasite.test;

import net.yasite.adapter.AddressListAdapter;
import net.yasite.entity.AddressListEntity;
import net.yasite.model.AddressModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChoseAddressActivity extends BaseNewActivity {
	/**
	 * 选择地址
	 */
	ListView listView;
	AddressModel addressModel;
	AddressListEntity addressListEntity;
	AddressListAdapter adapter;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		listView = getListView(R.id.listview_chooseaddress);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_chooseaddress);
	}

	@Override
	public void setModel() {
		addressModel = new AddressModel(context);
		new ChooseAddressHanlder(context).execute();
		adapter = new AddressListAdapter(context);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("info",
						addressListEntity.getData().get(position));
				setResult(4, intent);
				finish();
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class ChooseAddressHanlder extends HandlerHelp {

		public ChooseAddressHanlder(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			adapter.setList(addressListEntity.getData());
			adapter.notifyDataSetChanged();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String user_id = new RegistModel(context).getSp("user_id");
			String token = new RegistModel(context).getToken();
			addressListEntity = (AddressListEntity) addressModel
					.getAddressList(token, user_id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}

}
