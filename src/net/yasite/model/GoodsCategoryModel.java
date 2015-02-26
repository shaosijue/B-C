package net.yasite.model;

import net.yasite.service.GoodsCategoryService;
import android.content.Context;

public class GoodsCategoryModel extends Model {

	GoodsCategoryService goodsCategoryService ;

	public GoodsCategoryModel(Context context) {
		this.context = context;
		goodsCategoryService = new GoodsCategoryService(context);
	}
	
	public Object RequestPost(String id){
		return goodsCategoryService.getGoodsCategory(id);
	}
	
	
}
