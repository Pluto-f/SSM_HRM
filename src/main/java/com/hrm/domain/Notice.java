package com.hrm.domain;


public class Notice{
	private Integer id;
	private String title;
	private String content;
	private String Create_date;
	private String username;

	public Notice(){
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreate_date() {
		return Create_date;
	}
	public void setCreate_date(String create_date) {
		this.Create_date=create_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Notice{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", Create_date='" + Create_date + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
