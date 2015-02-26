package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.CategoryListEntity;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import android.content.Context;

public class GoodsCategoryAPI extends BaseAPI {
	/**
	 * 商品分类
	 */
	public GoodsCategoryAPI(Context context, String id) {
		super(context);
		// TODO Auto-generated constructor stub
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.GOODS
				+ Urls.GoodsCategory + id);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), CategoryListEntity.class);
	}

}
