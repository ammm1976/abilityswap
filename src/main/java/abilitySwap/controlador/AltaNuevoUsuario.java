package abilitySwap.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.sql.SQLException;

import abilitySwap.bean.Usuario;
import abilitySwap.service.UsuarioService;

/**
 * Servlet implementation class AltaNuevoUsuario
 */

@MultipartConfig //para recibir info de formulario y ficheros
public class AltaNuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaNuevoUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");//tiene que coincidir con el atributo name
		String password = request.getParameter("password");
	    Part filePart = request.getPart("fichero");
		
	    byte[] foto = filePart.getInputStream().readAllBytes();
	    
	    String fileName = filePart.getSubmittedFileName();
	    System.out.println("Fichero subido = " + fileName);
	    
	    Usuario nuevoUsuario = new Usuario(0, usuario, password, foto);
	    
		UsuarioService usuarioService = new UsuarioService();
		
		try {
			usuarioService.insertarUsuario(nuevoUsuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}