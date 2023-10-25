package com.cibertec.edu.response.http;

import org.springframework.http.HttpStatus;

public class ErrorClass {
	
	private HttpStatus code;
	public HttpStatus getCode() {
		return code;
	}
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String message;
	private String content;
	
	public ErrorClass() {
		
	}
	
	public Boolean existError() {
		if (this.code != null) {
			return true;
		}
		
		return false;
	}
	
}
