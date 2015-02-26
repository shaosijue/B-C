package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.GoodInfoAPI;
import net.yasite.api.GoodListAPI;
import net.yasite.entity.GoodEntity;
import net.yasite.entity.GoodListEntity;
import net.yasite.entity.MyGoodEntity;
import android.content.Context;

public class GoodService extends BaseService {

	public GoodService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public GoodListEntity getGoodList(String page,String id){
		BaseAPI api = new GoodListAPI(context, page, id);
		try {
			if(api.doGet()){
				return (GoodListEntity) api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public MyGoodEntity getGoodInfo(String id){
		BaseAPI api = new GoodInfoAPI(context, id);
		try {
			if(api.doGet()){
				return (MyGoodEntity)api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
