package com.lasalle.repo

import com.lasalle.model.Alumno

import javax.persistence.Table

import org.springframework.data.jpa.repository.JpaRepository

//@jordy interface con la entidad del modelo y el tipo del id
public interface IAlumnoRepo extends JpaRepository <Alumno,String> {
	
}