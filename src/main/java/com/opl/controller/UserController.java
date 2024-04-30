package com.opl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.opl.proxies.EducationDetailsDto;
import com.opl.proxies.StudentDto;
import com.opl.services.EducationDetailsServices;
import com.opl.services.StudentServices;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private StudentServices studentServices;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EducationDetailsServices educationDetailsServices;

	//user related apis
	@PostMapping("/register")
	public String registerWithDetails(@RequestBody StudentDto studentDto) {
		return studentServices.registerStudent(studentDto);
	}

	@PostMapping("/updateUser/{enrolNo}")
	public String updateUserDetails(@RequestBody StudentDto studentDto, @PathVariable String enrolNo) {
		return studentServices.updateStudent(studentDto, enrolNo);
	}

	@GetMapping("/getUser/{name}")
	public StudentDto getUser(@PathVariable String name) {
		return studentServices.getStudent(name);
	}

	@GetMapping("/getAllUsers")
	public List<StudentDto> getAllUsers() {
		return studentServices.getAllStudents();
	}

	@GetMapping("/deleteUser/{enrolNo}")
	public String deleteUser(@PathVariable String enrolNo) {
		return studentServices.deleteStudent(enrolNo);
	}

	//feeDetails related apis
	@GetMapping("/getFeeDetails/{enrolNo}")
	public ResponseEntity<Object> getFeeDetails(@PathVariable String enrolNo) {
		String url = "http://SIS-SERVICE-ADMINISTRATOR/admin/getFeeDetails/{enrolNo}";
		Object object = restTemplate.getForObject(url, Object.class, enrolNo);
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}

	//educationDetails related apis
	@PostMapping("/addEducationDetails")
	public String addEducationDetails(@RequestBody EducationDetailsDto educationDetailsDto) {
		return educationDetailsServices.addEducationDetails(educationDetailsDto);
	}

	@PostMapping("/updateEducationDetails/{enrolNo}")
	public String updateEducationDetails(@RequestBody EducationDetailsDto educationDetailsDto,
			@PathVariable String enrolNo) {
		return educationDetailsServices.updateEducationDetails(educationDetailsDto, enrolNo);
	}
	
	@GetMapping("/getEducationDetails/{enrolNo}")
	public EducationDetailsDto getEducationDetails(@PathVariable String enrolNo)
	{
		return educationDetailsServices.getEducationDetails(enrolNo);
	}
}
