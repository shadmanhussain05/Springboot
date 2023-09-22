package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.entities.Teacher;

public interface TeacherLoginRepository extends JpaRepository<Teacher, Long>
{
	Optional<Teacher> findByUsername(String username);

}
