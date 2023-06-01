package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Articulo;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaArticulo")
@MultipartConfig
public class AltaArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Defino la ruta de la carpeta donde guardare los archivos subidos
	private String pathFiles = "C:/Cosas/DAW/Programacion/Nexuscom/src/main/webapp/fotos/fotosArticulos";
	private File uploads = new File(pathFiles);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	 public AltaArticulo() {
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

		boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
		String nombre = request.getParameter("nombre");
		String referencia = request.getParameter("referencia");
		String descripcion = request.getParameter("descripcion");
		String familia_productos = request.getParameter("familia_productos");
		String perfil = request.getParameter("perfil");
		String marca = request.getParameter("marca");
		String color = request.getParameter("color");
		String talla = request.getParameter("talla");
		int stock = Integer.parseInt(request.getParameter("stock"));
		double precio_v = Double.parseDouble(request.getParameter("precio_v"));
		double precio_c = Double.parseDouble(request.getParameter("precio_c"));
		String foto = this.SubirFoto(request, response);
		int idproveedor = Integer.parseInt(request.getParameter("idproveedor"));




		Articulo a = new Articulo(estado, nombre, referencia, descripcion, familia_productos, perfil, marca, color,
				talla, stock, precio_v, precio_c, foto, idproveedor);

		try {
			a.insertar();
			response.sendRedirect("altaArticulo.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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

