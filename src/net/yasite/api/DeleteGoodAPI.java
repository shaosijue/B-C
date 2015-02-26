package net.yasite.api;

import java.util.List;

import net.yasite.api.params.Urls;
import net.yasite.entity.CarListEntity;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class DeleteGoodAPI extends BaseAPI {

	public DeleteGoodAPI(Context context, List<NameValuePair> pm,String token) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + "cartController/delGood/"
				+ token);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), CarListEntity.class);
	}

}
