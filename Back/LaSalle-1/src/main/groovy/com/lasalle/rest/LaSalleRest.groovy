package com.lasalle.rest

import org.springframework.http.HttpStatus
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
import org.passay.CharacterRule
import org.passay.PasswordGenerator
import org.passay.EnglishCharacterData;
import org.passay.*;
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
public class LaSalleRest  {
	
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
	public String verificarUsuario(String matricula) {
		Alumno alumno = new Alumno();
		alumno = repo.findByidAlumnoMatricula(matricula);
		Usuario usuario = new Usuario();
		usuario = repo2.findByidAlumnoMatricula(alumno);
		if (usuario != null)  {
			System.out.println("Validacion de usuario");
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}
	
	@CrossOrigin
	@GetMapping("/verificarinscripcion")
	public String verificarInscripcion(String matricula) {
		Alumno alumno = new Alumno();
		alumno = repo.findByidAlumnoMatricula(matricula);
		Inscripcion verificarInscripcion = new Inscripcion();
		verificarInscripcion = repo3.findInscripcionByAlumno(alumno)
		if (verificarInscripcion != null)  {
			System.out.println("Validacion de la inscripción");
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.OK;
	}
	
	
	@CrossOrigin
	@PostMapping("/alumnoingreso")
	public String insertarAlumno(@RequestBody FormularioIngreso formularioingreso) {
		if (!
			(((formularioingreso.getCorreo() != "") && (formularioingreso.getCorreo() != null))
			&& ((formularioingreso.getGrado() != "") && (formularioingreso.getGrado() != null))
			&& ((formularioingreso.getIdAlumnoMatricula() != "") && (formularioingreso.getIdAlumnoMatricula() != null))
			&& ((formularioingreso.getEspecialidad() != "" && (formularioingreso.getEspecialidad() != null)))
			&& ((formularioingreso.getSemestre() != "") && (formularioingreso.getSemestre() != null) && (Integer.parseInt(formularioingreso.getSemestre())) )
			)) {
				System.out.println("Validacion de usuario");
				return HttpStatus.BAD_REQUEST;
		}
		
		/*verificar si el usuario no esta repetido*/

		/*Alumno alumnoBusqueda = new Alumno();
		alumnoBusqueda = repo.findByidAlumnoMatricula(formularioingreso.getIdAlumnoMatricula());
		Usuario usuarioBusqueda = new Usuario();
		usuarioBusqueda = repo2.findByidAlumnoMatricula(alumnoBusqueda);
		
		if (usuarioBusqueda != null)  {
			System.out.println("Validacion de usuario");
			return HttpStatus.BAD_REQUEST;
		}*/
		/*-----------------------------------------------------*/
		
		/*Verificar si el Alumno esta inscrito*/
		Alumno alumnoBusqueda = new Alumno();
		alumnoBusqueda = repo.findByidAlumnoMatricula(formularioingreso.getIdAlumnoMatricula());
		Inscripcion verificarInscripcion = new Inscripcion();
		verificarInscripcion = repo3.findInscripcionByAlumno(alumnoBusqueda)
		if (verificarInscripcion != null)  {
			System.out.println("Validacion de la inscripción");
			return HttpStatus.BAD_REQUEST;
		}
		/*-----------------------------------------------------*/
		
		
		/*------------ INSERCIÓN DEL ALUMNO--------------------*/
		Alumno alumno = new Alumno();
		
		LocalDate localDate = LocalDate.now()
		alumno.setIdAlumnoMatricula(formularioingreso.getIdAlumnoMatricula());
		alumno.setCorreo(formularioingreso.getCorreo());
		
		if (formularioingreso.getNombre() != "" && formularioingreso.getNombre() != null) {
			alumno.setNombre(formularioingreso.getNombre());
		} else {
			alumno.setNombre("-----");
		}
		if (formularioingreso.getPaterno() != "" && formularioingreso.getPaterno() !=  null) {
			alumno.setPaterno(formularioingreso.getPaterno());
		} else {
			alumno.setPaterno("-----");
		}
		if (formularioingreso.getMaterno() != "" && formularioingreso.getMaterno() != null ) {
			alumno.setMaterno(formularioingreso.getMaterno());
		} else {
			alumno.setMaterno("-----");
		}
		
		alumno.setAcademico("ninguno");
		alumno.setSemestre(Integer.parseInt(formularioingreso.getSemestre()));
		alumno.setFecha((String)localDate);
		repo.save(alumno);
		
		/*-----------------------------------------------------*/
		
		/*---------------- INSERCIÓN DEL USUARIO --------------*/
		
		Usuario usuario = new Usuario();
		
		if (repo2.max() == null) {
			usuario.setIdUsr(1);
		} else {
			usuario.setIdUsr((Integer)repo2.max()+1)
		}
		
		usuario.setContrasena(this.generatePassayPassword());
		usuario.setEstatus(1);
		usuario.setUsuario(formularioingreso.getIdAlumnoMatricula());
		usuario.setIdAlumno(alumno);
		usuario.setFecha((String)localDate);
		
		repo2.save(usuario);
		
		/*-----------------------------------------------------*/
		
		/*-----------Inserción de la inscripción--------------*/
		
		
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
		
		/*-----------------------------------------------------*/
		
		/*Envio del correo electronico*/
		this.sendEmail(formularioingreso.getCorreo(),usuario.getUsuario(), usuario.getContrasena());
		/*-----------------------------------------------------*/
		
		return HttpStatus.OK;
	}
		
	@GetMapping("/usuario")
	public List<Usuario> listar2(){
		return repo2.findAll();
	}
	
	@GetMapping("/Inscripciones")
	public List<Inscripcion> listar3(){
		return repo3.findAll();
	}
	
	//@RequestMapping("/send-email")
	public String sendEmail(String  email, String usuario, String contrasena) {
		System.out.println("Enviando correo eletronico");
		usuarioCorreo.setEmailAddress(email);
		usuarioCorreo.setUsuario(usuario);
		usuarioCorreo.setContrasena(contrasena);
		
		try {
		notificationService.sendEmail(usuarioCorreo);
		} catch (MailException mailException) {
			System.out.println(mailException);
			return mailException;
		} 
		
		return "Se envio el correo";
	}
	
	public String generatePassayPassword() {
		PasswordGenerator gen = new PasswordGenerator();
		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(2);
	 
		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(2);
	 
		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(2);
		
		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return ERROR_CODE;
			}
	 
			public String getCharacters() {
				return "!@";
			}
		};
		
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(2);
		
		String password = gen.generatePassword(10, splCharRule, lowerCaseRule,
			upperCaseRule, digitRule);
		
		System.out.println(password);
		
		  return password;
	}
}