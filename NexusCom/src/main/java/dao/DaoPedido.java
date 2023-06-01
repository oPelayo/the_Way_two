package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Pedido;








public class DaoPedido {
	private Connection con = null;


	public DaoPedido() throws SQLException {

			con = DBconexion.getConnection();
	}

	/**
	 * Inserción de datos de objetos <strong>Pedido</strong> en la Base de Datos
	 * @param s
	 * @throws SQLException
	 */
	public void Insertar (Pedido p) throws SQLException {

		PreparedStatement ps = con.prepareStatement
				 ("INSERT INTO Pedido (fecha,idcarrito,idvendedor) VALUES (?,?,?,?)");

		 		ps.setDate(2, p.getFecha());
		 		ps.setInt(4, p.getId_carrito());
		 		ps.setInt(3, p.getId_vendedor());

		 		ps.executeUpdate();
				ps.close();
	}


	/**
	 * Método que <strong>obtiene</strong> los datos de los Pedidos de la <strong>Base de Datos</strong>
	 * @return Array con todos los proveedores
	 * @throws SQLException
	 */
	public ArrayList<Pedido> obtener() throws SQLException{

		PreparedStatement ps = con.prepareStatement("SELECT * FROM pedido");

		ResultSet rs = ps.executeQuery();

		ArrayList<Pedido> result = null;

		while(rs.next()) {

			if(result == null) {
				result = new ArrayList<>();
			}

			result.add(new Pedido(rs.getDate("fecha"), rs.getInt("idcarrito"),rs.getInt("idvendedor")));
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
}
