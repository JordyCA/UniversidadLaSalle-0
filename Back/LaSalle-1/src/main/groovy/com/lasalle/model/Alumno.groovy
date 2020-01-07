package com.lasalle.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="cat_alumno")
public class Alumno {

	@Id
	private String idMatricula;

	@Column (name="alumno_nombre")
	private String nombre;

	@Column (name="alumno_paterno")
	private String paterno;

	@Column (name="alumno_materno")
	private String materno;

	@Column (name="alumno_correo")
	private String correo;

	@Column (name="alumno_academico")
	private String academico;

	@Column (name="alumno_fecha")
	private String fecha;

	public java.lang.Object getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(java.lang.Object idMatricula) {
		this.idMatricula = idMatricula;
	}
	public java.lang.Object getNombre() {
		return nombre;
	}
	public void setNombre(java.lang.Object nombre) {
		this.nombre = nombre;
	}
	public java.lang.Object getPaterno() {
		return paterno;
	}
	public void setPaterno(java.lang.Object paterno) {
		this.paterno = paterno;
	}
	public java.lang.Object getMaterno() {
		return materno;
	}
	public void setMaterno(java.lang.Object materno) {
		this.materno = materno;
	}
	public java.lang.Object getCorreo() {
		return correo;
	}
	public void setCorreo(java.lang.Object correo) {
		this.correo = correo;
	}
	public java.lang.Object getAcademico() {
		return academico;
	}
	public void setAcademico(java.lang.Object academico) {
		this.academico = academico;
	}
	public java.lang.Object getFecha() {
		return fecha;
	}
	public void setFecha(java.lang.Object fecha) {
		this.fecha = fecha;
	}
}