package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.OrderListEntity;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class GetOrderListAPI extends BaseAPI {
	/**
	 * 获取订单列表
	 */
	public GetOrderListAPI(Context context, String id) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop
				+ "orderController/getOrderList/" + id);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), OrderListEntity.class);
	}

}
