package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class OrderListEntity implements Serializable{

	private List<OrderEntity> data;
	int res;
	public List<OrderEntity> getData() {
		return data;
	}
	public void setData(List<OrderEntity> data) {
		this.data = data;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
}
