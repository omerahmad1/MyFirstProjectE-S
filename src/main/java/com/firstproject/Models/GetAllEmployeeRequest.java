package com.firstproject.Models;

public class GetAllEmployeeRequest {
	private int id;
	private String name;
	private String email;
	private String number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "GetEmployeeRequest [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}
	

}
