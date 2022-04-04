package com.generation.ourClub.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.generation.ourClub.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT u FROM Usuario u WHERE u.username=?1")
	Optional<Usuario>findByUsername (String username);
	


}
