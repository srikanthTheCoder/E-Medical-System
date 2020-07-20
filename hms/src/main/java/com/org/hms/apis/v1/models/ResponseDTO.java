package com.org.hms.apis.v1.models;

import java.time.OffsetDateTime;

public class ResponseDTO {

	private Long id;
	private OffsetDateTime createdTime = OffsetDateTime.now();
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(OffsetDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
