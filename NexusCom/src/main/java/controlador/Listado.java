package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.DaoArticulo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Listado
 */
@WebServlet("/Listado")
public class Listado extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter respuesta = response.getWriter();
		String json = "";

		String nombreInput = request.getParameter("buscar");

		if (nombreInput != null) { //Si nombreInput no es nulo, buscar por nombre
		    try {
		        DaoArticulo dao = new DaoArticulo();
		        json = dao.obtenerPorNombre(nombreInput);
		        respuesta.print(json);
		    } catch (SQLException e) {
		        e.printStackTrace();

		    }
		} else { // En otro caso, imprime todo.
		    try {
		        DaoArticulo dao = new DaoArticulo();
		        json = dao.obtenerEnJSON();
		        respuesta.print(json);
		    } catch (SQLException e) {
		        e.printStackTrace();

		    }
		}




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


