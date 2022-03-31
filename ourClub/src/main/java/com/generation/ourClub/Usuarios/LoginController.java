package com.generation.ourClub.Usuarios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/usuarios/login/")//es para mapear con la ruta
public class LoginController {

	private final UsuariosService usuariosService;//constante para traer los usuarios de usuario service
	@Autowired //crea instancia de usuario Service
	public LoginController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	@GetMapping
	public ArrayList<Usuario> imprime(){
		return usuariosService.imprime();
	}//getUsuarios
	
	@PostMapping
	public Usuario loginUsuario(@RequestBody Usuario usuario) {
		return usuariosService.loginUsuario(usuario);
	}//post
	
}//class LoginController
