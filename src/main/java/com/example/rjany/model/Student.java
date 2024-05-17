package com.example.rjany.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //mark class as entity
@Table //defining class name as Table name
@Data
@ToString
public class Student {
	
	@Column //defining id as primary key
	@Id
	private Long id;
	
	@Column 
	private String name;
	
	@Column
	private Integer age;
	
	@Column
	private String email;
	@Column
	private long mobileNumber;
	


	

}
