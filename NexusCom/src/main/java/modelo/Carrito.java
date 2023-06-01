package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoCarrito;

public class Carrito {

	private int id_carrito;
	private String nombres;
	private double precio;
	private int n_articulos;
	private double precio_total;
	private ArrayList<Articulo> cesta;

	/**
	 * Constructor <strong>vacio</strong>
	 *
	 * @return
	 */
	public Carrito() {
		super();
	}

	/**
	 * Constructor con <strong>todos los atributos</strong>
	 *
	 * @param id_carrito
	 * @param nombres
	 * @param precio
	 * @param n_articulos
	 * @param precio_total
	 * @param cesta
	 */
	public Carrito(int id_carrito, String nombres, double precio, int n_articulos, double precio_total,
			ArrayList<Articulo> cesta) {
		super();
		this.id_carrito = id_carrito;
		this.nombres = nombres;
		this.precio = precio;
		this.n_articulos = n_articulos;
		this.precio_total = precio_total;
		this.cesta = cesta;
	}

	/**
	 * @return the id_carrito
	 */
	public int getId_carrito() {
		return id_carrito;
	}

	/**
	 * @param id_carrito the id_carrito to set
	 */
	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the precio_venta
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the n_articulos
	 */
	public int getN_articulos() {
		return n_articulos;
	}

	/**
	 * @param n_articulos the n_articulos to set
	 */
	public void setN_articulos(int n_articulos) {
		this.n_articulos = n_articulos;
	}

	/**
	 * @return the precio_total
	 */
	public double getPrecio_total() {
		return precio_total;
	}

	/**
	 * @param precio_total the precio_total to set
	 */
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}

	/**
	 * @return the cesta
	 */
	public ArrayList<Articulo> getCesta() {
		return cesta;
	}

	/**
	 * @param cesta the cesta to set
	 */
	public void setCesta(ArrayList<Articulo> cesta) {
		this.cesta = cesta;
	}

	/**
	 * Método para <strong>insertar el carrito</strong> en la Base de datos
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoCarrito c = new DaoCarrito();
		c.Insertar(this);
	}

	/*
	 * Método para <strong>añadir articulos</strong> al arraylist cesta"
	 *
	 */
	public void incluirAlCarrito(int idarticulo, int id_carrito) throws SQLException {
		DaoCarrito dc = new DaoCarrito();

		dc.añadirAlCarrito(idarticulo, id_carrito);
	}




	@Override
	public String toString() {
		return "Carrito [id_carrito=" + id_carrito + ", nombres=" + nombres + ", precio=" + precio + ", n_articulos="
				+ n_articulos + ", precio_total=" + precio_total + ", cesta=" + cesta + ", getId_carrito()="
				+ getId_carrito() + ", getNombres()=" + getNombres() + ", getPrecio()=" + getPrecio()
				+ ", getN_articulos()=" + getN_articulos() + ", getPrecio_total()=" + getPrecio_total()
				+ ", getCesta()=" + getCesta() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
