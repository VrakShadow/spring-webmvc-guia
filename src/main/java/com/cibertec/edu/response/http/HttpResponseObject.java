package com.cibertec.edu.response.http;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class HttpResponseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public ErrorClass getError() {
		return error;
	}

	public void setError(ErrorClass error) {
		this.error = error;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private HttpStatus code;
	private ErrorClass error;
	private String text;
	private Object data;

	
	
	public HttpResponseObject(String status, HttpStatus code, Object data) {
		super();
		this.status = status;
		this.code = code;
		this.data = data;
	}
	
	public HttpResponseObject(String status, HttpStatus code, Object data, String texto) {
		super();
		this.status = status;
		this.code = code;
		this.data = data;
		this.text = texto != null? texto : "";
	}
}
