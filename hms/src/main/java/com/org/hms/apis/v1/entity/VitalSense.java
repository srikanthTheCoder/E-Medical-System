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

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private String id;

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

}
