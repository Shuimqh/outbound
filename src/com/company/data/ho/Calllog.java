package com.company.data.ho;

import java.io.Serializable;

public class Calllog implements Serializable{
	private String id;
	private String timetype;
	private int TalkDuration;
	private String AgentId;
	private int numa;
	private int nums;
	private String num;
	private String name;
	
	private String numss;
	private int numm;
	
	private String time1;
	private String time2;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimetype() {
		return timetype;
	}
	public void setTimetype(String timetype) {
		this.timetype = timetype;
	}
	public int getTalkDuration() {
		return TalkDuration;
	}
	public void setTalkDuration(int talkDuration) {
		TalkDuration = talkDuration;
	}
	public String getAgentId() {
		return AgentId;
	}
	public void setAgentId(String agentId) {
		AgentId = agentId;
	}
	public int getNuma() {
		return numa;
	}
	public void setNuma(int numa) {
		this.numa = numa;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getNumm() {
		return numm;
	}
	public void setNumm(int numm) {
		this.numm = numm;
	}
	public String getNumss() {
		return numss;
	}
	public void setNumss(String numss) {
		this.numss = numss;
	}
}
