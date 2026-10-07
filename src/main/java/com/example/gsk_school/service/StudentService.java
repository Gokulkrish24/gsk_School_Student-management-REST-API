package com.example.gsk_school.service;

import java.util.List;
import java.util.Optional;

import com.example.gsk_school.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	List<Student> getAllStudents(int year);
	
	List<Student> getAllStudents(int year, int std);
	
	Optional<Student> getStudent(int rollno); 
	
	Student addNewStudent(Student student);
	
	void deleteStudent(int rollno);
}
