package net.yasite.test;

import net.yasite.entity.RegistEntity;
import net.yasite.model.LoginModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends BaseNewActivity {
	/**
	 * 登陆
	 */
	EditText ed_name, ed_pwd;
	Button btn_login;
	RegistEntity registEntity = null;
	LoginModel loginModel;
	String name, pwd;
	TextView text_reg;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		ed_name = getEdit(R.id.ed_login_name);
		ed_pwd = getEdit(R.id.ed_login_pwd);
		btn_login = getButton(R.id.btn_login);
		text_reg = getTextView(R.id.text_reg);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_login);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		loginModel = new LoginModel(context);
		btn_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				name = ed_name.getText().toString().trim();
				pwd = ed_pwd.getText().toString().trim();
				new LoginHandler(context).execute();
			}
		});
		text_reg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, RegistActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class LoginHandler extends HandlerHelp {

		public LoginHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			if (registEntity != null) {
				ActivityUtil.showToast(context, "恭喜您，登陆成功！");
				loginModel.saveToken(registEntity.getData().getToken());
				loginModel.saveSp("user_id", registEntity.getData().getUser_id()+"");
				loginModel.saveSp("user_name", registEntity.getData().getUser_name());
				setResult(1);
				finish();
			} else {
				ActivityUtil.showToast(context, "账号或密码错误");
			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			registEntity = (RegistEntity) loginModel.RequestPost(name, pwd);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}
	}

}
