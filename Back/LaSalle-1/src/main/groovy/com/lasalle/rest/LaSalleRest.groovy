package com.lasalle.rest

import com.lasalle.model.Alumno
import com.lasalle.model.FormularioIngreso
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
	
	@Autowired
	private FormularioIngreso formularioingreso;
	
	
	@GetMapping("/alumno")
	public List<Alumno> listar(){
		return repo.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/verificarusuario")
	public Usuario verificar() {
		Alumno alumno = new Alumno();
		alumno = repo.findByidAlumnoMatricula("111111111");
		Usuario usuario = new Usuario();
		usuario = repo2.findByidAlumnoMatricula(alumno);
		return usuario;
	}
	
	@CrossOrigin
	@PostMapping("/alumnoingreso")
	public void insertarAlumno(@RequestBody FormularioIngreso formularioingreso) {
		
		Alumno alumno = new Alumno();
		
		LocalDate localDate = LocalDate.now()
		//System.out.println(localDate);
		alumno.setIdAlumnoMatricula(formularioingreso.getIdAlumnoMatricula());
		alumno.setCorreo(formularioingreso.getCorreo());
		alumno.setNombre(formularioingreso.getNombre());
		alumno.setPaterno(formularioingreso.getPaterno());
		alumno.setMaterno(formularioingreso.getMaterno());
		alumno.setAcademico("ninguno");
		alumno.setFecha((String)localDate);
		repo.save(alumno);
		
		Usuario usuario = new Usuario();
		
		usuario.setIdUsr(1);
		usuario.setContrasena("prueba");
		usuario.setEstatus(1);
		usuario.setUsuario("hola");
		usuario.setIdAlumno(alumno);
		usuario.setFecha((String)localDate);
		
		repo2.save(usuario);
		
		
		Inscripcion inscripcion = new Inscripcion();
		
		System.out.println(formularioingreso.getEspecialidad());
		
		if (repo3.max() == null) {
			inscripcion.setIdInscripcion(1);
		} else {
			inscripcion.setIdInscripcion((Integer)repo3.max() + 1);
		}
		
		inscripcion.setIdAlumnoMatricula(alumno);
		inscripcion.setFechaInscripcion((String)localDate)
		inscripcion.setNivelAcademico(formularioingreso.getGrado());
		inscripcion.setEspecialidad(formularioingreso.getEspecialidad());
		repo3.save(inscripcion);
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