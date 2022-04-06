package com.generation.ourClub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.ourClub.model.ChangePassword;
import com.generation.ourClub.model.Usuario;
import com.generation.ourClub.utils.SHAUtils;

@Service

public class UsuariosService {
	@Autowired
	public final UsuariosRepository usuariosRepository;
	

	// CONSTRUCTOR
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	}// constructor

	public List<Usuario> getUsuarios() {
		return usuariosRepository.findAll();

	}// getUsuarios

	public Usuario getUsuario(Long id) {
		return usuariosRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("El usuario no existe  con el id " + id + " no existe."));

	}// get usuarios

	public void deleteUsuario(Long id) {
		if (usuariosRepository.existsById(id)) {
			usuariosRepository.deleteById(id);
		}
	}
	public void addUsuario(Usuario usuario) {

		Optional<Usuario> userByName = usuariosRepository.findByUsername(usuario.getNombre());
		if (userByName.isPresent()) {
			throw new IllegalStateException("El Usuario con el nombre [" + usuario.getNombre() + "] YA existe.");
		} else {
			usuario.setContrasena(SHAUtils.createHash(usuario.getContrasena()));
			usuariosRepository.save(usuario);
		} // else

	}

	
	public void  updateUsuario(ChangePassword changePassword ) {
		Optional<Usuario> userByName=usuariosRepository.findByUsername(changePassword.getNombre());
		if (userByName.isPresent()) {
			Usuario u=userByName.get();
			if (SHAUtils.verifyHash(changePassword.getContrasena(), u.getContrasena())) {
				u.setContrasena(SHAUtils.createHash(changePassword.getNuevaContrasena()));
				usuariosRepository.save(u);
				
			}//password
			
		}//if is present
	}//updateusuario
	// LOGIN
		public String validateUsuario(Usuario usuario) {
			String res = "Nombre de usuario o contraseña incorrectos ";
			Optional<Usuario> userByName = usuariosRepository.findByUsername(usuario.getCorreo());
			if (userByName.isPresent()) {
				Usuario u = userByName.get();
				
				if (SHAUtils.verifyHash(usuario.getContrasena(), u.getContrasena())) {
					res = "OK";
				}

			}
			return res;

		}

}// class
