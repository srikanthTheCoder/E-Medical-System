package com.org.hms.apis.v1.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.org.hms.apis.v1.V1PatientAPI;
import com.org.hms.apis.v1.models.Doctors;

@Validated
@RestController
public class PatientController implements V1PatientAPI{

	@Override
	public ResponseEntity<List<Doctors>> showAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Doctors> patientViewByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Doctors> patientViewById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPatient(Doctors doctors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePatient(long id, Doctors doctors) {
		// TODO Auto-generated method stub
		
	}

}
