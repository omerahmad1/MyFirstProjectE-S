package com.firstproject.Models;

public class ConflictEmployeeResponse {
	private String code ;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ConflictEmployeeResponse [code=" + code + ", message=" + message + "]";
	}
	

}
