package com.org.hms.apis.v1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.hms.apis.v1.V1DoctorAPI;
import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.service.DoctorService;

@Validated
@RestController
public class DoctorController implements V1DoctorAPI{

	DoctorService service;

	@Autowired
	public DoctorController(DoctorService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<List<Doctor>> showAllDoctors() {

		List<Doctor> doc = service.getAllDoctors();
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}

	@Override
	public ResponseEntity<ResponseDTO> addDoctor(@Valid @RequestBody Doctor doctor) {

		ResponseDTO responseDTO = service.addDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	@Override
	public ResponseEntity<Doctor> doctorViewByName(String name) {
		Doctor doc = service.getDoctorByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}


	@Override
	public ResponseEntity<Doctor> doctorViewById(Long id) {
		Doctor doc = service.getDoctorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}


	@Override
	public ResponseEntity<ResponseDTO> updateDoctor(Long id, Doctor doctor) {
		ResponseDTO responseDTO = service.updateDoctor(id, doctor);
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}


}
