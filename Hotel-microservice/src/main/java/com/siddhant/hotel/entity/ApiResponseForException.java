package com.siddhant.hotel.entity;

public class ApiResponseForException {

	private String msg;
	private boolean success;
	private String status;
	public ApiResponseForException() {
		super();
	}
	public ApiResponseForException(String msg, boolean success, String status) {
		super();
		this.msg = msg;
		this.success = success;
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
