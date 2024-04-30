package com.opl.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opl.entities.Student;
import com.opl.proxies.StudentDto;
import com.opl.repositories.StudentRepo;
import com.opl.services.StudentServices;
import com.opl.utils.Helper;

@Component
public class StudentServiceImpl implements StudentServices {

	@Autowired
	private Helper helper;

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public String registerStudent(StudentDto studentDto) {
		try {
			Student student = helper.convertDtoToStudent(studentDto);
			Optional<Student> byId = studentRepo.findById(student.getEnrollmentNo());
			if (byId.isPresent()) {
				return "Profile is already Created";
			}
			studentRepo.save(student);
			return "Profile Created Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error in Profile Creation";
		}
	}

	@Override
	public StudentDto getStudent(String name) {
		Optional<Student> byName = studentRepo.findByName(name);
		if (byName.isPresent()) {
			Student student = byName.get();
			System.out.println(student);
			StudentDto studentDto = helper.convertStudentToDto(student);
			return studentDto;
		}
		return null;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = (List<Student>) studentRepo.findAll();
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : students) {
			StudentDto studentDto = helper.convertStudentToDto(student);
			studentDtos.add(studentDto);
		}
		return studentDtos;
	}

	@Override
	public String updateStudent(StudentDto studentDto, String enrolNo) {
		Optional<Student> byId = studentRepo.findById(enrolNo);
		if (byId.isPresent()) {
			Student student = helper.convertDtoToStudent(studentDto);
			studentRepo.save(student);
			return "Student updated successfully";
		}
		return "No student found with this id : "+enrolNo;
	}

	@Override
	public String deleteStudent(String enrolNo) {
		Optional<Student> byId = studentRepo.findById(enrolNo);
		if (byId.isPresent()) {
			studentRepo.deleteById(enrolNo);
			return "Student deleted successfully";
		}
		return "No student found with this id : "+enrolNo;
	}

}
