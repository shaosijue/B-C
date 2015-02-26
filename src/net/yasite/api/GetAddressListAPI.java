package net.yasite.api;

import net.yasite.api.params.Urls;
import net.yasite.entity.AddressListEntity;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import android.content.Context;

public class GetAddressListAPI extends BaseAPI {
	/**
	 * 获取用户送货地址列表
	 * @author hxg-pc
	 */
	public GetAddressListAPI(Context context, String token, String user_id) {
		super(context);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.USER
				+ "getUserAddressList/" + user_id + "/" + token);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), AddressListEntity.class);
	}

}
