package com.org.hms;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.org.hms.apis.v1.models.DoctorDTO;
import com.org.hms.apis.v1.models.PatientDTO;
import com.org.hms.apis.v1.models.ResponseDTO;
import com.org.hms.apis.v1.models.VitalSenseDTO;

public class DataBuilder {

	public static List<DoctorDTO> stubGetAllDoctorResponse() {
		List<DoctorDTO> doctorList = new ArrayList<>();
		doctorList.add(stubDoctor());
		return doctorList;
	}

	public static DoctorDTO stubDoctor() {
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setAge("23");
		doctorDTO.setGender("MALE");
		doctorDTO.setName("SRIKANTH");
		doctorDTO.setEmailID("sri8394@gmail.com");
		doctorDTO.setSpecialization("Pediatrician");
		return doctorDTO;
	}

	public static ResponseDTO stubResponse() {
		ResponseDTO respone = new ResponseDTO();
		respone.setId(new Long("1"));
		respone.setCreatedTime(OffsetDateTime.now());
		respone.setMessage("Created Successfully");
		return respone;
	}

	public static PatientDTO stubGetPatient() {
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setAge("23");
		patientDTO.setGender("MALE");
		patientDTO.setName("SRIKANTH");
		patientDTO.setDescription("FEVER");
		patientDTO.setCreatedOn(null);
		patientDTO.setVitalSense(setVitalSense());
		return patientDTO;
	}

	public static List<PatientDTO> stubGetAllPatientResponse() {
		List<PatientDTO> patientList = new ArrayList<>();
		patientList.add(stubGetPatient());
		return patientList;
	}

	private static VitalSenseDTO setVitalSense() {
		VitalSenseDTO vitalSense = new VitalSenseDTO();
		vitalSense.setHeartRate("100");
		vitalSense.setBodyTemperature("99");
		vitalSense.setBloodPressure("100");
		vitalSense.setHeight("172");
		vitalSense.setId("1");
		vitalSense.setRespiratoryRate("100");
		vitalSense.setWeight("85");
		return vitalSense;
	}

}
