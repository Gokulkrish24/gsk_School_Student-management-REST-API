package com.example.gsk_school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gsk_school.model.Student;
import com.example.gsk_school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}
	
	@Override
	public Optional<Student> getStudent(int rollno) {
		
		return studentRepo.findById(rollno); 
	}

	@Override
	public Student addNewStudent(Student student) {
		
		return studentRepo.save(student); 
	}

	@Override
	public void deleteStudent(int rollno) {
		studentRepo.deleteById(rollno);
	}

	@Override
	public List<Student> getAllStudents(int yr) {
		
		return studentRepo.findByAdmissionYear(yr);
	}

	@Override
	public List<Student> getAllStudents(int yr, int std) {
		
		return studentRepo.findByAdmissionYearAndStd(yr, std);
	}
}
