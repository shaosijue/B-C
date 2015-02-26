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

public class RegistAPI extends BaseAPI {
	/**
	 * 注册
	 */
	public RegistAPI(Context context, List<NameValuePair> pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.USER + Urls.Register);
	}

	@Override
	public RegistEntity handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), RegistEntity.class);
	}

	/**
	 * 在注册后保存user_id、user_name等信息到Sp中
	 */
	public void saveSp(String key, String value) {
		PreferenceManager.getDefaultSharedPreferences(context).edit()
				.putString(key, value).commit();
	}

	public String getSp(String key) {
		return PreferenceManager.getDefaultSharedPreferences(context)
				.getString(key, "");
	}

}
