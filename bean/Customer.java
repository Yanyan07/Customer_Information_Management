package com.atproject1.bean;

//Customer class: encapsulate customer information
public class Customer {
	private String name;
	private char gender;
	private int age;
	private String phone;
	
	public Customer() {
	}

	public Customer(String name, char gender, int age, String phone) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
