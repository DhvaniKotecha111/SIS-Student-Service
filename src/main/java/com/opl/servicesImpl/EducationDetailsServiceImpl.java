package com.opl.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opl.entities.EducationDetails;
import com.opl.proxies.EducationDetailsDto;
import com.opl.repositories.EducationDetailsRepo;
import com.opl.services.EducationDetailsServices;
import com.opl.utils.Helper;

@Component
public class EducationDetailsServiceImpl implements EducationDetailsServices {

	@Autowired
	private Helper helper;
	
	@Autowired
	private EducationDetailsRepo educationDetailsRepo;
	
	@Override
	public String addEducationDetails(EducationDetailsDto educationDetailsDto) {
		EducationDetails educationDetails = helper.convertDtoToEducationDetails(educationDetailsDto);
		educationDetailsRepo.save(educationDetails);
		return "Education Details added successfully";
	}

	@Override
	public EducationDetailsDto getEducationDetails(String enrolNo) {
		Optional<EducationDetails> byStudentEnrollmentNo = educationDetailsRepo.findByStudentEnrollmentNo(enrolNo);
		if (byStudentEnrollmentNo.isPresent()) {
			EducationDetails educationDetails = byStudentEnrollmentNo.get();
			EducationDetailsDto educationDetailsDto = helper.convertEducationDetailsToDto(educationDetails);
			return educationDetailsDto;
		}
		return null;
	}

	@Override
	public String updateEducationDetails(EducationDetailsDto educationDetailsDto, String enrolNo) {
		Optional<EducationDetails> byStudentEnrollmentNo = educationDetailsRepo.findByStudentEnrollmentNo(enrolNo);
		if (byStudentEnrollmentNo.isPresent()) {
			EducationDetails educationDetails = helper.convertDtoToEducationDetails(educationDetailsDto);
			educationDetailsRepo.save(educationDetails);
			return "Education Details updated successfully";
		}
		return "No Education Details found for this Student";
	}
		
}
