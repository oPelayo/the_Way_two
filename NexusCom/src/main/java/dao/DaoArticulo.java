package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import modelo.Articulo;


public class DaoArticulo {
	private Connection con = null;


	public DaoArticulo() throws SQLException {

			con = DBconexion.getConnection();
	}

	/**
	 * Insercion de datos de objetos articulo en la BD
	 * @param a
	 * @throws SQLException
	 */
	public void Insertar (Articulo a) throws SQLException {
		PreparedStatement ps = con.prepareStatement
				 ("INSERT INTO Articulo (estado,nombre,referencia,descripcion,familia_productos,perfil,marca,color,talla,stock,precio_venta,precio_coste,foto,proveedor_idproveedor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 		ps.setBoolean(1, a.getEstado());
				ps.setString(2, a.getNombre());
		 		ps.setString(3, a.getReferencia());
		 		ps.setString(4, a.getDescripcion());
		 		ps.setString(5, a.getFamilia_productos());
		 		ps.setString(6, a.getPerfil());
		 		ps.setString(7, a.getMarca());
		 		ps.setString(8, a.getColor());
		 		ps.setString(9, a.getTalla());
		 		ps.setInt(10, a.getStock());
		 		ps.setDouble(11, a.getPrecio_v());
		 		ps.setDouble(12, a.getPrecio_c());
		 		ps.setString(13, a.getFoto());
		 		ps.setInt(14, a.getId_proveedor());


		 		ps.executeUpdate();
				ps.close();
	}


	/**
	 * Metodo que obtiene los datos de la Base de Datos y las pinta en un array
	 * @return el Array "result" con la informacion de todos los articulos
	 * @throws SQLException
	 */
	public ArrayList<Articulo> obtener() throws SQLException{

	PreparedStatement ps = con.prepareStatement("SELECT * FROM articulo");

	ResultSet rs = ps.executeQuery();

	ArrayList<Articulo> result = null;

	while(rs.next()) {

		if(result == null) {
			result = new ArrayList<>();
		}

		result.add(new Articulo(rs.getInt("idarticulo"), rs.getBoolean("estado"), rs.getString("nombre"),
				rs.getString("referencia"), rs.getString("descripcion"), rs.getString("familia_productos"),
				rs.getString("perfil"), rs.getString("marca"), rs.getString("color"), rs.getString("talla"),
				rs.getInt("stock"),rs.getDouble("precio_venta"), rs.getDouble("precio_coste"),
				rs.getString("foto"),rs.getInt("proveedor_idproveedor")));
		}
	return result;
	}

	/*
	 * Metodo que busca en la base de datos algun objeto que se parezca en el campo nombre
	 * @param nombre El nombre o parte del nombre del artículo a buscar.
	 * @return Una cadena en formato JSON que representa los artículos encontrados.
	 * @throws SQLException si ocurre algun error
	 */
	public String obtenerPorNombre(String nombre) throws SQLException {
		String json = "";

		PreparedStatement ps = con.prepareStatement("SELECT * FROM articulo WHERE nombre like ?");
		ps.setString(1, "%"+nombre+"%");

		ResultSet rs = ps.executeQuery();
		List<Articulo> ar = new ArrayList<>();

		while(rs.next()) {
			Articulo a = new Articulo(rs.getInt("idarticulo"), rs.getBoolean("estado"), rs.getString("nombre"),
					rs.getString("referencia"), rs.getString("descripcion"), rs.getString("familia_productos"),
					rs.getString("perfil"), rs.getString("marca"), rs.getString("color"), rs.getString("talla"),
					rs.getInt("stock"),rs.getDouble("precio_venta"), rs.getDouble("precio_coste"),
					rs.getString("foto"),rs.getInt("proveedor_idproveedor"));
				ar.add(a);
			}
		Gson gsonF = new Gson();
		json = gsonF.toJson(ar);

		return json;
	}
	/*
	 * Metodo que busca en la base de datos algun objeto que se parezca en el campo nombre
	 * @param nombre El nombre o parte del nombre del artículo a buscar.
	 * @return Una cadena en formato JSON que representa los artículos encontrados.
	 * @throws SQLException si ocurre algun error
	 */
	public String obtenerPorFamilia(String familia_productos) throws SQLException {
		String json = "";

		PreparedStatement ps = con.prepareStatement("SELECT * FROM articulo WHERE familia_productos like ?");
		ps.setString(1, "%"+familia_productos+"%");

		ResultSet rs = ps.executeQuery();
		List<Articulo> ar = new ArrayList<>();

		while(rs.next()) {
			Articulo a = new Articulo(rs.getInt("idarticulo"), rs.getBoolean("estado"), rs.getString("nombre"),
					rs.getString("referencia"), rs.getString("descripcion"), rs.getString("familia_productos"),
					rs.getString("perfil"), rs.getString("marca"), rs.getString("color"), rs.getString("talla"),
					rs.getInt("stock"),rs.getDouble("precio_venta"), rs.getDouble("precio_coste"),
					rs.getString("foto"),rs.getInt("proveedor_idproveedor"));
				ar.add(a);
			}
		Gson gsonF = new Gson();
		json = gsonF.toJson(ar);

		return json;
	}

	/**
	 * Este metodo Busca en la Base de datos coincidencias por el en el "id" y lo devuelve en un texto con sisntaxis de JSON
	 * @param El id introducido por el Usuario
	 * @return json
	 * @throws SQLException si ocurre algun error
	 */
	public String obtenerPorId(int idarticulo) throws SQLException {

		String json = null;

	    PreparedStatement ps = con.prepareStatement("SELECT * FROM articulo WHERE idarticulo=?");
	    ps.setInt(1, idarticulo);

	    ResultSet rs = ps.executeQuery();

	    if (rs.next()) {
	        Articulo a = new Articulo(rs.getInt("idarticulo"), rs.getBoolean("estado"), rs.getString("nombre"),
	                rs.getString("referencia"), rs.getString("descripcion"), rs.getString("familia_productos"),
	                rs.getString("perfil"), rs.getString("marca"), rs.getString("color"), rs.getString("talla"),
	                rs.getInt("stock"),rs.getDouble("precio_venta"), rs.getDouble("precio_coste"),
	                rs.getString("foto"),rs.getInt("proveedor_idproveedor"));

	        Gson gson = new Gson();
	        json = gson.toJson(a);
	    }

	    return json;
	}

	/**
	 * Este metodo pasa los datos de la estructura de objetos de JAVA (del Modelo) a un texto con sisntaxis de JSON
	 * @return jsonFinal
	 * @throws SQLException si ocurre algun error
	 */
	public String obtenerEnJSON() throws SQLException {
		String jsonFinal = "";

		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(this.obtener());

		return jsonFinal;

	}
}







