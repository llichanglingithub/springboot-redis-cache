package com.seedyee.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * @author lcl
 * @createDate 2016年11月21日下午5:00:34
 *
 */
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 54646541351541L;
	@Id
	private String id;
	private String name;
	private String relName;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
