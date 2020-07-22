package com.org.hms.apis.v1.models;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.org.hms.apis.v1.validators.EnumValidator;

import io.swagger.v3.oas.annotations.media.Schema;

public class DoctorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "{NotBlank.Doctor.name}")
	@Size(max = 60, message = "{Size.Doctor.name}")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "{Pattern.Doctor.name}")
	private String name;

	@NotBlank(message = "{NotBlank.Doctor.age}")
	@Min(value = 18, message = "{Size.Doctor.age}")
	@Pattern(regexp = "^[0-9]+$", message = "{Pattern.Doctor.age}")
	private String age;

	@EnumValidator(enumType = GenderType.class, message = "{EnumValidator.Doctor.gender}", anyOf = GenderType.TYPES, required = false)
	private String gender;

	@EnumValidator(enumType = DoctorSpecialization.class, message = "{EnumValidator.Doctor.Specialization}", anyOf = DoctorSpecialization.TYPES, required = false)
	private String Specialization;

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
