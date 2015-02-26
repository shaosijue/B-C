package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class MyGoodEntity implements Serializable {

	List<GoodEntity> data;
	int res;

	public List<GoodEntity> getData() {
		return data;
	}

	public void setData(List<GoodEntity> data) {
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}
}
