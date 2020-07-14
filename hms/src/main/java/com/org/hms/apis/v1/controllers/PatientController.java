package com.org.hms.apis.v1.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.org.hms.apis.v1.V1PatientAPI;
import com.org.hms.apis.v1.models.Doctor;

@Validated
@RestController
public class PatientController implements V1PatientAPI{

	@Override
	public ResponseEntity<List<Doctor>> showAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Doctor> patientViewByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Doctor> patientViewById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPatient(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePatient(long id, Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

}
