package controlador;
import java.io.IOException;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


	/**
	 * Servlet implementation class VerLogin
	 */
	@WebServlet("/ComprobarSesion")
	public class ComprobarSesion extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ComprobarSesion() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub


			//Inicia sesion con 5 atributos
			HttpSession sesion = request.getSession();
			Integer id_sesion = (Integer) sesion.getAttribute("idsesion");
			Integer id_usuario = (Integer)sesion.getAttribute("id_usuario");
			Integer privilegios = (Integer) sesion.getAttribute("privilegios");
			String nombre = (String) sesion.getAttribute("nombre");
			Integer id_carrito = (Integer) sesion.getAttribute("id_carrito");



			  // Crear objeto JSON con nombre y privilegios
		    JSONObject json = new JSONObject();
		    json.put("nombre", nombre);
		    json.put("privilegios", privilegios);
		    json.put("id_carrito", id_carrito);

		    // Envía la respuesta en formato JSON

		    response.getWriter().write(json.toString());
		}





		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}






	}

