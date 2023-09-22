package com.school.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.entities.Teacher;
import com.school.repository.TeacherRepository;

@Service
public class TeacherDetailsService implements UserDetailsService {

    @Autowired
    
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Teacher teacher = teacherRepository.findByUsername(username)
            .orElseThrow new UsernameNotFoundException("Teacher not found: " + username));

        return User.builder()
            .username(teacher.getUsername())
            .password(teacher.getPassword())
            .roles("TEACHER")
            .build();
    }
}
