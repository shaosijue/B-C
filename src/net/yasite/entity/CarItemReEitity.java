package net.yasite.entity;

import java.io.Serializable;

public class CarItemReEitity implements Serializable{

	CarItemEntity data;
	int res;
	public CarItemEntity getData() {
		return data;
	}
	public void setData(CarItemEntity data) {
		this.data = data;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
}
