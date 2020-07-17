package com.org.hms.apis.v1.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VITAL_SENSE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VitalSense implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String height;
	private String weight;
	private String bodyTemperature;
	private String bloodPressure;
	private String heartRate;
	private String respiratoryRate;

	private String createdOn;
	private String createdBy;
	private String modifiedOn;
	private String modifiedBy;
	private String patient_id;

}
