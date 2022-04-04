package com.generation.ourClub.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ourClub.model.Usuario;
import com.generation.ourClub.service.UsuariosService;

@RestController
@RequestMapping(path="/api/login/")//es para mapear con la ruta
public class LoginController {

	private final UsuariosService usuariosService;//constante para traer los usuarios de usuario service
	@Autowired //crea instancia de usuario Service
	public LoginController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	
	@PostMapping
	public String login (@RequestBody Usuario usuario) {
		return usuariosService.validateUsuario(usuario);
		
	}

}//class LoginController
