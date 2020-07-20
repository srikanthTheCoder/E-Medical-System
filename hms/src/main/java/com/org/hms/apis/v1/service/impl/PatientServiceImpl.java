package com.org.hms.apis.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.hms.apis.exceptions.PatientNotFoundException;
import com.org.hms.apis.v1.entity.Patient;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.repositary.PatientRepositary;
import com.org.hms.apis.v1.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	PatientRepositary patientRepo;

	@Autowired
	public PatientServiceImpl(PatientRepositary patientRepo) {
		this.patientRepo = patientRepo;
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> patientList = new ArrayList<Patient>();
		patientRepo.findAll().forEach(doc -> patientList.add(doc));
		return patientList;
	}

	@Override
	public ResponseDTO addPatient(Patient patient) {
		patient = patientRepo.save(patient);
		ResponseDTO response = new ResponseDTO();
		response.setMessage("Added Successfully");
		response.setId(patient.getId());
		return response;
	}

	@Override
	public Patient getPatientById(Long id) {
		Optional<Patient> patient = patientRepo.findById(id);
		return Optional.ofNullable(patient.get())
				.orElseThrow(() -> new PatientNotFoundException("Patient Not found for ID :" + id));
	}

	@Override
	public ResponseDTO updatePatient(Long id, Patient patient) {
		Optional<Patient> patients = patientRepo.findById(id);
		System.out.println(" :: " + patients);
		ResponseDTO responseDTO = new ResponseDTO();
		if (patients.isPresent()) {
			patient.setId(patients.get().getId());
			patient.getVitalSense().setId(patients.get().getVitalSense().getId());
			Patient pat = patientRepo.saveAndFlush(patient);
			responseDTO.setMessage("Updated Successfully");
			responseDTO.setId(pat.getId());
		}
		return responseDTO;
	}

}
