package com.lasalle.model

import org.springframework.stereotype.Component

@Component
public class ModificacionAlumno {
	private String idMatricula;
	private String nombre;
	private String paterno;
	private String materno;
	private String contrasena;
	private String correo;
	
	public String getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(String idMatricula) {
		this.idMatricula = idMatricula;
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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
	
	
}