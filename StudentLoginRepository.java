package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entities.Student;

public interface StudentLoginRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByUsername (String username);
	
}
