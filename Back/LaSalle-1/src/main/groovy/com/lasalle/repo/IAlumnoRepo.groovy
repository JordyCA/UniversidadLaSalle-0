package com.lasalle.repo

import com.lasalle.model.Alumno

import javax.persistence.Table

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

//@jordy interface con la entidad del modelo y el tipo del id
public interface IAlumnoRepo extends JpaRepository <Alumno,String> {
	@Query("SELECT t FROM Alumno t WHERE t.idAlumnoMatricula = ?1")
	Alumno findByidAlumnoMatricula(String id )
}