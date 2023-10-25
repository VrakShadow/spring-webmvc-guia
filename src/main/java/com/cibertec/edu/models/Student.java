package com.cibertec.edu.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Student implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	Long id;
	
	@Column(name = "student_nombre")
	String nombre;
	
	@Column(name = "student_dni")
	String dni;
	
	@Column(name = "student_codigo")
	String codigo;
	
	@Column(name = "student_anio_ingreso")
	String anioIngreso;
	
	@Column(name = "personal_estado")
	String estado;

}
