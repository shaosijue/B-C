package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.MyGoodEntity;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import android.content.Context;

public class GoodInfoAPI extends BaseAPI {
	/**
	 * 商品详情
	 */
	public GoodInfoAPI(Context context, String id) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.GOODS
				+ Urls.getGoodInfo + id);
	}

	@Override
	public MyGoodEntity handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), MyGoodEntity.class);
	}
}
