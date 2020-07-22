package com.org.hms.apis.v1.models;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.org.hms.apis.v1.validators.EnumValidator;

public class PatientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "{NotBlank.Patient.name}")
	@Size(max = 60, message = "{Size.Patient.name}")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "{Pattern.Patient.name}")
	private String name;

	@NotBlank(message = "{NotBlank.Patient.age}")
	@Min(value = 18, message = "{Size.Patient.age}")
	@Pattern(regexp = "^[0-9]+$", message = "{Pattern.Patient.age}")
	private String age;

	@EnumValidator(enumType = GenderType.class, message = "{EnumValidator.Patient.gender}", anyOf = GenderType.TYPES, required = false)
	private String gender;

	@NotBlank(message = "{NotBlank.Patient.name}")
	@Size(max = 100, message = "{Size.Patient.name}")
	private String description;

	private OffsetDateTime createdOn = OffsetDateTime.now();

	private VitalSenseDTO vitalSense;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(OffsetDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public VitalSenseDTO getVitalSense() {
		return vitalSense;
	}

	public void setVitalSense(VitalSenseDTO vitalSense) {
		this.vitalSense = vitalSense;
	}


}
