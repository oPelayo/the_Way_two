package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBconexion;
import dao.DaoSesion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Carrito;
import modelo.Sesion;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	 public Login() {
	    super();
	        // TODO Auto-generated constructor stub
	 }
	 /**
	  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		    String usuario = request.getParameter("username");
		    String pass = request.getParameter("password");

		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;

		    try {
		    	con = DBconexion.getConnection();
		        String query = "SELECT * FROM usuario WHERE nombre=? AND pass=?";
		        ps = con.prepareStatement(query);
		        ps.setString(1, usuario);
		        ps.setString(2, pass);
		        rs = ps.executeQuery();

		        if (rs.next()) {
		        	// El usuario y contraseña son válidos

		            //Instanciamos atributos, creamos el carrito y obtenemos su id
		            int id_usuario = rs.getInt("idusuario");
		            int privilegios = rs.getInt("privilegios");
		            String nombre = rs.getString("nombre");
		            int id_carrito;
		           	Carrito c = new Carrito();
		           	c.insertar();
		           	id_carrito = c.getId_carrito();

		           	//Introducimos los datos de la sesion en la BD
		        	Sesion s = new Sesion(id_usuario, privilegios, nombre, id_carrito);

		        	DaoSesion ds = new DaoSesion();
		        	ds.Insertar(s);

		        	int id_sesion = ds.obtenerIdSesion(id_carrito); // Reemplaza "getIdSesion()" con el método adecuado para obtener el id de la sesión

		            //Inicia la sesion con 5 attributes(id_ sesion, id_usuario, privilegios, nombre,id_carrito )
		            HttpSession session = request.getSession();
		            session.setAttribute("idsesion", id_sesion);
		            session.setAttribute("id_usuario", id_usuario);
		            session.setAttribute("privilegios", privilegios);
		            session.setAttribute("nombre", nombre);
		            session.setAttribute("id_carrito",id_carrito);
		          System.out.println();


		            PrintWriter respuesta = response.getWriter();
		            respuesta.print("sesion iniciada");

		            response.sendRedirect("Index.html");
		        } else {
		            // El usuario y contraseña son inválidos
		            PrintWriter out = response.getWriter();
		            out.println("El usuario y/o la contraseña son incorrectos");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Manejar el error, por ejemplo, enviar una respuesta de error al cliente

		    }

		}

	}






