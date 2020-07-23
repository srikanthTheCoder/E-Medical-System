package com.org.hms.apis.v1.convertor;

import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.DoctorDTO;

@Mapper(componentModel = "spring")
public interface IDoctor {

	IDoctor INSTANCE = Mappers.getMapper(IDoctor.class);

	@Mappings({ @Mapping(target = "id", source = "id"),
			@Mapping(target = "name", source = "name"), @Mapping(target = "age", source = "age"),
			@Mapping(target = "gender", source = "gender"),
			@Mapping(target = "emailID", source = "emailID") })
	public DoctorDTO convertDoctorToDoctorDTO(Doctor doctor);

	@AfterMapping
	default void updateRemittanceSender(DoctorDTO doctorDTO, @MappingTarget Doctor doctor) {
		doctor.setSpecialization(doctorDTO.getSpecialization());
	}
	@InheritInverseConfiguration
	Doctor convertDoctorDTOToDoctor(DoctorDTO doctorDTO);

}
