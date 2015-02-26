package net.yasite.api;

import java.util.ArrayList;
import java.util.List;

import net.yasite.api.params.Params;
import net.yasite.api.params.Urls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class MyApi extends BaseAPI {

	

	public MyApi(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		setMethod(Urls.WEB_SERVER_PATH + Urls.MY);
	}

	@Override
	public List<Params> handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		List<Params> list = new ArrayList<Params>();
		List<String> last_up_userslist = null;
		List<String> url = null;
		Params params = null;
		
		JSONObject object = new JSONObject(json.toString());
		JSONArray data = object.getJSONArray("data");
		for (int i = 0; i < data.length(); i++) {
			JSONObject obj = data.getJSONObject(i);
			params = new Params();
			params.setContent(obj.getString("content"));
			params.setCreated_at(obj.getString("created_at"));
			JSONObject author = obj.getJSONObject("author");
			params.setAuthor_username(author.getString("username"));
			JSONArray attachments = obj.getJSONArray("attachments");
			url = new ArrayList<String>();
			for (int j = 0; j < attachments.length(); j++) {
				JSONObject attachmentsobj = attachments.getJSONObject(j);
				url.add(attachmentsobj.getString("url"));
			}
			params.setUrl(url);
			JSONArray last_up_users = obj.getJSONArray("last_up_users");
			last_up_userslist = new ArrayList<String>();
			for (int j = 0; j < last_up_users.length(); j++) {
				JSONObject last_up_usersobj = last_up_users.getJSONObject(j);
				last_up_userslist.add(last_up_usersobj.getString("username"));
			}
			params.setLast_up_users(last_up_userslist);
			list.add(params);
			params = null;
			last_up_userslist = null;
			url = null;
		}
		
		return list;
	}

}
