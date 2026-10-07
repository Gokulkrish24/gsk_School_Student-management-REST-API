package com.example.gsk_school.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gsk_school.model.Student;
import com.example.gsk_school.service.StudentService;

@RestController
@CrossOrigin(origins ="http://localhost:5173")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/api/students")
	public List<Student> getForApiCall(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/api/students/filter/{yr}")
	public List<Student> apiForGetAllStudentsYearWise(@PathVariable("yr") int year) 
	{
		return studentService.getAllStudents(year);
	}
	
	@GetMapping("/api/students/filter/")
	public List<Student> apiForGetStudents(@RequestParam int year, @RequestParam int std)
	{
		return studentService.getAllStudents(year, std);
	}

	
	
	@GetMapping("/api/students/{id}")
	public  ResponseEntity<Student> apiForSearchStudent(@PathVariable("id") int rollno)
	{
		Optional<Student> opt=studentService.getStudent(rollno);		
		
		if(opt.isPresent())
		{
			return ResponseEntity.ok().body(opt.get());
		}
		else
			return ResponseEntity.notFound().build();
				

	}
	
	
	@PostMapping("/api/students")
	public ResponseEntity<Student> apiForAddData(@RequestBody Student student)
	{
		Optional<Student> opt=studentService.getStudent(student.getRollno());
		
		if(opt.isEmpty())
		{
			Student savedObj = studentService.addNewStudent(student);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedObj);
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	
	@PutMapping("/api/students/{id}")
	public ResponseEntity<Student> apiForUpdateData(@PathVariable("id") int rollno, @RequestBody Student student)
	{

		Optional<Student> opt=studentService.getStudent(rollno);
		
		if(opt.isEmpty())		
			return ResponseEntity.notFound().build(); 		
		
		
		student.setRollno(rollno);
		Student updated = studentService.addNewStudent(student);
		return ResponseEntity.ok(updated); 
	}
	
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<Student> apiForDeleteData(@PathVariable("id") int rollno)
	{
		Optional<Student> opt=studentService.getStudent(rollno);
		
		if(opt.isPresent())
		{
			studentService.deleteStudent(rollno); 
			return ResponseEntity.ok().body(opt.get());
		}
			
		return ResponseEntity.notFound().build();
	}
}
