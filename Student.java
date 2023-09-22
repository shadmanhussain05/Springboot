package com.school.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="Std_Id")
	private Long id;
	
    private String username;

    private String password;
    
    private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="Std_Fname")
    private String firstName;
	
	@Column(name="Std_Lname")
    private String lastName;
	
	@Column(name="Sted_Gender")
    private String Gender;
	
	@Column(name="Std_Course")
    private String Course;
	
	@Column(name="Std_Age")
    private int Age;
	
	@Column(name="Std_Contact")
    private long Contact;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public long getContact() {
		return Contact;
	}

	public void setContact(long contact) {
		Contact = contact;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", Gender=" + Gender + ", Course=" + Course + ", Age=" + Age + ", Contact="
				+ Contact + "]";
	}

	

}
