package com.org.hms.apis.v1;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.hms.apis.exceptions.models.ErrorResponse;
import com.org.hms.apis.v1.entity.Patient;
import com.org.hms.apis.v1.models.ResponseDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/api/v1/patient")
public interface V1PatientAPI {
	
	
	@GetMapping("/")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Patient.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<List<Patient>> showAllPatients();
	
	
	@GetMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Patient.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<Patient> patientViewById(@PathVariable("id") Long id);
	
	
	@PostMapping(value = "/addPatient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Patient.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<ResponseDTO> addPatient(@RequestBody Patient doctors);
	
	@PutMapping(value = "/updatePatient/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Patient.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<ResponseDTO> updatePatient(@PathVariable("id") Long id, @RequestBody Patient doctors);
}
