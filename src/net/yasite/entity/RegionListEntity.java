package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class RegionListEntity implements Serializable {

	private List<RegionEntity> data;
	private int res;

	public List<RegionEntity> getData() {
		return data;
	}

	public void setData(List<RegionEntity> data) {
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}
}
