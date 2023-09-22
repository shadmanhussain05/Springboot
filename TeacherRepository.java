package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	Teacher findByUsername(String username);


}
