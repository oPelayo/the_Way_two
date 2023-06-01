package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Proveedor;


public class DaoProveedor {
	private Connection con = null;


	public DaoProveedor() throws SQLException {

			con = DBconexion.getConnection();
	}

	/**
	 * Inserción de datos de objetos Proveedor en la Base de Datos
	 * @param a
	 * @throws SQLException
	 */
	public void Insertar (Proveedor p) throws SQLException {
		PreparedStatement ps = con.prepareStatement
				 ("INSERT INTO Proveedor (estado,nombre,email,telefono) VALUES (?,?,?,?)");
		 		ps.setBoolean(1, p.isEstado());
				ps.setString(2, p.getNombre());
		 		ps.setString(3, p.getEmail());
		 		ps.setString(4, p.getTelefono());

		 		ps.executeUpdate();
				ps.close();
	}


	/**
	 * Metodo que obtiene los datos de la Base de Datos
	 * @return Array con todos los proveedores
	 * @throws SQLException
	 */
	public ArrayList<Proveedor> obtener() throws SQLException{

	PreparedStatement ps = con.prepareStatement("SELECT * FROM proveedor");

	ResultSet rs = ps.executeQuery();

	ArrayList<Proveedor> result = null;

	while(rs.next()) {

		if(result == null) {
			result = new ArrayList<>();
		}

		result.add(new Proveedor(rs.getInt("idproveedor"), rs.getBoolean("estado"), rs.getString("nombre"),
				rs.getString("email"), rs.getString("telefono")));
		}
	return result;
	}

	/*
	 * Este metodo busca en el listado por el id y lo devuelve en JSON
	 */

	public String obtenerPorId(int idproveedor) throws SQLException {

		String Json = "";

		PreparedStatement ps = con.prepareStatement("SELECT * FROM proveedor WHERE idproveedor=?");
		ps.setInt(1, idproveedor);

		ResultSet rs = ps.executeQuery();

		Proveedor p;
		while(rs.next()) {

			p = new Proveedor(rs.getInt("idproveedor"), rs.getBoolean("estado"), rs.getString("nombre"),
					rs.getString("email"), rs.getString("telefono"));
				Gson gsonFinal = new Gson();
				Json = gsonFinal.toJson(p);
		}
		return Json;
	}

	/**
	 * Este metodo pasa los datos de la estructura de objetos de JAVA (del Modelo) a un texto con sisntaxis de JSON
	 * @return
	 * @throws SQLException
	 */
	public String obtenerEnJSON() throws SQLException {
		String jsonFinal = "";

		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(this.obtener());

		return jsonFinal;

	}
}
