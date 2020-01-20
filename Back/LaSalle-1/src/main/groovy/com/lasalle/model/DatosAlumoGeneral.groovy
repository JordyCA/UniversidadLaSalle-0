package com.lasalle.model

import org.springframework.stereotype.Component

@Component
public class DatosAlumnoGeneral {
	
	private String idMatricula;
	private String usuario;
	private String nombre;
	private String paterno;
	private String materno;
	private String correo;
	private String grado;
	private String semestre;
	private String especialidad;
	
	public String getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(String idMatricula) {
		this.idMatricula = idMatricula;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}