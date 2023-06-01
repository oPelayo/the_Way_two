package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Sesion;


public class DaoSesion {
	private Connection con = null;


	public DaoSesion() throws SQLException {

			con = DBconexion.getConnection();
	}

	/**
	 * Inserción de datos de objetos <strong>Sesion</strong> en la Base de Datos
	 * @param s
	 * @throws SQLException
	 */
	public void Insertar (Sesion s) throws SQLException {

		PreparedStatement ps = con.prepareStatement
				 ("INSERT INTO Sesion (idusuario,privilegios,nombre,idcarrito) VALUES (?,?,?,?)");
				ps.setInt(1, s.getId_usuario());
		 		ps.setInt(2, s.getPrivilegios());
		 		ps.setString(3, s.getNombre());
		 		ps.setInt(4, s.getId_carrito());

		 		ps.executeUpdate();
				ps.close();
	}

	/**
	 * Método para obtener la <strong>id de la sesión</strong> despues de Iniciar sesion
	 * @param idusuario
	 * @return El id del carrito
	 */
	public int obtenerIdSesion(int idcarrito) {
	    int id_sesion = 0;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = con.prepareStatement("SELECT idsesion FROM sesion WHERE idcarrito = ?");
	        ps.setInt(1, idcarrito);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            id_sesion = rs.getInt("idsesion");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();

	    }

	    return id_sesion;
	}

	/**
	 * Método para obtener los <strong>privilegios</strong> con la id del usuario
	 * @param idusuario
	 * @return privilegios
	 */
	public int obtenerPrivilegios(int idusuario) {
		int privilegios = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;

	    try {
	        ps = con.prepareStatement("SELECT idcarrito FROM sesion WHERE idusuario = ?");
	        ps.setInt(1, idusuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            privilegios = rs.getInt("privilegios");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();

	    }

		return privilegios;
	}
	/**
	 * Método para obtener la <strong>id del carrito</strong> despues de Iniciar sesion
	 * @param idusuario
	 * @return El id del carrito
	 */
	public int obtenerIdCarrito(int idusuario) {
	    int idCarrito = 0;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = con.prepareStatement("SELECT idcarrito FROM sesion WHERE idusuario = ?");
	        ps.setInt(1, idusuario);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            idCarrito = rs.getInt("idcarrito");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();

	    }

	    return idCarrito;
	}


	/**
	 * Método que <strong>obtiene</strong> los datos del carrito de la <strong>Base de Datos</strong>
	 * @return Array con todos los proveedores
	 * @throws SQLException
	 */
	public ArrayList<Sesion> obtener() throws SQLException{

		PreparedStatement ps = con.prepareStatement("SELECT * FROM sesion");

		ResultSet rs = ps.executeQuery();

		ArrayList<Sesion> result = null;

		while(rs.next()) {

			if(result == null) {
				result = new ArrayList<>();
			}

			result.add(new Sesion(rs.getInt("idsesion"), rs.getInt("idusuario"),rs.getInt("privilegios"), rs.getString("nombre"),
					rs.getInt("idcarrito")));
			}
		return result;
		}


	/**
	 * Este metodo pasa los datos de la estructura de objetos de JAVA (del Modelo) a un texto con sisntaxis de JSON
	 * @return Json
	 * @throws SQLException
	 */
	public String obtenerEnJSON() throws SQLException {
		String jsonFinal = "";

		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(this.obtener());

		return jsonFinal;

	}

	public int getId_seion() {
		// TODO Auto-generated method stub
		return 0;
	}
}
