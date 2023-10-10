package org.pritam.springsecurity.model;

public class Error {
	private int errorCode;
	private String description;
	public Error(int errorCode, String description) {
		super();
		this.errorCode = errorCode;
		this.description = description;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
