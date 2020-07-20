package com.org.hms.apis.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.hms.apis.v1.entity.Patient;
import com.org.hms.apis.v1.models.ResponseDTO;

@Service
public interface PatientService {

	List<Patient> getAllPatients();

	ResponseDTO addPatient(Patient patient);

	Patient getPatientById(Long id);

	ResponseDTO updatePatient(Long id, Patient patient);

}
