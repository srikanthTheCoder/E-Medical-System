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
import com.org.hms.apis.v1.models.DoctorDTO;
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
	public ResponseEntity<List<DoctorDTO>> showAllDoctors() {

		List<DoctorDTO> doc = service.getAllDoctors();
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}

	@Override
	public ResponseEntity<ResponseDTO> addDoctor(@Valid @RequestBody DoctorDTO doctor) {

		ResponseDTO responseDTO = service.addDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}

	@Override
	public ResponseEntity<DoctorDTO> doctorViewByName(String name) {
		DoctorDTO doc = service.getDoctorByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}


	@Override
	public ResponseEntity<DoctorDTO> doctorViewById(Long id) {
		DoctorDTO doc = service.getDoctorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(doc);
	}


	@Override
	public ResponseEntity<ResponseDTO> updateDoctor(Long id, DoctorDTO doctor) {
		ResponseDTO responseDTO = service.updateDoctor(id, doctor);
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}


}
