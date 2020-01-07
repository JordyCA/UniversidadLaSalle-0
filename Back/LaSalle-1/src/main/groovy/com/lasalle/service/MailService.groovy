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
		mail.setSubject("La salle prueba");
		mail.setText("hurra se envío el correo");
		
		javaMailSender.send(mail);
	}
}