package com.org.hms.apis.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.hms.apis.exceptions.DoctorNotFoundException;
import com.org.hms.apis.v1.convertor.IDoctor;
import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.DoctorDTO;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.repositary.DoctorRepositary;
import com.org.hms.apis.v1.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	DoctorRepositary doctorRepo;
	IDoctor doctorMapper;

	@Autowired
	public DoctorServiceImpl(DoctorRepositary doctorRepo, IDoctor doctorMapper) {
		this.doctorRepo = doctorRepo;
		this.doctorMapper = doctorMapper;
	}

	@Override
	public List<DoctorDTO> getAllDoctors() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		List<DoctorDTO> doctorList = new ArrayList<DoctorDTO>();
		doctorRepo.findAll().forEach(doc -> doctor.add(doc));
		for (Doctor doc : doctor) {
			DoctorDTO doctorDto = doctorMapper.convertDoctorToDoctorDTO(doc);
			doctorList.add(doctorDto);
		}
		return doctorList;
	}

	@Override
	public ResponseDTO addDoctor(DoctorDTO doctorDTO) {

		Doctor doctor = doctorMapper.convertDoctorDTOToDoctor(doctorDTO);
		Doctor doc = doctorRepo.save(doctor);
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Added Successfully");
		responseDTO.setId(doc.getId());
		return responseDTO;
	}

	@Override
	public DoctorDTO getDoctorByName(String name) {

		Optional<Doctor> doc = doctorRepo.findByName(name);
		if (doc.isPresent()) {
			DoctorDTO doctorDto = doctorMapper.convertDoctorToDoctorDTO(doc.get());
			return doctorDto;
		} else {
			throw new DoctorNotFoundException("Doctor Not found in name :" + name);
		}
	}

	@Override
	public DoctorDTO getDoctorById(Long id) {
		
		Optional<Doctor> doc = doctorRepo.findById(id);
		if (doc.isPresent()) {
			DoctorDTO doctorDto = doctorMapper.convertDoctorToDoctorDTO(doc.get());
			return doctorDto;
		} else {
			throw new DoctorNotFoundException("Doctor Not found for id  :" + id);
		}
	}

	@Override
	public ResponseDTO updateDoctor(Long id, DoctorDTO doctor) {
		Optional<Doctor> doc = doctorRepo.findById(id);
		Doctor doct = doctorMapper.convertDoctorDTOToDoctor(doctor);
		ResponseDTO responseDTO = new ResponseDTO();
		if (doc.isPresent()) {
			doct.setId(id);
			Doctor docs = doctorRepo.saveAndFlush(doct);
			responseDTO.setMessage("Updated Successfully");
			responseDTO.setId(docs.getId());
		}
		return responseDTO;
	}

}
