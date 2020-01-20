package com.lasalle.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "cat_inscripcion")
public class Inscripcion {
	
	@Id
	@Column(name ="id_inscripcion")
	private Integer idInscripcion;
	
	@OneToOne
	@JoinColumn
	private Alumno idAlumnoMatricula;
	
	@Column(name = "inscripcion_fecha")
	private String fechaInscripcion;
	
	@Column(name = "id_nivel_academico")
	private String nivelAcademico;
	
	@Column(name = "id_cat_especialidad")
	private String especialidad;

	public Integer getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Alumno getIdAlumnoMatricula() {
		return idAlumnoMatricula;
	}

	public void setIdAlumnoMatricula(Alumno idAlumnoMatricula) {
		this.idAlumnoMatricula = idAlumnoMatricula;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	
}