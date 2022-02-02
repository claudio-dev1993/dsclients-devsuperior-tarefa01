package com.devsuperior.dstarefa01.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class EntityNotFoundError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public EntityNotFoundError() {

	}
	
	

	public EntityNotFoundError(Instant timeStamp, Integer status, String error, String message, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}



	public Instant getTimestamp() {
		return timeStamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timeStamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
