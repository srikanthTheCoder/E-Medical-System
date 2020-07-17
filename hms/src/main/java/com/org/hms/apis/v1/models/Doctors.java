package com.org.hms.apis.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctors {

	@JsonIgnore
	private Long id;
	private String name;
	private String age;
	private String gender;
	private String Specialization;
	private String emailID;

}
