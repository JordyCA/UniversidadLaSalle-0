package com.lasalle.repo

import com.lasalle.model.Alumno
import com.lasalle.model.Inscripcion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

public interface IInscripcionRepo extends JpaRepository <Inscripcion, Integer> {
	
	@Query("SELECT max(idInscripcion) FROM Inscripcion")
	BigDecimal max();
	
	@Query("SELECT t FROM Inscripcion t WHERE t.idAlumnoMatricula = ?1")
	Inscripcion findInscripcionByAlumno( Alumno id );
}