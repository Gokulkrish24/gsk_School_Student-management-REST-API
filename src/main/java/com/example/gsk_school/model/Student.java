package com.example.gsk_school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int rollno;
	
	private String name;
	private String gender;
	private int admissionYear;
	private int std;
	private char section;
	
	public Student() {
		
	}
	
	
	public Student(int rollno, String name, String gender, int admissionYear, int std, char section) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.gender = gender;
		this.admissionYear = admissionYear;
		this.std = std;
		this.section = section;
	}


	public int getRollno() {
		return rollno;
	}


	public void setRollno(int rollno) {
		this.rollno = rollno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAdmissionYear() {
		return admissionYear;
	}


	public void setAdmissionYear(int admissionYear) {
		this.admissionYear = admissionYear;
	}


	public int getStd() {
		return std;
	}


	public void setStd(int std) {
		this.std = std;
	}


	public char getSection() {
		return section;
	}


	public void setSection(char section) {
		this.section = section;
	}


	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", gender=" + gender + ", admissionYear="
				+ admissionYear + ", std=" + std + ", section=" + section + "]";
	}
	
	
}
