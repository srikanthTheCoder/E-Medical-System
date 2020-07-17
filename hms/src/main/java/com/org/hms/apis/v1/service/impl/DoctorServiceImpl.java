package com.org.hms.apis.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.DoctorResponse;
import com.org.hms.apis.v1.models.Doctors;
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
	public List<Doctors> getAllDoctors() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		List<Doctors> doctors = new ArrayList<Doctors>();
		doctorRepo.findAll().forEach(doc -> doctor.add(doc));
		
		doctor.forEach(doc -> doctors.add(new ObjectMapper().convertValue(doc, Doctors.class)));

		return doctors;
	}

	@Override
	public DoctorResponse addDoctor(Doctors doctor) {
		
		Doctor doc = new ObjectMapper().convertValue(doctor, Doctor.class);
		Doctor doc1 = doctorRepo.save(doc);
		DoctorResponse response = new DoctorResponse();
		response.setMessage("Added Successfully");
		response.setId(doc1.getId());
		return response;
	}

}
