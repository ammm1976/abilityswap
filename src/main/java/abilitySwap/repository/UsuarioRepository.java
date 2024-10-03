package abilitySwap.repository;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import abilitySwap.bean.Usuario;



public class UsuarioRepository {
	
	public static final String EXISTE_USUARIO = "SELECT * FROM abilityswapbd.usuarios WHERE nombre = ? AND password = ?";
	public static final String INSERTAR_USUARIO = "INSERT INTO `abilityswapbd`.`usuarios` (`nombre`, `password`, `foto`) VALUES (?,?,?);";
	
	public boolean existeUsuario (Usuario usuario) throws SQLException
	{
		boolean existe = false;
			
			Connection connection = Pool.getConnection();
			PreparedStatement ps =  connection.prepareStatement(EXISTE_USUARIO);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getPassword());
			ps.execute();
			existe = ps.getResultSet().next();
			
			Pool.liberarRecursos(connection, ps, null);
			
		
		return existe;
	}
	
    public void insertarUsuario(Usuario usuario) throws SQLException {
        Connection connection = Pool.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERTAR_USUARIO);
        ps.setString(1, usuario.getUsuario());
        ps.setString(2, usuario.getPassword());
        ps.setBinaryStream(3, new ByteArrayInputStream(usuario.getFoto()), usuario.getFoto().length);
        ps.executeUpdate();

        Pool.liberarRecursos(connection, ps, null);
    }
}
