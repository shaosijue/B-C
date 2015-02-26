package net.yasite.test;

import net.yasite.api.params.AddressParams;
import net.yasite.model.AddressModel;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddAddressActivity extends BaseNewActivity {
	/**
	 * 添加收货地址
	 */
	AddressModel addressModel;
	AddressParams ap = new AddressParams();
	EditText ed_name,ed_tel,ed_address;
	TextView textView;
	Button btn_save;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		ed_name = getEdit(R.id.edit_name_addaddress);
		ed_tel = getEdit(R.id.edit_tel_addaddress);
		ed_address = getEdit(R.id.edit_address_addaddress);
		btn_save = getButton(R.id.btn_save);
		textView = getTextView(R.id.text_district_addaddress);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_addaddress);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		addressModel = new AddressModel(context);
		textView.setOnClickListener(listener);
		btn_save.setOnClickListener(listener);
	}
	OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.text_district_addaddress:
				Intent intent = new Intent(context,RegionActivity.class);
				startActivityForResult(intent, 1);
				break;
			case R.id.btn_save:
				boolean flag = true;
				String name = ed_name.getText().toString().trim();
				String tel = ed_tel.getText().toString().trim();
				String address = ed_address.getText().toString().trim();
				if(name.equals("")){
					flag = false;
				}else{
					ap.setConsignee(name);
				}
				if(tel.equals("")){
					flag = false;
				}else{
					ap.setTel(tel);
				}
				if(address.equals("")){
					flag = false;
				}else{
					ap.setAddress(address);
				}
				if(ap.getCountry() == null || ap.getCountry().equals("")){
					flag = false;
				}
				if(!flag){
					ActivityUtil.showToast(context, "任何信息不可为空");
				}else{
					ap.setUser_id(new RegistModel(context).getSp("user_id"));
					new AddAddressHandler(context).execute();
					setResult(2);
					finish();
				}
				break;
			default:
				break;
			}
		}
	};


	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == 1 && resultCode == 1){
			ap = (AddressParams) data.getSerializableExtra("info");
			textView.setText(ap.getTemp());
		}
	};

	class AddAddressHandler extends HandlerHelp {

		public AddAddressHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub

		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			String token = new RegistModel(context).getToken();
			addressModel.addAddress(ap, token);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}
	}
}
