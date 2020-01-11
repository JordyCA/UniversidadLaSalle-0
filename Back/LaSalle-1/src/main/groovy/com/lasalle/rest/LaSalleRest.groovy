package com.lasalle.rest

import com.lasalle.model.Alumno
import com.lasalle.model.Inscripcion
import com.lasalle.model.Usuario
import com.lasalle.model.UsuarioCorreo
import com.lasalle.repo.IAlumnoRepo
import com.lasalle.repo.IInscripcionRepo
import com.lasalle.repo.IUsuarioRepo
import com.lasalle.service.MailService
import java.text.SimpleDateFormat
import java.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailException
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
//@RequestMapping(value = "/alumnos", consumes = "application/json", produces = "application/json")
//@RequestMapping("/alumno")
public class LaSalleRest {
	
	@Autowired
	private IAlumnoRepo repo;
	
	@Autowired
	private IUsuarioRepo repo2;
	
	@Autowired
	private IInscripcionRepo repo3;
	
	@Autowired
	private MailService notificationService;
	
	@Autowired
	private UsuarioCorreo usuarioCorreo;
	
	
	@GetMapping("/alumno")
	public List<Alumno> listar(){
		return repo.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/alumnoingreso")
	public void insertarAlumno(@RequestBody Alumno alumno) {
		LocalDate localDate = LocalDate.now()
		//System.out.println(localDate);
		alumno.setFecha((String)localDate);
		repo.save(alumno);
	}
		
	@GetMapping("/usuario")
	public List<Usuario> listar2(){
		return repo2.findAll();
	}
	
	@GetMapping("/Inscripciones")
	public List<Inscripcion> listar3(){
		return repo3.findAll();
	}
	
	@RequestMapping("/send-email")
	public String send() {
		
		usuarioCorreo.setEmailAddress("andorid124@gmail.com");
		
		try {
		notificationService.sendEmail(usuarioCorreo);
		} catch (MailException mailException) {
			return mailException;
		} 
		
		return "Congratulations! Your mail has been send to the user.";
	}
	
	
}