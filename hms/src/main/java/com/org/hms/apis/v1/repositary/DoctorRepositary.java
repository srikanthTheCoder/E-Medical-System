package com.org.hms.apis.v1.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.hms.apis.v1.entity.Doctor;

@Repository
public interface DoctorRepositary extends JpaRepository<Doctor, Long> {

	Optional<Doctor> findByName(String name);

}
