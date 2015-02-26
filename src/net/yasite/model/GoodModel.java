package net.yasite.model;

import net.yasite.entity.GoodListEntity;
import net.yasite.entity.MyGoodEntity;
import net.yasite.service.GoodService;
import android.content.Context;

public class GoodModel extends Model {
	
	GoodService goodService;
	
	public GoodModel(Context context){
		this.context = context;
		goodService = new GoodService(context);
	}
	
	
	public GoodListEntity RequestGoodList(String page,String id){
		return goodService.getGoodList(page,id);
	}
	
	public MyGoodEntity RequestGoodInfo(String id){
		return goodService.getGoodInfo(id);
	}
	
}
