package com.opl.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opl.entities.EducationDetails;

@Repository
public interface EducationDetailsRepo extends CrudRepository<EducationDetails, Long> {

	Optional<EducationDetails> findByStudentEnrollmentNo(String enrolNo);
}
