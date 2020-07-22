package com.org.hms.apis.v1.convertor;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.org.hms.apis.v1.entity.Patient;
import com.org.hms.apis.v1.models.PatientDTO;

@Mapper(componentModel = "spring")
public interface IPatient {

	IPatient INSTANCE = Mappers.getMapper(IPatient.class);

	@Mappings({
			@Mapping(target = "name", source = "name"), @Mapping(target = "age", source = "age"),
			@Mapping(target = "gender", source = "gender"),
			@Mapping(target = "description", source = "description") })
	public PatientDTO convertPatientToPatientDTO(Patient patient);

	@InheritInverseConfiguration
	Patient convertPatientDTOToPatient(PatientDTO patientDTO);

}
