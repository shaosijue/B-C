package net.yasite.api;

import net.yasite.api.params.Urls;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class GetAddressInfoAPI extends BaseAPI {

	public GetAddressInfoAPI(Context context,String user_id,String address_id,String token) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.USER
				+ "getAddressInfo/" + user_id + "/" + address_id+"/"+token);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

}
