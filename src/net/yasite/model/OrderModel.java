package net.yasite.model;

import net.yasite.entity.AddressEntity;
import net.yasite.service.OrderService;
import android.content.Context;

public class OrderModel extends Model {

	OrderService orderService;
	
	public OrderModel(Context context){
		this.context = context;
		orderService = new OrderService(context);
	}
	
	public Object createOrder(String user_id,String ad){
		return orderService.createOrder(user_id, ad);
	}
	
	public Object getOrderList(String id){
		return orderService.getOrderList(id);
	}
	
	public void cancelOrder(String id){
		orderService.cancelOrder(id);
	}
}
