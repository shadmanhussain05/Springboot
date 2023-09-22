package com.school.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.school.Services.UserDetailsServiceImpl;
import com.school.Services.TeacherDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration  {
    @Autowired
    private UserDetailsServiceImpl studentDetailsService;
    
    @Autowired
    private TeacherDetailsService teacherDetailsService;

    @SuppressWarnings("deprecation")
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 
		 http
         .authorizeRequests()
             .antMatchers("/login").permitAll()
             .antMatchers("/student/").hasRole("STUDENT")
             .antMatchers("/teacher/").hasRole("TEACHER")
             .and()
         .formLogin()
             .loginPage("/login")
             .defaultSuccessURL("/")
             .and()
         .logout()
             .logoutUrl("/logout")
             .and()
         .exceptionHandling().accessDeniedPage("/access-denied");
 }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(studentDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(teacherDetailsService).passwordEncoder(passwordEncoder());
    }
	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 }

