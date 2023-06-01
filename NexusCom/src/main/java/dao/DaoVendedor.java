package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Vendedor;


public class DaoVendedor {
	private Connection con = null;


	public DaoVendedor() throws SQLException {

			con = DBconexion.getConnection();
	}

	/**
	 * Inserción de datos de objetos Vendedor en la Base de Datos
	 * @param a
	 * @throws SQLException
	 */
	public void Insertar (Vendedor v) throws SQLException {
		PreparedStatement ps = con.prepareStatement
				 ("INSERT INTO usuario (estado,privilegios,nombre,apellidos,nif,fecha_nacimiento,puesto,direccion,codigo_postal,telefono,email,pass,foto,notificaciones,gdpr) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			 		ps.setBoolean(1, v.isEstado());
			 		ps.setInt(2, v.getPrivilegios());
					ps.setString(3, v.getNombre());
			 		ps.setString(4, v.getApellidos());
			 		ps.setString(5, v.getNif());
			 		ps.setDate(6, v.getFecha_nacimiento());
			 		ps.setString(7, v.getPuesto());
			 		ps.setString(8, v.getDireccion());
			 		ps.setInt(9, v.getCodigo_postal());
			 		ps.setString(10, v.getTelefono());
			 		ps.setString(11, v.getEmail());
			 		ps.setString(12, v.getPassword());
			 		ps.setString(13, v.getFoto());
			 		ps.setBoolean(14, v.isNotificaciones());
			 		ps.setBoolean(15, v.isGdpr());
		 		ps.executeUpdate();
				ps.close();
	}


	/**
	 * Metodo que obtiene los datos de la Base de Datos
	 * @return Array con todos los proveedores
	 * @throws SQLException
	 */
	public ArrayList<Vendedor> obtener() throws SQLException{

	PreparedStatement ps = con.prepareStatement("SELECT * FROM vendedor");

	ResultSet rs = ps.executeQuery();

	ArrayList<Vendedor> result = null;

	while(rs.next()) {

		if(result == null) {
			result = new ArrayList<>();
		}

		result.add(new Vendedor(rs.getInt("id_vendedor"), rs.getBoolean("estado"), rs.getInt("privilegios"),
				rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nif"), rs.getDate("fecha_nacimiento"),
				rs.getString("puesto"), rs.getString("direccion"), rs.getInt("codigo_postal"),
				rs.getString("telefono"), rs.getString("email"), rs.getString("pass"), rs.getString("foto"),
				rs.getBoolean("notificaciones"), rs.getBoolean("gdpr")));
		}
	return result;
	}

	/*
	 * Este metodo busca en el listado por el id y lo devuelve en JSON
	 */

	public String obtenerPorId(int id_vendedor) throws SQLException {

		String Json = "";

		PreparedStatement ps = con.prepareStatement("SELECT * FROM proveedor WHERE id_vendedor=?");
		ps.setInt(1, id_vendedor);

		ResultSet rs = ps.executeQuery();

		Vendedor v;
		while(rs.next()) {

			v = new Vendedor(rs.getInt("id_vendedor"), rs.getBoolean("estado"), rs.getInt("privilegios"),
					rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nif"), rs.getDate("fecha_nacimiento"),
					rs.getString("puesto"), rs.getString("direccion"), rs.getInt("codigo_postal"),
					rs.getString("telefono"), rs.getString("email"), rs.getString("pass"), rs.getString("foto"),
					rs.getBoolean("notificaciones"), rs.getBoolean("gdpr"));
				Gson gsonFinal = new Gson();
				Json = gsonFinal.toJson(v);
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
