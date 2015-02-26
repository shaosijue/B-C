package net.yasite.entity;

import java.io.Serializable;

public class RegistEntity implements Serializable {

	private MyUserEntity data;
	private int res;

	public MyUserEntity getData() {
		return data;
	}

	public void setData(MyUserEntity data) {
		this.data = data;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "RegistEntity [data=" + data + ", res=" + res + "]";
	}

}
