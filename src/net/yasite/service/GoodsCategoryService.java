package net.yasite.service;

import java.util.ArrayList;
import java.util.List;
import net.yasite.api.BaseAPI;
import net.yasite.api.GoodsCategoryAPI;
import org.apache.http.NameValuePair;
import android.content.Context;

public class GoodsCategoryService extends BaseService {

	public GoodsCategoryService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public Object getGoodsCategory(String id){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(getValue("id", id));
		BaseAPI api = new GoodsCategoryAPI(context, id);
		try {
			if(api.doGet()){
				return api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
