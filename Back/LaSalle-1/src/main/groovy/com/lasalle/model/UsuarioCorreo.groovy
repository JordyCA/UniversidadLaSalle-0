package com.lasalle.model

import org.springframework.stereotype.Component

@Component
 public class UsuarioCorreo {
	 
	 private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	 
	 
 }