package com.org.hms.apis.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.hms.apis.v1.models.PatientDTO;
import com.org.hms.apis.v1.models.ResponseDTO;

@Service
public interface PatientService {

	List<PatientDTO> getAllPatients();

	ResponseDTO addPatient(PatientDTO patient);

	PatientDTO getPatientById(Long id);

	ResponseDTO updatePatient(Long id, PatientDTO patient);

}
