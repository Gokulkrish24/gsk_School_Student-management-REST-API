package com.example.gsk_school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gsk_school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	List<Student> findByAdmissionYear(int year); 
	
	
	List<Student> findByAdmissionYearAndStd(int year, int std);
}
