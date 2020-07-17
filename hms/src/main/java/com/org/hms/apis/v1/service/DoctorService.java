package com.org.hms.apis.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.hms.apis.v1.models.DoctorResponse;
import com.org.hms.apis.v1.models.Doctors;

@Service
public interface DoctorService {

	List<Doctors> getAllDoctors();

	DoctorResponse addDoctor(Doctors doctor);

}
