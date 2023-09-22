package com.school.Services;

import java.util.List;

import com.school.entities.Student;

public interface StudentService {

	List<Student> getAllStudets();
	void saveStudent(Student student);
	Student getStudentById(long id);
	void deleteStudentById(long id);

}
