package net.yasite.api;

import java.util.List;

import net.yasite.api.params.Urls;
import net.yasite.entity.RegistEntity;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;
import android.preference.PreferenceManager;

public class LoginAPI extends BaseAPI {
	/**
	 * 登陆
	 */
	public LoginAPI(Context context, List<NameValuePair> pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.USER + Urls.Login);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), RegistEntity.class);
	}

	public void saveSp(String key, String value) {
		PreferenceManager.getDefaultSharedPreferences(context).edit()
				.putString(key, value).commit();
	}

	public String getSp(String key) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getString(key, "");
	}

	public void clearSp() {
		PreferenceManager.getDefaultSharedPreferences(context).edit().clear()
				.commit();
	}

}
