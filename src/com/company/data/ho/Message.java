package com.company.data.ho;

public class Message {
	private String id;
	private String LoginName;
	private String returnSelectValue;
	private String recvDate;
	public String getRecvDate() {
		return recvDate;
	}
	public void setRecvDate(String recvDate) {
		this.recvDate = recvDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getReturnSelectValue() {
		return returnSelectValue;
	}
	public void setReturnSelectValue(String returnSelectValue) {
		this.returnSelectValue = returnSelectValue;
	}
	
}
