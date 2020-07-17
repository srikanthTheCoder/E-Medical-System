package com.org.hms.apis.v1.models;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class DoctorResponse {

	private Long id;
	private OffsetDateTime createdTime = OffsetDateTime.now();
	private String message;

}
