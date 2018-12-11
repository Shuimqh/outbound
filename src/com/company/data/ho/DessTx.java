package com.company.data.ho;

import java.io.Serializable;

public class DessTx implements Serializable{
	private String id;
	private String tel;
	private String dess;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDess() {
		return dess;
	}
	public void setDess(String dess) {
		this.dess = dess;
	}

}
