package net.yasite.service;

import java.util.ArrayList;
import java.util.List;

import net.yasite.api.BaseAPI;
import net.yasite.api.LoginAPI;
import net.yasite.api.RegistAPI;

import org.apache.http.NameValuePair;

import android.content.Context;

public class LoginService extends BaseService {

	public LoginService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public Object login(String name, String pwd) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(getValue("name", name));
		params.add(getValue("pwd", pwd));
		BaseAPI api = new LoginAPI(context, params);
		try {
			if (api.doPost()) {
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void saveToken(String token) {
		BaseAPI api = new LoginAPI(context, null);
		api.saveToken(token);
	}

	public String getToken() {
		BaseAPI api = new LoginAPI(context, null);
		return api.getToken();
	}

	public void saveSp(String key, String value) {
		LoginAPI api = new LoginAPI(context, null);
		api.saveSp(key, value);
	}

	public String getSp(String key) {
		LoginAPI api = new LoginAPI(context, null);
		return api.getSp(key);
	}
	
	public void clearSp(){
		LoginAPI api = new LoginAPI(context, null);
		api.clearSp();
	}
}
