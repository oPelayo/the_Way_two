package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;

public class DaoUsuario {
	private Connection con = null;


	public DaoUsuario() throws SQLException {

			con = DBconexion.getConnection();
	}


	public void Insertar (Usuario u) throws SQLException {
		PreparedStatement ps = con.prepareStatement
				 ("INSERT INTO usuario (estado,privilegios,nombre,apellidos,nif,fecha_nacimiento,direccion,codigo_postal,telefono,email,pass,foto,notificaciones,gdpr) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 		ps.setBoolean(1, u.isEstado());
		 		ps.setInt(2, u.getPrivilegios());
				ps.setString(3, u.getNombre());
		 		ps.setString(4, u.getApellidos());
		 		ps.setString(5, u.getNif());
		 		ps.setDate(6, u.getFecha_nacimiento());
		 		ps.setString(7, u.getDireccion());
		 		ps.setInt(8, u.getCodigo_postal());
		 		ps.setString(9, u.getTelefono());
		 		ps.setString(10, u.getEmail());
		 		ps.setString(11, u.getPassword());
		 		ps.setString(12, u.getFoto());
		 		ps.setBoolean(13, u.isNotificaciones());
		 		ps.setBoolean(14, u.isGdpr());

		 		ps.executeUpdate();
				ps.close();


	}


	/**
	 * Metodo que obtiene los datos de la Base de Datos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Usuario> obtener() throws SQLException{

	PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario");

	ResultSet rs = ps.executeQuery();

	ArrayList<Usuario> result = null;

	while(rs.next()) {

		if(result == null) {
			result = new ArrayList<>();
		}

		result.add(new Usuario(rs.getInt("idusuario"), rs.getBoolean("estado"),rs.getInt("privilegios"), rs.getString("nombre"),
				rs.getString("apellidos"), rs.getString("nif"), rs.getDate("fecha_nacimiento"),
				rs.getString("direccion"), rs.getInt("codigo_postal"), rs.getString("telefono"), rs.getString("email"),
				rs.getString("pass"),rs.getString("foto"), rs.getBoolean("notificaciones"),
				rs.getBoolean("gdpr")));
		}
	return result;
	}

	public String obtenerPorNombre(String nombre) throws SQLException {
		String Json = "";

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE nombre=?");
		ps.setString(1, nombre);

		ResultSet rs = ps.executeQuery();
		Usuario u;
		while(rs.next()) {
			u = new Usuario(rs.getInt("idusuario"), rs.getBoolean("estado"),rs.getInt("privilegios"), rs.getString("nombre"),
					rs.getString("apellidos"), rs.getString("nif"), rs.getDate("fecha_nacimiento"),
					rs.getString("direccion"), rs.getInt("codigo_postal"), rs.getString("telefono"), rs.getString("email"),
					rs.getString("pass"),rs.getString("foto"), rs.getBoolean("notificaciones"),
					rs.getBoolean("gdpr"));
				Gson gsonFinal = new Gson();
				Json = gsonFinal.toJson(u);
		}
		return Json;
	}

	public String obtenerPorId(int idUsuario) throws SQLException {

		String Json = "";

		PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE idusuario=?");
		ps.setInt(1, idUsuario);

		ResultSet rs = ps.executeQuery();

		Usuario u;
		while(rs.next()) {

			u = new Usuario(rs.getInt("idUsuario"), rs.getBoolean("estado"),rs.getInt("privilegios"), rs.getString("nombre"),
					rs.getString("apellidos"), rs.getString("nif"), rs.getDate("fecha_nacimiento"),
					rs.getString("direccion"), rs.getInt("codigo_postal"), rs.getString("telefono"), rs.getString("email"),
					rs.getString("pass"),rs.getString("foto"), rs.getBoolean("notificaciones"),
					rs.getBoolean("gdpr"));
				Gson gsonFinal = new Gson();
				Json = gsonFinal.toJson(u);
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














