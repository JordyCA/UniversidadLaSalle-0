package com.lasalle.repo

import com.lasalle.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository



public interface IUsuarioRepo extends JpaRepository <Usuario,Integer> {
	
}