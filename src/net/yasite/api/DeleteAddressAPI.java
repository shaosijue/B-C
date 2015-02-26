package net.yasite.api;

import java.util.List;
import net.yasite.api.params.Urls;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;

public class DeleteAddressAPI extends BaseAPI {
	/**
	 * 删除用户收货地址
	 */
	public DeleteAddressAPI(Context context, List<NameValuePair> pm,
			String token) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.Shop + Urls.USER + "delAddress/"
				+ token);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}

}
