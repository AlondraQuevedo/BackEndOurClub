package com.generation.ourClub.controller;



import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.generation.ourClub.jwt.config.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ourClub.model.Token;
import com.generation.ourClub.model.Usuario;
import com.generation.ourClub.service.UsuariosService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")//es para mapear con la ruta
@CrossOrigin("*")
public class LoginController {

	private final UsuariosService usuariosService;//constante para traer los usuarios de usuario service
	
	@Autowired //crea instancia de usuario Service
	public LoginController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}//constructor
	
	
	@PostMapping
	public Token login (@RequestBody Usuario usuario)  throws ServletException {
		if(usuariosService.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getCorreo()));
		
	}
	throw new ServletException("Nombre de usuarios o contraseña incorrecto");
}
	
	
	private String generateToken(String correo) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(correo).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();//inserta el algoritmo directo de jwt:.HS256
	}// generateToken
	
	
	
}//class LoginController
