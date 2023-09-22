package com.school.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="T_Id")
	private long Id;
	
	private String username;
	
	private String password;
	
	@Column(name="T_fname")
	private  String fname;
	
	@Column(name="T_lname")
	private String lname;
	
	@Column(name="T_contact")
	private int Contact;
	
	@Column(name="T_address")
	private String Address;
	
	@Column(name="T_Dept")
	private String Department;
	
	@Column(name="T_email")
	private String Email;

	public long getTeacher_Id() {
		return Id;
	}

	public void setTeacher_Id(long teacher_Id) {
		Id = teacher_Id;
	}

	public String getusername() {
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getContact() {
		return Contact;
	}

	public void setContact(int contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [Teacher_Id=" + Id + ", username=" + username + ", password=" + password + ", fname="
				+ fname + ", lname=" + lname + ", Contact=" + Contact + ", Address=" + Address + ", Department="
				+ Department + ", Email=" + Email + "]";
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
