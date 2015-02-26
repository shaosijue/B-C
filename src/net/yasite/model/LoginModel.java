package net.yasite.model;

import net.yasite.service.LoginService;
import android.content.Context;

public class LoginModel extends Model {

	LoginService loginService;

	public LoginModel(Context context) {
		this.context = context;
		loginService = new LoginService(context);
	}

	public Object RequestPost(String username, String pwd) {
		return loginService.login(username, pwd);
	}

	public void saveToken(String token) {
		loginService.saveToken(token);
	}

	public String getToken() {
		return loginService.getToken();
	}

	public void saveSp(String key, String value) {
		loginService.saveSp(key, value);
	}

	public String getSp(String key) {
		return loginService.getSp(key);
	}
	
	public void clearSp(){
		loginService.clearSp();
	}
}
