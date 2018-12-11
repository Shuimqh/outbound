package com.company.bean;

import java.io.Serializable;

import com.company.data.ho.CustomerInfo;

public class CustomerInfoBean implements Serializable{

	private String tel;

	public CustomerInfo beanToHo(){
		CustomerInfo c=new CustomerInfo();
		c.setTel(this.getTel());
		return c;
	}
	public CustomerInfoBean hoToBean(CustomerInfo c){
		this.setTel(c.getTel());
		return this;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
