package net.yasite.api;

import net.yasite.api.params.Urls;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class CancelOrderAPI extends BaseAPI {

	public CancelOrderAPI(Context context,String id) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop
				+ "orderController/cancelOrder/"+id);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

}
