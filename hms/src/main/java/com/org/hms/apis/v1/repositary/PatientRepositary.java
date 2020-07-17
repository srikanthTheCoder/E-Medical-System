package com.org.hms.apis.v1.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.hms.apis.v1.entity.Patient;

public interface PatientRepositary extends JpaRepository<Patient, Long> {

}
