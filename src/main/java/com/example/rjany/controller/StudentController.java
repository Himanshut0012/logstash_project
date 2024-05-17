package com.example.rjany.controller;

import java.util.List;
import java.util.Optional;


import com.example.rjany.exception.StudentNotFoundException;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rjany.model.Student;
import com.example.rjany.service.StudentService;

@RestController
public class StudentController {

	Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		 Student student1 =studentService.saveStudent(student);
		 LOGGER.debug("saved student record : {}", student1);
		 return ResponseEntity.ok(student1);

	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity getStudent(@PathVariable("id") Long id) {
		try {
			Optional<Student> student =studentService.getStudentById(id);
			LOGGER.debug("get student record successfully {}",student);
			return new ResponseEntity<>(student.get(), HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			LOGGER.error("this student is not exist with id {}",id);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("An error occurred while deleting the student", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity getAllStudent(){
		List<Student> students = studentService.getAllStudent();
		LOGGER.debug("get all student record successfully {}",students);
	 	return ResponseEntity.ok(students);

	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		Student student1 =studentService.updateStudent(id, student);
		LOGGER.debug("saved student record : {}", student1);
		return ResponseEntity.ok(student1);

	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
		try {
			String result = studentService.deleteStudent(id);
			LOGGER.debug("this student is delete successfully {}",result);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			LOGGER.error("this student is not exist with id {}",id);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("An error occurred while deleting the student", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
