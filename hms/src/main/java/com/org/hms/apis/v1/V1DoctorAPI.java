package com.org.hms.apis.v1;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.hms.apis.exceptions.models.ErrorResponse;
import com.org.hms.apis.v1.entity.Doctor;
import com.org.hms.apis.v1.models.ResponseDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RequestMapping("/api/v1/doctors")
public interface V1DoctorAPI {
	
	@GetMapping("")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<List<Doctor>> showAllDoctors();
	

	@GetMapping("/viewByName/{name}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<Doctor> doctorViewByName(@PathVariable String name);
	
	
	@GetMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<Doctor> doctorViewById(@PathVariable("id") Long id);
	
	
	@PostMapping(value = "/addDoctor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<ResponseDTO> addDoctor(@Valid @RequestBody Doctor doctors);
	
	@PutMapping(value = "/updateDoctor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	ResponseEntity<ResponseDTO> updateDoctor(@PathVariable("id") Long id, @RequestBody Doctor doctors);

}
