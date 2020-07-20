package com.org.hms.apis.v1.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.org.hms.apis.v1.models.GenderType;
import com.org.hms.apis.v1.validators.EnumValidator;

@Entity
@Table(name = "PATIENTS")
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@JsonIgnore
	private Long id;

	@Column(name = "NAME", nullable = false)
	@NotNull
	@NotBlank(message = "{NotBlank.Doctor.name}")
	@Size(max = 60, message = "{Size.Doctor.name}")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "{Pattern.Doctor.name}")
	private String name;

	@Column(name = "AGE", nullable = false)
	@NotNull
	@NotBlank(message = "{NotBlank.Doctor.age}")
	@Min(value = 18, message = "{Size.Doctor.age}")
	@Pattern(regexp = "^[0-9]+$", message = "{Pattern.Doctor.age}")
	private String age;

	@Column(name = "GENDER", nullable = false)
	@NotNull
	@EnumValidator(enumType = GenderType.class, message = "{EnumValidator.Doctor.gender}", anyOf = GenderType.TYPES, required = false)
	private String gender;

	@Column(name = "DESCRIPTION", nullable = false)
	@NotNull
	@NotBlank(message = "{NotBlank.Doctor.name}")
	@Size(max = 100, message = "{Size.Doctor.name}")
	private String description;

	@CreatedBy
	@Column(name = "CREATED_ON", nullable = false)
	@NotNull
	private OffsetDateTime createdOn = OffsetDateTime.now();

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.LAZY, orphanRemoval = true)
	@NotNull
	@JsonManagedReference
	private VitalSense vitalSense;

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

	public VitalSense getVitalSense() {
		return vitalSense;
	}

	public void setVitalSense(VitalSense vitalSense) {
		this.vitalSense = vitalSense;
	}


}
