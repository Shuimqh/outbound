package com.company.bean;

import java.io.Serializable;
import java.util.Map;



public class CjlBean implements Serializable{
	private String id;
	private String callType;
	private String status;
	private String CreateDate;
	private String Cname;
	private String BizType;
	private String BizSubType;
	private String TelephonistGroupId;
	private String CreateUser;
	private String gh;
	private String num;
	private String numa;
	private String numss;
	private String numee;
	private String numm;
	private String numw;
	private String nums;
	
	
	private int numa_;
	private int nums_;
	private String numss_;
	private String num_;
	public String getCreateUser() {
		return CreateUser;
	}



	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}



	public CjlBean mapToBean(Map map){
		CjlBean cb=new CjlBean();
		if(null !=map.get("Cname")){
			cb.setCname((String)map.get("Cname"));
			System.out.print(map.get("Cname") + "\t");
		}
		if(null !=map.get("BizType")){
			cb.setBizType((String)map.get("BizType"));
			System.out.print(map.get("BizType") + "\t");
		}
		if(null !=map.get("BizSubType")){
			cb.setBizSubType((String)map.get("BizSubType"));
			System.out.print(map.get("BizSubType") + "\t");
		}
		if(null !=map.get("status")){
			cb.setStatus((String)map.get("status"));
			System.out.print(map.get("status") + "\t");
		}
		if(null !=map.get("TelephonistGroupId")){
			cb.setTelephonistGroupId((String)map.get("TelephonistGroupId"));
			System.out.print(map.get("TelephonistGroupId") + "\t");
		}
		if(null !=map.get("nums")){
			cb.setNums((Long)map.get("nums")+"");
			System.out.print(map.get("nums") + "\t");
		}
		if(null !=map.get("num")){
			cb.setNum((Long)map.get("num")+"");
			System.out.print(map.get("num") + "\t");
		}
		if(null !=map.get("numa")){
			cb.setNuma((Long)map.get("numa")+"");
			System.out.println(map.get("numa"));
		}
		return cb;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getTelephonistGroupId() {
		return TelephonistGroupId;
	}
	public void setTelephonistGroupId(String telephonistGroupId) {
		TelephonistGroupId = telephonistGroupId;
	}



	public String getBizType() {
		return BizType;
	}



	public void setBizType(String bizType) {
		BizType = bizType;
	}



	public String getBizSubType() {
		return BizSubType;
	}



	public void setBizSubType(String bizSubType) {
		BizSubType = bizSubType;
	}






	public String getNums() {
		return nums;
	}



	public void setNums(String nums) {
		this.nums = nums;
	}



	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
	}



	public String getNuma() {
		return numa;
	}



	public void setNuma(String numa) {
		this.numa = numa;
	}



	public String getNumss() {
		return numss;
	}



	public void setNumss(String numss) {
		this.numss = numss;
	}



	public String getNumee() {
		return numee;
	}



	public void setNumee(String numee) {
		this.numee = numee;
	}



	public String getNumm() {
		return numm;
	}



	public void setNumm(String numm) {
		this.numm = numm;
	}



	public String getNumw() {
		return numw;
	}



	public void setNumw(String numw) {
		this.numw = numw;
	}



	public int getNuma_() {
		return numa_;
	}



	public void setNuma_(int numa_) {
		this.numa_ = numa_;
	}



	public int getNums_() {
		return nums_;
	}



	public void setNums_(int nums_) {
		this.nums_ = nums_;
	}



	public String getNumss_() {
		return numss_;
	}



	public void setNumss_(String numss_) {
		this.numss_ = numss_;
	}



	public String getNum_() {
		return num_;
	}



	public void setNum_(String num_) {
		this.num_ = num_;
	}



	public String getGh() {
		return gh;
	}



	public void setGh(String gh) {
		this.gh = gh;
	}

}
