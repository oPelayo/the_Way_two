package controlador;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Usuario;



/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
@MultipartConfig
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ruta de la carpeta donde guardo los archivos subidos.
	private String pathFiles = "C:/Cosas/DAW/Programacion/Nexuscom/src/main/webapp/fotos/fotosUsuarios";
	private File uploads = new File(pathFiles);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	 public AltaUsuario() {
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

		boolean estado = true;
		int privilegios = 10;
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String nif = request.getParameter("nif");
		Date fecha_nacimiento = Date.valueOf(request.getParameter("fecha_nacimiento")) ;
		String direccion = request.getParameter("direccion");
		int codigo_postal = Integer.parseInt(request.getParameter("codigo_postal"));
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String foto = this.SubirFoto(request, response);
		boolean notificaciones = Boolean.parseBoolean(request.getParameter("notificaciones"));
		boolean gdpr = Boolean.parseBoolean(request.getParameter("gdpr")) ;

		Usuario u = new Usuario(estado, privilegios, nombre, apellidos, nif, fecha_nacimiento, direccion, codigo_postal, telefono, email, password, foto, notificaciones, gdpr);

		try {
			u.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se ha insertado  en la BD");
		}

	response.sendRedirect("login.html");

	}


	private String SubirFoto(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//Recupero los datos del archivo - contenido
		Part part = request.getPart("foto");
		//Leo ubicación  - contiente
		Path path = Paths.get(part.getSubmittedFileName());
		//Recupero nombre de archivo - continente
		String fileName = path.getFileName().toString();

		//Esto no lo estamos haciendo.
		// revisar el no tener un archivo con el nombre.
		// el nombre del archivo no tenga caracteres
		// validar el tamaño y el tipo


		//creo el objeto para transmitir
		InputStream input = part.getInputStream();


		//crear un contenedor (el archivo) Importante, este contenedor aun esta vacio
		File foto = new File(uploads,fileName);

		//Meto los datos dentro del archivo creado.

		try {
			Files.copy(input, foto.toPath());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Upss, la foto no se ha insertado");
		}

		return fileName;

	}

}




