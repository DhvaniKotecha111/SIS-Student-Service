package com.opl.services;

import org.springframework.stereotype.Service;

import com.opl.proxies.EducationDetailsDto;

@Service
public interface EducationDetailsServices {

	public String addEducationDetails(EducationDetailsDto educationDetailsDto);
	
	public EducationDetailsDto getEducationDetails(String enrolNo);
	
	public String updateEducationDetails(EducationDetailsDto educationDetailsDto, String enrolNo);
}
