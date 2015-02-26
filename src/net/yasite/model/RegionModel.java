package net.yasite.model;

import net.yasite.service.RegionService;
import android.content.Context;

public class RegionModel extends Model {

	RegionService getRegionService;
	
	public RegionModel(Context context){
		this.context = context;
		getRegionService = new RegionService(context);
	}
	
	public Object getRegion(String parentId){
		return getRegionService.getRegion(parentId);
	}
}
