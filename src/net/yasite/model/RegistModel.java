package net.yasite.model;

import net.yasite.service.RegistService;
import android.content.Context;

public class RegistModel extends Model {

	RegistService registService;

	public RegistModel(Context context) {
		this.context = context;
		registService = new RegistService(context);
	}

	public Object RequestPost(String username, String pwd) {
		return registService.regist(username, pwd);
	}

	public void saveToken(String token) {
		registService.saveToken(token);
	}

	public String getToken() {
		return registService.getToken();
	}

	public void saveSp(String key, String value) {
		registService.saveSp(key, value);
	}

	public String getSp(String key) {
		return registService.getSp(key);
	}
}
