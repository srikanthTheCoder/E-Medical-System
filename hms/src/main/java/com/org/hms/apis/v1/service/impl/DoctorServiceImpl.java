package com.org.hms.apis.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.hms.apis.exceptions.DoctorNotFoundException;
import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.repositary.DoctorRepositary;
import com.org.hms.apis.v1.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	DoctorRepositary doctorRepo;

	@Autowired
	public DoctorServiceImpl(DoctorRepositary doctorRepo) {
		this.doctorRepo = doctorRepo;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		doctorRepo.findAll().forEach(doc -> doctor.add(doc));
		return doctor;
	}

	@Override
	public ResponseDTO addDoctor(Doctor doctor) {
		
		Doctor doc = doctorRepo.save(doctor);
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Added Successfully");
		responseDTO.setId(doc.getId());
		return responseDTO;
	}

	@Override
	public Doctor getDoctorByName(String name) {

		Optional<Doctor> doc = doctorRepo.findByName(name);
		return Optional.ofNullable(doc.get())
				.orElseThrow(() -> new DoctorNotFoundException("Doctor Not found in name :" + name));
	}

	@Override
	public Doctor getDoctorById(Long id) {
		
		Optional<Doctor> doc = doctorRepo.findById(id);
		return Optional.ofNullable(doc.get())
				.orElseThrow(() -> new DoctorNotFoundException("Doctor Not found for ID :" + id));
	}

	@Override
	public ResponseDTO updateDoctor(Long id, Doctor doctor) {
		Optional<Doctor> doc = doctorRepo.findById(id);
		ResponseDTO responseDTO = new ResponseDTO();
		if (doc.isPresent()) {
			doctor.setId(id);
			Doctor docs = doctorRepo.saveAndFlush(doctor);
			responseDTO.setMessage("Updated Successfully");
			responseDTO.setId(docs.getId());
		}
		return responseDTO;
	}

}
