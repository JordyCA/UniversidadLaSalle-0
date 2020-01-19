package com.lasalle.service

import com.lasalle.model.UsuarioCorreo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
public class MailService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public  MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendEmail(UsuarioCorreo usuarioCorreo) throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(usuarioCorreo.getEmailAddress());
		mail.setSubject("Registro de Inscripción");
		mail.setText("Su registro de Inscripción ha sido exitoso favor de ingresar a la siguiente liga http://localhost:5000/LaSalle/ingresoAlumnos con el siguiente usuario :" + usuarioCorreo.getUsuario() + " y contraseña: " + usuarioCorreo.getContrasena());
		
		javaMailSender.send(mail);
	}
}