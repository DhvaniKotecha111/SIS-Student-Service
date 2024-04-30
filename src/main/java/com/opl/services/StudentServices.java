package com.opl.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.opl.proxies.StudentDto;

@Service
public interface StudentServices {

	public String registerStudent(StudentDto studentDto);
	
	public StudentDto getStudent(String name);
	
	public List<StudentDto> getAllStudents();
	
	public String updateStudent(StudentDto studentDto, String enrolNo);
	
	public String deleteStudent(String enrolNo);
}
