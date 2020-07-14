package com.org.hms.apis.v1.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.org.hms.apis.v1.V1DoctorAPI;
import com.org.hms.apis.v1.models.Doctor;

@Validated
@RestController
public class DoctorController implements V1DoctorAPI{

	@Override
	public ResponseEntity<List<Doctor>> showAllDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Doctor> doctorViewByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<Doctor>> doctorViewById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDoctor(long id, Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

}
