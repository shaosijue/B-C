package net.yasite.model;

import android.content.Context;

public class OrderModel_copy extends Model {
	public OrderModel_copy(Context context){
		this.context = context;
	}
	
	public void createOrder(){
		if(isLogin()){
			if(isAddressInfo()){
				//生成订单
			}
		}
	}
	
	private boolean isLogin(){
		return true;
	}
	private boolean isAddressInfo(){
		return true;
	}
	
}

