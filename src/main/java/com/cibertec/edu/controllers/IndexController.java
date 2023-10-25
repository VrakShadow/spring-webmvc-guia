package com.cibertec.edu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.edu.models.Student;
import com.cibertec.edu.services.StudentServiceImpl;

@Controller
@RequestMapping("/home")
public class IndexController {

	@Autowired
	private StudentServiceImpl studentService;
	
	@Value("${index.titulo.text}")
	private String title;
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",title);
		return "index";		
	}
	
	@GetMapping({"/estudiante/{idEstudiante}"})
	public String index(Model model, @PathVariable(name = "idEstudiante") Long idEstudiante) {
		model.addAttribute("titulo","Estudiante N# " + idEstudiante);
		Student estudiante = this.studentService.getOneStudent(idEstudiante);
		if(estudiante == null) {
			estudiante = new Student();
		}
		model.addAttribute("estudiante",estudiante);
		return "estudiante";
	}
	
	@ModelAttribute("estudiantes")
	public List<Student> obtenerEstudiantes(){
		List<Student> estudiantes = this.studentService.getAllStudents();
		return estudiantes;
	}
	
}
