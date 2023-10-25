package com.cibertec.edu.services;

import java.util.List;

import com.cibertec.edu.models.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public Student getOneStudent(Long id);
	
	public Student saveStudent(Student newStudent);
}
