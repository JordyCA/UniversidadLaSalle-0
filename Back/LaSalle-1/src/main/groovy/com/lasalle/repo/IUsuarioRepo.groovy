package com.lasalle.repo

import com.lasalle.model.Alumno
import com.lasalle.model.Usuario

import java.math.BigDecimal

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param



public interface IUsuarioRepo extends JpaRepository <Usuario,Integer> {
	
	@Query("SELECT max(idUsr) FROM Usuario")
	BigDecimal max();
	
	@Query("SELECT t FROM Usuario t WHERE t.IdAlumno = ?1")
	Usuario findByidAlumnoMatricula(Alumno id )
	
}