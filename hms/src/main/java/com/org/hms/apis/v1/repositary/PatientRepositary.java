package com.org.hms.apis.v1.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.hms.apis.v1.entity.Patient;

@Repository
public interface PatientRepositary extends JpaRepository<Patient, Long> {

}
