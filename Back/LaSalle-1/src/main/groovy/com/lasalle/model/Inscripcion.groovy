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
	@Column(name ="idInscripcion")
	private Integer idInscripcion;
	
	@OneToOne
	@JoinColumn
	private Alumno idAlumnoMatricula;
	
	@Column(name = "idNivelAcademico")
	private Integer idNivelAcademico;
	
	@Column(name = "inscripcion_fecha")
	private String fechaInscripcion;

	public Integer getIdDescripcion() {
		return idDescripcion;
	}

	public void setIdDescripcion(Integer idDescripcion) {
		this.idDescripcion = idDescripcion;
	}

	public Alumno getIdAlumnoMatricula() {
		return idAlumnoMatricula;
	}

	public void setIdAlumnoMatricula(Alumno idAlumnoMatricula) {
		this.idAlumnoMatricula = idAlumnoMatricula;
	}

	public Integer getIdNivelAcademico() {
		return idNivelAcademico;
	}

	public void setIdNivelAcademico(Integer idNivelAcademico) {
		this.idNivelAcademico = idNivelAcademico;
	}

	public String getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	
}