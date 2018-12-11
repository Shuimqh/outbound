package com.company.data.ho;

import java.io.Serializable;

public class UserTel implements Serializable{
	private String tel;
	private String userNo;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
}
