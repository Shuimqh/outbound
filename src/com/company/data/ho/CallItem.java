package com.company.data.ho;

import java.io.Serializable;
import java.util.Date;

public class CallItem implements Serializable{
	private String id;
	private String callType;
	private String status;
	private Date CreateDate;
	private String CreateUser;
	private String BizType;
	private String BizSubType;
	private String Char05;
	private String Char02;
	private Date Date03;
	private String time1;
	private String time2;
	public String getBizType() {
		return BizType;
	}
	public void setBizType(String bizType) {
		BizType = bizType;
	}
	//private String status;
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
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public String getCreateUser() {
		return CreateUser;
	}
	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}
	public String getBizSubType() {
		return BizSubType;
	}
	public void setBizSubType(String bizSubType) {
		BizSubType = bizSubType;
	}
	public String getChar05() {
		return Char05;
	}
	public void setChar05(String char05) {
		Char05 = char05;
	}
	public String getChar02() {
		return Char02;
	}
	public void setChar02(String char02) {
		Char02 = char02;
	}
	public Date getDate03() {
		return Date03;
	}
	public void setDate03(Date date03) {
		Date03 = date03;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}

}
