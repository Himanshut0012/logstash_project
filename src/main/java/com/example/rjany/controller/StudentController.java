package com.example.rjany.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rjany.model.Student;
import com.example.rjany.service.StudentService;

@RestController
public class StudentController {

	Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		 Student student1 =studentService.saveStudent(student);
		 LOGGER.debug("saved student record : {}", student1);
		 return student1;

	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		Student student =studentService.getStudentById(id);
		LOGGER.debug("get student record successfully {}",student);
		return student;
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
	 	return studentService.getAllStudent();

	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		Student student1 =studentService.updateStudent(id, student);
		LOGGER.debug("saved student record : {}", student1);
		return student1;
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		return studentService.deleteStudent(id);
	}

}
