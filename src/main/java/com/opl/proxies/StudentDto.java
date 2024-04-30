package com.opl.proxies;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	
	private String enrollmentNo;
	private String name;
	private String gender;
	private LocalDate dob;
	private String branch;
	private String contact;
	private String address;
	private String city;
	private Integer pinCode;
}
