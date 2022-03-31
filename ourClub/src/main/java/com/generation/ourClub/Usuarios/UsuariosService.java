package com.generation.ourClub.Usuarios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

	public final ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	//CONSTRUCTOR
	public UsuariosService() {
		lista.add(new Usuario("Juan Peréz", "usuario1@gmail.com", 
				"1234usuario*", "2221254123"));
		lista.add(new Usuario("María García", "usuario2@gmail.com",
				"1234usuario2*", "2221254589*"));
	}//constructor
	
	
	public ArrayList<Usuario> getUsuarios() {
		return lista;
	}//getUsuarios

	public Usuario getUsuario(Long usuId) {
		Usuario tmpUsu = null;//inicializa usuario temporal
		//foreach
		for (Usuario usuario : lista) {
			if(usuario.getId()==usuId) {
				tmpUsu = usuario;
				break;
			}//if
		}//foreach
		return tmpUsu;
	}//getUsuario
	
	//POST USUARIO
	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}//addUsuario

	//LOGIN
	public Usuario loginUsuario(Usuario usuario) {
		Usuario tmpUsu = null;//inicializa usuario temporal
		//foreach
		for (Usuario u : lista) {
			//si correo se encuentra ya registrado
			if(u.getCorreo().equals(usuario.getCorreo())) {
				//si la contraseña conincide
				if(u.getContrasena().equals(usuario.getContrasena())) {
					//si coincide correo y contraseña se muestra el objeto
					tmpUsu = u;
					return tmpUsu;
				}//ifcontrasena
				else {
					//si contraseña no coincide
					return null;
				}//else
			}//ifcorreo
		}//foreach
		//si no coincide el correo con alguno ya registrado
		return null;
	}//loginUsuario


	public ArrayList<Usuario> imprime() {
		return lista;
	}//imprime

}//class
