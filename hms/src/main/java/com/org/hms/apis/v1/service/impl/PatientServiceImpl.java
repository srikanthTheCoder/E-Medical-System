package com.org.hms.apis.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.hms.apis.exceptions.PatientNotFoundException;
import com.org.hms.apis.v1.convertor.IPatient;
import com.org.hms.apis.v1.entity.Patient;
import com.org.hms.apis.v1.models.PatientDTO;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.repositary.PatientRepositary;
import com.org.hms.apis.v1.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	PatientRepositary patientRepo;
	IPatient patientMapper;

	@Autowired
	public PatientServiceImpl(PatientRepositary patientRepo, IPatient patientMapper) {
		this.patientRepo = patientRepo;
		this.patientMapper = patientMapper;
	}

	@Override
	public List<PatientDTO> getAllPatients() {
		List<PatientDTO> patientList = new ArrayList<PatientDTO>();
		List<Patient> patient = new ArrayList<Patient>();
		patientRepo.findAll().forEach(pat -> patient.add(pat));
		for (Patient pat : patient) {
			PatientDTO patientDto = patientMapper.convertPatientToPatientDTO(pat);
			patientList.add(patientDto);
		}
		return patientList;
	}

	@Override
	public ResponseDTO addPatient(PatientDTO patientDTO) {

		Patient patient = patientMapper.convertPatientDTOToPatient(patientDTO);
		patient = patientRepo.save(patient);
		ResponseDTO response = new ResponseDTO();
		response.setMessage("Added Successfully");
		response.setId(patient.getId());
		return response;
	}

	@Override
	public PatientDTO getPatientById(Long id) {
		Optional<Patient> patient = patientRepo.findById(id);
		if (patient.isPresent()) {
			PatientDTO patientDto = patientMapper.convertPatientToPatientDTO(patient.get());
			return patientDto;
		} else {
			throw new PatientNotFoundException("Doctor Not found by id :" + id);
		}
	}

	@Override
	public ResponseDTO updatePatient(Long id, PatientDTO patientDTO) {
		Optional<Patient> patients = patientRepo.findById(id);
		Patient patient = patientMapper.convertPatientDTOToPatient(patientDTO);
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
