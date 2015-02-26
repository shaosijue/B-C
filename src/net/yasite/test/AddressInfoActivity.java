package net.yasite.test;

import net.yasite.entity.AddressEntity;
import net.yasite.model.AddressModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AddressInfoActivity extends BaseNewActivity {

	AddressEntity addressEntity;
	TextView text_name, text_tel, text_dis, text_address;
	Button btn_delete;
	AddressModel addressModel;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		text_name = getTextView(R.id.text_name_addressinfo);
		text_tel = getTextView(R.id.text_tel_addressinfo);
		text_dis = getTextView(R.id.text_dis_addressinfo);
		text_address = getTextView(R.id.text_address_addressinfo);
		btn_delete = getButton(R.id.btn_delete_addressinfo);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_addressinfo);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		addressModel = new AddressModel(context);
		text_name.setText(addressEntity.getConsignee());
		text_tel.setText(addressEntity.getTel());
		text_dis.setText(addressEntity.getDistrict());
		text_address.setText(addressEntity.getAddress());
		btn_delete.setOnClickListener(listener);
	}

	OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btn_delete_addressinfo:
				new AddressInfoHandler(context).execute();
				break;
			default:
				break;
			}
		}
	};

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		addressEntity = (AddressEntity) getIntent()
				.getSerializableExtra("info");
		if (addressEntity != null) {
			return true;
		} else {
			return false;
		}
	}

	class AddressInfoHandler extends HandlerHelp {

		public AddressInfoHandler(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			setResult(3);
			finish();
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String token = new RegistModel(context).getToken();
			String id = addressEntity.getAddress_id();
			addressModel.deleteAddress(id, token);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
		}
	}
}
