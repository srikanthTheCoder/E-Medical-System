package com.org.hms.apis.v1.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedBy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PATIENTS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	private String id;

	@Column(name = "NAME", nullable = false)
	@NotNull
	private String name;

	@Column(name = "AGE", nullable = false)
	@NotNull
	private String age;

	@Column(name = "GENDER", nullable = false)
	@NotNull
	private String gender;

	@Column(name = "DESCRIPTION", nullable = false)
	@NotNull
	private String description;

	@CreatedBy
	@Column(name = "CREATED_ON", nullable = false)
	@NotNull
	private OffsetDateTime createdOn = OffsetDateTime.now();


}