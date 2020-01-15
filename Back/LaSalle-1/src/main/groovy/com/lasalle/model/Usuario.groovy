package com.lasalle.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name="cat_usuario")
public class Usuario {
	
	@Id
	@JsonProperty("Id_Usuario")
	private Integer idUsr;
	
	@Column(name="usuario_usuario")
	@JsonProperty("usuario")
	private String usuario;
	
	@Column(name="usuario_contraseña")
	@JsonProperty("ccc")
	private String contrasena;
	
	@Column(name="usuario_status")
	@JsonProperty("status")
	private Integer estatus;
	
	@Column(name="usuario_fecha")
	@JsonProperty("fecha")
	private String fecha;
	
	@OneToOne
	@JoinColumn(name="id_alumno")
	private Alumno IdAlumno;

	public Integer getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(Integer idUsr) {
		this.idUsr = idUsr;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Alumno getIdAlumno() {
		return IdAlumno;
	}

	public void setIdAlumno(Alumno idAlumno) {
		IdAlumno = idAlumno;
	}

	
	
}