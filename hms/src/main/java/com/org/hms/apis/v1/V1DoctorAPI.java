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

import com.org.hms.apis.v1.models.Doctor;
import com.org.hms.apis.v1.models.ErrorResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RequestMapping("/api/v1/doctors")
public interface V1DoctorAPI {
	
	@GetMapping("")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class ))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<List<Doctor>> showAllDoctors();
	
	@GetMapping("/viewByName/{name}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class ))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<Doctor> doctorViewByName();
	
	
	@GetMapping("/viewById/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class ))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	public ResponseEntity<List<Doctor>> doctorViewById();
	
	
	@PostMapping(value = "/addDoctor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class ))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	void addDoctor(@RequestBody Doctor doctor);
	
	@PutMapping(value = "/updateDoctor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = Doctor.class ))),
			@ApiResponse(responseCode = "400", description = "Request is not well-formed, syntactically incorrect, or violates schema", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
	})
	void updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor);

}
