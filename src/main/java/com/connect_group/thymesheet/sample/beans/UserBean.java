package com.connect_group.thymesheet.sample.beans;

public class UserBean {
	private String login;
	private String name;
	private String address;
	
	public UserBean(String login, String name, String address) {
		this.login=login;
		this.name=name;
		this.address=address;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
