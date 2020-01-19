package com.lasalle.model

import org.springframework.stereotype.Component

@Component
 public class UsuarioCorreo {
	 
	 private String emailAddress;
	 private String usuario;
	 private String contrasena;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	
	
	 
 }