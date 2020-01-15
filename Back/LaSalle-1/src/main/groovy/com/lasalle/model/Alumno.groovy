package com.lasalle.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonProperty

@Entity
@Table(name="cat_alumno")
public class Alumno {

	@Id
	@JsonProperty("matricula")
	private String idAlumnoMatricula;

	@Column (name="alumno_nombre")
	@JsonProperty("nombre")
	private String nombre;

	@Column (name="alumno_paterno")
	@JsonProperty("paterno")
	private String paterno;

	@Column (name="alumno_materno")
	@JsonProperty("materno")
	private String materno;

	@Column (name="alumno_correo")
	@JsonProperty("correo")
	private String correo;

	@Column (name="alumno_academico")
	@JsonProperty("academico")
	private String academico;

	@Column (name="alumno_fecha")
	@JsonProperty("fecha")
	private String fecha;

	public String getIdAlumnoMatricula() {
		return idAlumnoMatricula;
	}

	public void setIdAlumnoMatricula(String idAlumnoMatricula) {
		this.idAlumnoMatricula = idAlumnoMatricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAcademico() {
		return academico;
	}

	public void setAcademico(String academico) {
		this.academico = academico;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}