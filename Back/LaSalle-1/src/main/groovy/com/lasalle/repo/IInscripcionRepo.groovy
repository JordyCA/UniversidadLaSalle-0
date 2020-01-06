package com.lasalle.repo

import com.lasalle.model.Inscripcion
import org.springframework.data.jpa.repository.JpaRepository

public interface IInscripcionRepo extends JpaRepository <Inscripcion, Integer> {
	
}