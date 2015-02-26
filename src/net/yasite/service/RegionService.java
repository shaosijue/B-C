package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.GetRegionAPI;
import android.content.Context;

public class RegionService extends BaseService {

	public RegionService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public Object getRegion(String parentId){
//		List<NameValuePair> pm = new ArrayList<NameValuePair>();
//		pm.add(getValue("parentId", parentId));
		BaseAPI api = new GetRegionAPI(context,parentId);
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
