package com.lasalle.rest

import com.lasalle.model.Alumno
import com.lasalle.model.Inscripcion
import com.lasalle.model.Usuario
import com.lasalle.repo.IAlumnoRepo
import com.lasalle.repo.IInscripcionRepo
import com.lasalle.repo.IUsuarioRepo
import org.springframework.beans.factory.annotation.Autowired
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
	
	
	@GetMapping("/alumno")
	public List<Alumno> listar(){
		return repo.findAll();
	}
	
	@GetMapping("/usuario")
	public List<Usuario> listar2(){
		return repo2.findAll();
	}
	
	@GetMapping("/Inscripciones")
	public List<Inscripcion> listar3(){
		return repo3.findAll();
	}
}