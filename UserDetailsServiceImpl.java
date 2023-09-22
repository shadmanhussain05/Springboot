package com.school.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.entities.Student;
import com.school.repository.StudentRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    
    private StudentRepository studentloginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Student student = studentloginRepository.findByUsername(username);
    
    	if(studentloginRepository != null) {
    		return new CustomUserDetails(student);
    	}
           throw new UsernameNotFoundException("User not found: " + username);
    	
//        return User.builder()
//            .username(student.getUsername())
//            .password(student.getPassword())
//            .roles("STUDENT")
//            .build();
    }
}
