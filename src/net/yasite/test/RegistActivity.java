package net.yasite.test;

import net.yasite.entity.RegistEntity;
import net.yasite.model.RegistModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistActivity extends BaseNewActivity {
	/**
	 * 注册
	 */
	EditText ed_username, ed_pwd;
	Button btn_regist;
	RegistEntity registEntity = null;
	RegistModel registModel;
	String name, pwd;

	@Override
	public void setupView() {
		// TODO Auto-generated method stub
		ed_username = getEdit(R.id.ed_reg_name);
		ed_pwd = getEdit(R.id.ed_reg_pwd);
		btn_regist = getButton(R.id.btn_reg);
	}

	@Override
	public void setContent() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_regist);
	}

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		registModel = new RegistModel(context);
		btn_regist.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				name = ed_username.getText().toString().trim();
				pwd = ed_pwd.getText().toString().trim();
				new RegistHandler(context).execute();
			}
		});
	}

	@Override
	public boolean getIntentValue() {
		// TODO Auto-generated method stub
		return true;
	}

	class RegistHandler extends HandlerHelp {

		public RegistHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
			if (registEntity != null) {
				ActivityUtil.showToast(context, "恭喜您，注册成功！");
				registModel.saveToken(registEntity.getData().getToken());
				registModel.saveSp("user_id", registEntity.getData().getUser_id());
				registModel.saveSp("user_name", registEntity.getData().getUser_name());
				Intent intent = new Intent(context,HomeActivity.class);
				startActivity(intent);
				finish();
			} else {
				ActivityUtil.showToast(context, "抱歉，用户名已存在！");
			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			registEntity = (RegistEntity) registModel.RequestPost(name, pwd);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub

		}

	}

}
