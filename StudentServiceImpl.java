package com.school.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entities.Student;
import com.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudets() {
		return studentRepository.findAll() ;
	}

	@Override
	public void saveStudent(Student student) {

		this.studentRepository.save(student);
	}

	@Override
	public Student getStudentById(long id) {
		 Optional<Student> optional = studentRepository.findById(id);
		 Student student = null;
		 if(optional.isPresent()) {
			 student =optional.get();
		 }else {
			 throw new RuntimeException("Employee not Found !!"+id);
		 }
		return student;
	}

	@Override
	public void deleteStudentById(long id) {

		this.studentRepository.deleteById(id);
	}
	
	

}
