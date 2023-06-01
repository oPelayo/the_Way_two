package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import modelo.Articulo;
import modelo.Carrito;

public class DaoCarrito {
	private Connection con = null;


	public DaoCarrito() throws SQLException {

			con = DBconexion.getConnection();
	}

	/**
	 * Inserción de datos de objetos <strong>Carrito en la Base de Datos</strong>
	 * @param c
	 * @throws SQLException
	 */
	public void Insertar(Carrito c) throws SQLException {
		String query = "INSERT INTO Carrito (nombres, precio_v, n_articulos, precio_total, cesta) VALUES (?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, c.getNombres());
		ps.setDouble(2, c.getPrecio());
		ps.setInt(3, c.getN_articulos());
		ps.setDouble(4, c.getPrecio_total());
		Gson gson = new Gson();
		String cestaJson = gson.toJson(c.getCesta());
		ps.setString(5, cestaJson);

		ps.executeUpdate();

		ResultSet generatedKeys = ps.getGeneratedKeys();
		if (generatedKeys.next()) {
			int id_carrito = generatedKeys.getInt(1);
			c.setId_carrito(id_carrito);
		}

		ps.close();
	}

	/**
     * Añade un <strong>artículo al carrito</strong> especificado por su id_carrito
     * @param idArticulo El id del artículo a añadir
     * @param idCarrito El id del carrito al que se añadirá el artículo
     * @throws SQLException
     */
    public void añadirAlCarrito(int idArticulo, int idCarrito) throws SQLException {
        // Obtener el carrito existente
        Carrito carrito = obtenerCarritoPorId(idCarrito);

        // Verificar si el carrito existe
        if (carrito != null) {
            // Obtener la lista de artículos del carrito
            ArrayList<Articulo> cesta = carrito.getCesta();

            // Crear un objeto DaoArticulo para obtener los detalles del artículo
            DaoArticulo daoArticulo = new DaoArticulo();
            String articuloJson = daoArticulo.obtenerPorId(idArticulo);

            // Verificar si el artículo existe
            if (articuloJson != null) {

            	Gson gson = new Gson();
                Articulo articulo = gson.fromJson(articuloJson, Articulo.class);
                cesta.add(articulo);

                actualizarCarrito(carrito);
            } else {
                System.out.println("El artículo no existe.");
            }
        } else {
            System.out.println("El carrito no existe.");
        }
    }

    /**
     * Obtiene un carrito por su id_carrito
     * @param idCarrito El id del carrito a obtener
     * @return El objeto Carrito o null si no se encuentra
     * @throws SQLException
     */
    public Carrito obtenerCarritoPorId(int idcarrito) throws SQLException {
        Carrito carrito = null;

        PreparedStatement ps = con.prepareStatement("SELECT * FROM Carrito WHERE idcarrito = ?");
        ps.setInt(1, idcarrito);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            carrito = new Carrito();
            carrito.setId_carrito(rs.getInt("idcarrito"));
            carrito.setNombres(rs.getString("nombres"));
            carrito.setPrecio(rs.getDouble("precio_v"));
            carrito.setN_articulos(rs.getInt("n_articulos"));
            carrito.setPrecio_total(rs.getDouble("precio_total"));

            // Obtener la cesta del carrito (lista de artículos)
            String cestaJson = rs.getString("cesta");
            System.out.println("cestaJson: " + cestaJson);
            if (cestaJson != null && !cestaJson.isEmpty()) {
            
	            JSONArray jsonArray = new JSONArray(cestaJson);
	            ArrayList<Articulo> cesta = new ArrayList<>();
	
	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject jsonObject = jsonArray.getJSONObject(i);
	
	                // Crear un objeto Articulo a partir de los datos del JSON
	                Articulo articulo = new Articulo();
	                articulo.setId_articulo(jsonObject.getInt("id_articulo"));
	                articulo.setNombre(jsonObject.getString("nombre"));
	                articulo.setPrecio_v(jsonObject.getDouble("precio"));
	                articulo.setFoto(jsonObject.getString("foto"));
	                articulo.setTalla(jsonObject.getString("talla"));
	                articulo.setColor(jsonObject.getString("color"));
	                
	                cesta.add(articulo);
	            }
	            carrito.setCesta(cesta);
            }  
        }  
        

        rs.close();
        ps.close();

        return carrito;
    }

    /**
     * Actualiza los datos del carrito en la base de datos
     * @param carrito El objeto Carrito con los datos actualizados
     * @throws SQLException
     */
    public void actualizarCarrito(Carrito carrito) throws SQLException {
        String query = "UPDATE Carrito SET nombres = ?, precio_v = ?, n_articulos = ?, precio_total = ?, cesta = ? WHERE id_carrito = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, carrito.getNombres());
        ps.setDouble(2, carrito.getPrecio());
        ps.setInt(3, carrito.getN_articulos());
        ps.setDouble(4, carrito.getPrecio_total());

        // Convertir la cesta a formato JSON
        Gson gson = new Gson();
        String cestaJson = gson.toJson(carrito.getCesta());
        ps.setString(5, cestaJson);

        ps.setInt(6, carrito.getId_carrito());

        ps.executeUpdate();

        ps.close();
    }


	/**
	 * Método que <strong>obtiene</strong> los datos del carrito de la <strong>Base de Datos</strong>
	 * @return Array con todos los proveedores
	 * @throws SQLException
	 */
	public ArrayList<Articulo> obtenerContenidoCarrito(int idCarrito) throws SQLException {
	    ArrayList<Articulo> contenidoCarrito = new ArrayList<>();

	    // Realizar la consulta a la base de datos para obtener el contenido del carrito

	    PreparedStatement ps = con.prepareStatement("SELECT a.* FROM Carrito c INNER JOIN Articulo a ON c.articulo_idarticulo = a.idarticulo WHERE c.idcarrito = ?");
	    ps.setInt(1, idCarrito);
	    ResultSet rs = ps.executeQuery();

	    // Recorrer los resultados y crear objetos Articulo para cada fila
	    while (rs.next()) {
	        Articulo a = new Articulo();
	        a.setId_articulo(rs.getInt("id_articulo"));
	        a.setNombre(rs.getString("nombre"));
	        a.setPrecio_v(rs.getDouble("precio"));

	        contenidoCarrito.add(a);
	    }

	    return contenidoCarrito;
	}

	/**
	 * Este metodo pasa los datos de la estructura de objetos de JAVA (del Modelo) a un texto con sisntaxis de JSON
	 * @return
	 * @throws SQLException
	 */
	public String obtenerEnJSON(int idCarrito) throws SQLException {
		String jsonFinal = "";

		Gson gsonFinal = new Gson();
		jsonFinal = gsonFinal.toJson(obtenerContenidoCarrito(idCarrito));

		return jsonFinal;

	}
}
