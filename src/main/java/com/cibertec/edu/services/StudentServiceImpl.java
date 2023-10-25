package com.cibertec.edu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.models.Student;
import com.cibertec.edu.repositories.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return this.studentRepository.findAll();
	}

	@Override
	public Student getOneStudent(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> student = this.studentRepository.findById(id);
		if(student.isPresent()){
			return student.get();
		}
		return null;
	}

}
