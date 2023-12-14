package com.leonardo.bookstore.exception;

public class StandardError {
	
	private Long timestamp;
	private int status;
	private String error;



	public StandardError(Long timestamp, int status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}


	public StandardError(long timeMillis, int value, String message) {
		// TODO Auto-generated constructor stub
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}
	
	
}
