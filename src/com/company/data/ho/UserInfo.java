package com.company.data.ho;

import java.io.Serializable;

public class UserInfo implements Serializable{

	private String id;
	private String Cname;
	private String GroupId;
	private String LoginName;
	private String TelephonistGroupId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getGroupId() {
		return GroupId;
	}
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
}
