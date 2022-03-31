package com.generation.ourClub.Usuarios;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/usuarios/")//es para mapear con la ruta
public class UsuarioController {

	private final UsuariosService usuariosService;//constante para traer los productos de producto service
	@Autowired //crea instancia de usuario Service
	public UsuarioController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	@GetMapping
	public ArrayList<Usuario> getUsuarios(){
		return usuariosService.getUsuarios();
	}//getUsuarios
	
	@GetMapping(path="{usuId}")
	public Usuario getUsuario(@PathVariable("usuId") Long usuId) {
		return usuariosService.getUsuario(usuId);//regresa el usuario del id
	}//getUsuario
	
	//postmapping para agregar usuario
	//POST USUARIO
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuariosService.addUsuario(usuario);
	}//add usuario
	
	//crear loginController para validar usuario y contraseña si so correctos
	
}//class UsuariosController
