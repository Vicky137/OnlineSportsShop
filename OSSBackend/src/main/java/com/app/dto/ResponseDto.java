package com.app.dto;

import java.time.LocalDateTime;

public class ResponseDto {
	private String message;
	private LocalDateTime ts;
	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}
	public ResponseDto(String message) {
		super();
		this.message = message;
		this.ts=LocalDateTime.now();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTs() {
		return ts;
	}
	public void setTs(LocalDateTime ts) {
		this.ts = ts;
	}
	
	

}
