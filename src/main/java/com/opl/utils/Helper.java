package com.opl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opl.entities.EducationDetails;
import com.opl.entities.Student;
import com.opl.proxies.EducationDetailsDto;
import com.opl.proxies.StudentDto;

@Component
public class Helper {

	@Autowired
	private ObjectMapper mapper;
	
	public Student convertDtoToStudent(StudentDto studentDto)
	{
		return mapper.convertValue(studentDto, Student.class);
	}
	
	public EducationDetails convertDtoToEducationDetails(EducationDetailsDto educationDetailsDto)
	{
		return mapper.convertValue(educationDetailsDto, EducationDetails.class);
	}
	
	public StudentDto convertStudentToDto(Student student)
	{
		return mapper.convertValue(student, StudentDto.class);
	}
	
	public EducationDetailsDto convertEducationDetailsToDto(EducationDetails educationDetails)
	{
		return mapper.convertValue(educationDetails, EducationDetailsDto.class);
	}
}
