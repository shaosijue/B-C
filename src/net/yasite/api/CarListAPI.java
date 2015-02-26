package net.yasite.api;

import java.util.List;

import net.yasite.api.params.Urls;
import net.yasite.entity.CarListEntity;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class CarListAPI extends BaseAPI {

	/**
	 * 获取购物车信息列表
	 * @author hxg-pc
	 */
	public CarListAPI(Context context, List<NameValuePair> pm, String id) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop
				+ "cartController/getGoodList/" + id);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), CarListEntity.class);
	}

}
