package com.cibertec.edu.restcontrollers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.edu.models.Student;
import com.cibertec.edu.response.http.HttpResponseObject;
import com.cibertec.edu.services.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class IndexRestController {
	
	//protected final Log logger = (Log) LogFactory.getLog(this.getClass());
	
	@Autowired
	private StudentServiceImpl studentService;

	@GetMapping("/estudiantes/all")
	public HttpResponseObject obtenerEstudiantes() {
		List<Student> estudiantes = studentService.getAllStudents();
		if(estudiantes.size() == 0) {
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		}
		return new HttpResponseObject("success", HttpStatus.OK, estudiantes);
	}
	
	@GetMapping("/estudiantes/{id}")
	public HttpResponseObject obtenerUnEstudiante(@PathVariable(name = "id") Long id) {
		Student estudiante = this.studentService.getOneStudent(id);
		if(estudiante == null)
			return new HttpResponseObject("error", HttpStatus.NOT_FOUND, null);
		return new HttpResponseObject("success", HttpStatus.OK, estudiante);
	}

	/*@PostMapping(value="/estudiantes", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(rollbackFor = Exception.class)
	public HttpResponse*/
}
