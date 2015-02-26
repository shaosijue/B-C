package net.yasite.test;

import net.yasite.util.ActivityUtil;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SettingActivity extends BaseNewActivity {

	TextView text_address,text_pwd;
	
	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		text_address = getTextView(R.id.text_address_setting);
		text_pwd = getTextView(R.id.text_pwd_setting);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_setting);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		text_address.setOnClickListener(listener);
		text_pwd.setOnClickListener(listener);
	}
	OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.text_address_setting:
				Intent intent = new Intent(context,AddressListActivity.class);
				startActivity(intent);
				break;
			case R.id.text_pwd_setting:
				ActivityUtil.showToast(context, "pwd");
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

}
