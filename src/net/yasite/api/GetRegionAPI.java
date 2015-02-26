package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.RegionListEntity;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import android.content.Context;

public class GetRegionAPI extends BaseAPI {
	/**
	 * 获取国家、省、市信息
	 * @author hxg-pc
	 */
	public GetRegionAPI(Context context, String parentId) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop
				+ "regionController/getRegion/" + parentId);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), RegionListEntity.class);
	}

}
