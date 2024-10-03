package abilitySwap.service;

import java.sql.SQLException;

import abilitySwap.bean.Usuario;
import abilitySwap.repository.UsuarioRepository;

public class UsuarioService {
	
	
	public boolean existeUsuario (Usuario usuario) throws SQLException
	{
		boolean existe = false;
			
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			existe = usuarioRepository.existeUsuario(usuario);
		
		return existe;
	}

	public void insertarUsuario(Usuario usuario) throws SQLException
	{
		UsuarioRepository usuarioRepository = new UsuarioRepository();
		usuarioRepository.insertarUsuario(usuario);
	}
}
