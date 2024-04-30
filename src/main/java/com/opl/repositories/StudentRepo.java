package com.opl.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opl.entities.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, String>{

	Optional<Student> findByName(String name);
}
