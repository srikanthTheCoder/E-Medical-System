package com.org.hms.apis.v1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patients {

	private String name;
	private String age;
	private String gender;
	private String description;
	private String createdBy;
}
