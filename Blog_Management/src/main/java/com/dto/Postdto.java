package com.dto;

public class Postdto {
	private String Email;
	private String Title;
	private String Category;
	private String Blog;
	private int pid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getBlog() {
		return Blog;
	}
	public void setBlog(String blog) {
		Blog = blog;
	}


}
