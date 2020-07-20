package com.org.hms.apis.v1.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.ResponseDTO;

@Service
public interface DoctorService {

	List<Doctor> getAllDoctors();

	ResponseDTO addDoctor(Doctor doctor);

	@Cacheable(value = "doctors", key = "#name")
	Doctor getDoctorByName(String name);

	@Cacheable(value = "doctors", key = "#id")
	Doctor getDoctorById(Long id);

	ResponseDTO updateDoctor(Long id, Doctor doctor);

}
