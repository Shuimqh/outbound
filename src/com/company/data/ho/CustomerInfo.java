package com.company.data.ho;

import java.io.Serializable;

public class CustomerInfo implements Serializable{
	private String tel;
	
	public CustomerInfo(){
		
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
