package com.opl.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
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
