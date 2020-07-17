package com.org.hms.apis.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.org.hms.apis.v1.V1DoctorAPI;
import com.org.hms.apis.v1.models.DoctorResponse;
import com.org.hms.apis.v1.models.Doctors;
import com.org.hms.apis.v1.service.DoctorService;

@Validated
@RestController
@RefreshScope
public class DoctorController implements V1DoctorAPI{

	DoctorService service;

	@Autowired
	public DoctorController(DoctorService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<List<Doctors>> showAllDoctors() {

		List<Doctors> doc = service.getAllDoctors();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(doc);
	}

	@Override
	public DoctorResponse addDoctor(Doctors doctor) {

		return service.addDoctor(doctor);

	}

	@Override
	public ResponseEntity<Doctors> doctorViewByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<List<Doctors>> doctorViewById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateDoctor(String id, Doctors doctors) {
		// TODO Auto-generated method stub
		
	}


}
