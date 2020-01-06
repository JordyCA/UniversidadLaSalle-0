package com.lasalle.model

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
	private Integer idUsr;
	
	@Column(name="usuario_usuario")
	private String usuario;
	
	@Column(name="usuario_contraseña")
	private String contrasena;
	
	@Column(name="usuario_status")
	private Integer estatus;
	
	@Column(name="usuario_fecha")
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

	public String getIdAlumno() {
		return IdAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		IdAlumno = idAlumno;
	}
	
	
}