//package com.school.Services;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.school.entities.Student;
//import com.school.entities.Teacher;
//import com.school.repository.StudentRepository;
//import com.school.repository.TeacherRepository;
//
//public class CustomUserDetailsService implements UserDetails {
//
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@Autowired
//	private TeacherRepository teacherRepository;
//
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//	{
//		 Student student = studentRepository.findByUsername(username);
//	        if (student != null) {
//	            return new User(student.getUsername(), student.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_STUDENT")));
//	        }
//
//	        Teacher teacher = teacherRepository.findByUsername(username);
//	        if (teacher != null) {
//	            return new User(teacher.getUsername(), teacher.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_TEACHER")));
//	        }
//
//	        throw new UsernameNotFoundException("User not found with username: " + username);
//	    }
//
//
//}
