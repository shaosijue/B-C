package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class AddressListEntity implements Serializable {

	List<AddressEntity> data;
	int res;

	public List<AddressEntity> getData() {
		return data;
	}

	public void setData(List<AddressEntity> data) {
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}
}
