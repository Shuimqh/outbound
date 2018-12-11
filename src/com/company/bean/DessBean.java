package com.company.bean;

import java.io.Serializable;

import com.company.data.ho.DessTx;

public class DessBean implements Serializable{
	private String id;
	private String tel;
	private String dess;
	
	public DessTx beanToHo(){
		DessTx d=new DessTx();
		d.setId(this.getId());
		d.setTel(this.getTel());
		d.setDess(this.getDess());
		return d;
	}
	public DessBean hoToBean(DessTx d){
		this.setId(d.getId());
		this.setTel(d.getTel());
		this.setDess(d.getDess());
		return this;
	}
	
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
