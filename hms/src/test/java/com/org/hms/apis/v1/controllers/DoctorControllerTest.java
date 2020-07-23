package com.org.hms.apis.v1.controllers;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.hms.DataBuilder;
import com.org.hms.apis.v1.models.DoctorDTO;
import com.org.hms.apis.v1.service.DoctorService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith({ MockitoExtension.class, SpringExtension.class })
@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc // need this in Spring Boot test
class DoctorControllerTest {

	@Mock
	DoctorService service;

	@InjectMocks
	DoctorController doctorController;

	@Autowired
	public MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		doctorController = new DoctorController(service);
		mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
	}

	@Test
	@DisplayName(value = "Should be able search Doctors by id")
	public void shouldReturn_Doctor_search_by_id() throws Exception {
		Long id = new Long(1);
		when(service.getDoctorById(id)).thenReturn(DataBuilder.stubDoctor());
		RequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/doctors/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse();
		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());

	}

	@Test
	@DisplayName(value = "Should be able search Doctors by name")
	public void shouldReturn_Doctor_search_by_name() throws Exception {
		when(service.getDoctorByName(ArgumentMatchers.anyString())).thenReturn(DataBuilder.stubDoctor());
		RequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/doctors/viewByName/{name}", "SRIKANTH")
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse();
		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());

	}

	@Test
	@DisplayName(value = "Should be able to create Doctor")
	public void shouldReturn_Doctor_on_Creation() throws Exception {

		String jsonString = new ObjectMapper().writeValueAsString(DataBuilder.stubDoctor());
		when(service.addDoctor(ArgumentMatchers.any(DoctorDTO.class))).thenReturn(DataBuilder.stubResponse());
		RequestBuilder builder = MockMvcRequestBuilders.post("/api/v1/doctors/addDoctor")
				.contentType(MediaType.APPLICATION_JSON).content(jsonString);

		MockHttpServletResponse response = mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn().getResponse();
		Assert.assertTrue(response.getStatus() == HttpStatus.CREATED.value());

	}

	@Test
	@DisplayName(value = "Should be able get all Doctors")
	public void shouldReturn_All_Doctors() throws Exception {

		when(service.getAllDoctors()).thenReturn(DataBuilder.stubGetAllDoctorResponse());
		RequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/doctors/").contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse();
		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());

	}

	@Test
	@DisplayName(value = "Should be able Doctors")
	public void shouldReturn_All_Doctor_on_updation() throws Exception {

		String jsonString = new ObjectMapper().writeValueAsString(DataBuilder.stubDoctor());
		Long id = new Long(1);
		when(service.updateDoctor(id, DataBuilder.stubDoctor())).thenReturn(DataBuilder.stubResponse());
		RequestBuilder builder = MockMvcRequestBuilders.put("/api/v1/doctors/updateDoctor/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON).content(jsonString);

		MockHttpServletResponse response = mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn().getResponse();
		Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
	}

}
