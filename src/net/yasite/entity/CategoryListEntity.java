package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class CategoryListEntity implements Serializable {

	private List<CategoryEntity> data;
	private int res;

	public List<CategoryEntity> getData() {
		return data;
	}

	public void setData(List<CategoryEntity> data) {
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}
