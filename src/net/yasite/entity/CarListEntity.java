package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class CarListEntity implements Serializable {

	private List<CarItemEntity> data;
	private int res;

	public List<CarItemEntity> getData() {
		return data;
	}

	public void setData(List<CarItemEntity> data) {
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}
