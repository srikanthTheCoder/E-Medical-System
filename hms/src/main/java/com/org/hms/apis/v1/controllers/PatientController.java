package com.org.hms.apis.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.org.hms.apis.v1.V1PatientAPI;
import com.org.hms.apis.v1.models.PatientDTO;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.service.PatientService;

@Validated
@RestController
public class PatientController implements V1PatientAPI{

	PatientService service;

	@Autowired
	public PatientController(PatientService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<List<PatientDTO>> showAllPatients() {
		List<PatientDTO> patients = service.getAllPatients();
		return ResponseEntity.status(HttpStatus.OK).body(patients);
	}

	@Override
	public ResponseEntity<PatientDTO> patientViewById(Long id) {
		PatientDTO patient = service.getPatientById(id);
		return ResponseEntity.status(HttpStatus.OK).body(patient);
	}

	@Override
	public ResponseEntity<ResponseDTO> addPatient(PatientDTO patient) {
		ResponseDTO response = service.addPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<ResponseDTO> updatePatient(Long id, PatientDTO patient) {
		ResponseDTO response = service.updatePatient(id, patient);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}



}
