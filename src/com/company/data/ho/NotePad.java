package com.company.data.ho;

import java.io.Serializable;

public class NotePad implements Serializable{
	private int  id;
	private String title;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
