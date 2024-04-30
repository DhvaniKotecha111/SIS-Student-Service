package com.opl.proxies;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDetailsDto {

	private Long id;
	private String studentEnrollmentNo;
	private String educationType;
	private String percentage;
	private Boolean qualified;
	private String updatedBy;
	private LocalDate updatedDate;
}
