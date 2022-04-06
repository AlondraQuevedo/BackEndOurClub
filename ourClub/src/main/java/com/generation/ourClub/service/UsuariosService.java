package com.generation.ourClub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.ourClub.model.Usuario;

@Service

public class UsuariosService {
@Autowired 
public final UsuariosRepository usuariosRepository;
	public final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	//CONSTRUCTOR
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}//constructor
	public List<Usuario> getUsuarios() {
		return usuariosRepository.findAll();


	}//getUsuarios

	public Usuario getUsuario(Long id) {
		return usuariosRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("El usuario no existe  con el id " + id + " no existe."));

	}// get usuarios
	
	
	public void addUsuario(Usuario usuario) {

		Optional<Usuario> userByName = usuariosRepository.findByUsername(usuario.getNombre());
		if (userByName.isPresent()) {
			throw new IllegalStateException("El Usuario con el nombre [" + usuario.getNombre() + "] YA existe.");
		} else {
			usuariosRepository.save(usuario);
		} // else

	}

	//LOGIN



	public String validateUsuario(Usuario usuario) {
		String res="Nombre de usuario o contraseña incorrectos ";
		Optional <Usuario> userByName=usuariosRepository.findByUsername(usuario.getCorreo());
		if(userByName.isPresent()) {
			Usuario u=userByName.get();
			System.out.println("que esta pasando!!");
			if(u.getContrasena().equals(usuario.getContrasena())) {
				res="OK";
			}
			
		}
		return res;

	}
	
	
	
	
	

}//class
