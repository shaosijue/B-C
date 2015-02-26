package net.yasite.model;

import net.yasite.service.CarService;
import android.content.Context;

public class CarModel extends Model {

	CarService carService;
	
	public CarModel(Context context){
		this.context = context;
		carService = new CarService(context);
	}
	
	public Object addGood(String user_id,String goods_id,String goods_sn,String goods_name,String market_price,String goods_price,String goods_number,String token){
		return carService.addGood(user_id, goods_id, goods_sn, goods_name, market_price, goods_price, goods_number, token);
	}
	
	public Object getCarList(String id,String token){
		return carService.getCarList(id, token);
	}
	
	public Object deleteGood(String user_id, String ids, String token){
		return carService.deleteGood(user_id, ids, token);
	}
}
