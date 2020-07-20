package com.org.hms.apis.v1.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "VITAL_SENSE")
public class VitalSense implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@JsonIgnore
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", nullable = false)
	@NotNull
	@JsonBackReference
	private Patient patient;

	@Column(name = "HEIGHT", nullable = false)
	@NotNull
	private String height;

	@Column(name = "WEIGHT", nullable = false)
	@NotNull
	private String weight;

	@Column(name = "BODY_TEMPERATURE", nullable = false)
	@NotNull
	private String bodyTemperature;

	@Column(name = "BLOOD_PRESSURE", nullable = false)
	@NotNull
	private String bloodPressure;

	@Column(name = "HEART_RATE", nullable = false)
	@NotNull
	private String heartRate;

	@Column(name = "RESPIRATORY_RATE", nullable = false)
	@NotNull
	private String respiratoryRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBodyTemperature() {
		return bodyTemperature;
	}

	public void setBodyTemperature(String bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

}
