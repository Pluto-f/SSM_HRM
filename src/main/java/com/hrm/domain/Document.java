package com.hrm.domain;


import org.springframework.web.multipart.MultipartFile;

public class Document{
	private Integer id;
	private String title;
	private String filename;
	private String filepath;
	private String remark;
	private String create_date;
	private String username;
	private MultipartFile file;

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Document{" +
				"id=" + id +
				", title='" + title + '\'' +
				", filename='" + filename + '\'' +
				", filepath='" + filepath + '\'' +
				", remark='" + remark + '\'' +
				", create_date='" + create_date + '\'' +
				", username='" + username + '\'' +
				", file=" + file +
				'}';
	}
}
