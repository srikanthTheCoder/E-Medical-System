package com.org.hms.apis.v1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.hms.apis.v1.models.DoctorSpecialization;
import com.org.hms.apis.v1.models.GenderType;
import com.org.hms.apis.v1.validators.EnumValidator;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "DOCTORS")
public class Doctor implements Serializable {

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

	@Column(name = "SPECIALIZATION", nullable = false)
	@NotNull
	@EnumValidator(enumType = DoctorSpecialization.class, message = "{EnumValidator.Doctor.Specialization}", anyOf = DoctorSpecialization.TYPES, required = false)
	private String Specialization;

	@Column(name = "EMAIL_ID", nullable = false)
	@NotNull
	@Schema(example = "example@example.com")
	@Pattern(regexp = "^|([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "{Email.Doctor.email}")
	@Size(max = 60, message = "{Size.Doctor.email}")
	private String emailID;

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

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}
