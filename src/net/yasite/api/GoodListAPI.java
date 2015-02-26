package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.GoodListEntity;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import com.google.gson.Gson;

public class GoodListAPI extends BaseAPI {
	/**
	 * 商品列表
	 */
	public GoodListAPI(Context context, String page, String id) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.GOODS
				+ Urls.getGoodList + page + "/" + id);
	}

	@Override
	public GoodListEntity handlerResult(JSONObject json) throws JSONException {
		return new Gson().fromJson(json.toString(), GoodListEntity.class);
	}

}
