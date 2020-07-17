package com.org.hms.apis.v1.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class VitalSenseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String height;
	private String weight;
	private String bodyTemperature;
	private String bloodPressure;
	private String heartRate;
	private String respiratoryRate;

}
