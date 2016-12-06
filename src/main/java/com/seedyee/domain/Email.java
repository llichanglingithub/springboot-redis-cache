package com.seedyee.domain;

import org.springframework.data.annotation.Id;

/**
 * @author lcl
 * @createDate 2016年11月21日下午5:04:30
 *
 */
public class Email {
	@Id
	private String id;
	private String email;
	private String userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
