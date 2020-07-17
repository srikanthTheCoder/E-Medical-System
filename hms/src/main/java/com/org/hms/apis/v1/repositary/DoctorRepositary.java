package com.org.hms.apis.v1.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.hms.apis.v1.entity.Doctor;

public interface DoctorRepositary extends JpaRepository<Doctor, Long> {

}
