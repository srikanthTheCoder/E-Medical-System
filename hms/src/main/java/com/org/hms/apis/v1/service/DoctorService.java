package com.org.hms.apis.v1.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.org.hms.apis.v1.models.DoctorDTO;
import com.org.hms.apis.v1.models.ResponseDTO;

@Service
public interface DoctorService {

	List<DoctorDTO> getAllDoctors();

	ResponseDTO addDoctor(DoctorDTO doctor);

	@Cacheable(value = "doctors", key = "#name")
	DoctorDTO getDoctorByName(String name);

	@Cacheable(value = "doctors", key = "#id")
	DoctorDTO getDoctorById(Long id);

	ResponseDTO updateDoctor(Long id, DoctorDTO doctor);

}
