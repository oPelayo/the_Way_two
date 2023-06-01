package modelo;

import java.sql.SQLException;

import dao.DaoArticulo;

/*
 * Esta clase define objetos Artículos 
 * @author Orlando
 */
public class Articulo {

	private int id_articulo;
	private boolean estado;
	private String nombre;
	private String referencia;
	private String descripcion;
	private String familia_productos;
	private String marca;
	private String perfil;
	private String color;
	private String talla;
	private int stock;
	private double precio_v;
	private double precio_c;
	private String foto;
	private int id_proveedor;

	/**
	 * Constructor <strong>vacio</strong>
	 * @author Orlando
	 */
	public Articulo() {
		super();
	}

	/**
	 * Constructor <strong>sin el precio de coste</strong> para el listado
	 * @author Orlando
	 * @param id_articulo
	 * @param estado
	 * @param nombre
	 * @param referencia
	 * @param descripcion
	 * @param familia_productos
	 * @param marca
	 * @param perfil
	 * @param color
	 * @param talla
	 * @param stock
	 * @param precio_v
	 * @param foto
	 * @param id_proveedor
	 */
	public Articulo(int id_articulo, boolean estado, String nombre, String referencia, String descripcion,
			String familia_productos, String marca, String perfil, String color, String talla, int stock,
			double precio_v, String foto, int id_proveedor) {
		super();
		this.id_articulo = id_articulo;
		this.estado = estado;
		this.nombre = nombre;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.familia_productos = familia_productos;
		this.marca = marca;
		this.perfil = perfil;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
		this.precio_v = precio_v;
		this.foto = foto;
		this.id_proveedor = id_proveedor;
	}

	/**
	 * Constructor <strong>sin id</strong> para el alta
	 * @author Orlando
	 * @param estado
	 * @param nombre
	 * @param referencia
	 * @param descripcion
	 * @param familia_productos
	 * @param marca
	 * @param perfil
	 * @param color
	 * @param talla
	 * @param stock
	 * @param precio_v
	 * @param precio_c
	 * @param foto
	 * @param id_proveedor
	 */
	public Articulo(boolean estado, String nombre, String referencia, String descripcion, String familia_productos,
			String marca, String perfil, String color, String talla, int stock, double precio_v, double precio_c,
			String foto, int id_proveedor) {
		super();
		this.estado = estado;
		this.nombre = nombre;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.familia_productos = familia_productos;
		this.marca = marca;
		this.perfil = perfil;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
		this.precio_v = precio_v;
		this.precio_c = precio_c;
		this.foto = foto;
		this.id_proveedor = id_proveedor;
	}

	/**
	 * Constructor <strong>con todo</strong> para Administración
	 * @author Orlando
	 * @param id_articulo
	 * @param estado
	 * @param nombre
	 * @param referencia
	 * @param descripcion
	 * @param familia_productos
	 * @param marca
	 * @param perfil
	 * @param color
	 * @param talla
	 * @param stock
	 * @param precio_v
	 * @param precio_c
	 * @param foto
	 * @param id_proveedor
	 */
	public Articulo(int id_articulo, boolean estado, String nombre, String referencia, String descripcion,
			String familia_productos, String marca, String perfil, String color, String talla, int stock,
			double precio_v, double precio_c, String foto, int id_proveedor) {
		super();
		this.id_articulo = id_articulo;
		this.estado = estado;
		this.nombre = nombre;
		this.referencia = referencia;
		this.descripcion = descripcion;
		this.familia_productos = familia_productos;
		this.marca = marca;
		this.perfil = perfil;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
		this.precio_v = precio_v;
		this.precio_c = precio_c;
		this.foto = foto;
		this.id_proveedor = id_proveedor;
	}

	/**
	 * @author Orlando
	 * @return the id_articulo
	 */
	public int getId_articulo() {
		return id_articulo;
	}

	/**
	 * @author Orlando
	 * @param id_articulo the id_articulo to set
	 */
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	/**
	 * @author Orlando
	 * @return the estado
	 */
	public boolean getEstado() {
		return estado;
	}

	/**
	 * @author Orlando
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @author Orlando
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @author Orlando
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	/**
	 * @author Orlando
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @author Orlando
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @author Orlando
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @author Orlando
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @author Orlando
	 * @return the familia_productos
	 */
	public String getFamilia_productos() {
		return familia_productos;
	}

	/**
	 * @author Orlando
	 * @param familia_productos the familia_productos to set
	 */
	public void setFamilia_productos(String familia_productos) {
		this.familia_productos = familia_productos;
	}

	/**
	 * @author Orlando
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @author Orlando
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @author Orlando
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @author Orlando
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * @author Orlando
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @author Orlando
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @author Orlando
	 * @return the talla
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * @author Orlando
	 * @param talla the talla to set
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	/**
	 * @author Orlando
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @author Orlando
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @author Orlando
	 * @return the precio_v
	 */
	public double getPrecio_v() {
		return precio_v;
	}

	/**
	 * @author Orlando
	 * @param precio_v the precio_v to set
	 */
	public void setPrecio_v(double precio_v) {
		this.precio_v = precio_v;
	}

	/**
	 * @author Orlando
	 * @return the precio_c
	 */
	public double getPrecio_c() {
		return precio_c;
	}

	/**
	 * @author Orlando
	 * @param precio_c the precio_c to set
	 */
	public void setPrecio_c(double precio_c) {
		this.precio_c = precio_c;
	}

	/**
	 * @author Orlando
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @author Orlando
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @author Orlando
	 * @return the id_proveedor
	 */
	public int getId_proveedor() {
		return id_proveedor;
	}

	/**
	 * @author Orlando
	 * @param id_proveedor the id_proveedor to set
	 */
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	/**
	 * Método para insertar el <strong>articulo</strong> en la Base de Datos
	 * @author Orlando
	 * @see (#Insertar(); DaoArticulo#Insertar(); dao.DaoArticulo; {@link dao.DaoArticulo#Insertar(Articulo)}
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoArticulo a = new DaoArticulo();
		a.Insertar(this);
	}

	@Override
	public String toString() {
		return "Articulo [id_articulo=" + id_articulo + ", estado=" + estado + ", nombre=" + nombre + ", referencia="
				+ referencia + ", descripcion=" + descripcion + ", familia_productos=" + familia_productos + ", marca="
				+ marca + ", perfil=" + perfil + ", color=" + color + ", talla=" + talla + ", stock=" + stock
				+ ", precio_v=" + precio_v + ", precio_c=" + precio_c + ", foto=" + foto + ", id_proveedor="
				+ id_proveedor + ", getId_articulo()=" + getId_articulo() + ", getEstado()=" + getEstado()
				+ ", getNombre()=" + getNombre() + ", getReferencia()=" + getReferencia() + ", getDescripcion()="
				+ getDescripcion() + ", getFamilia_productos()=" + getFamilia_productos() + ", getMarca()=" + getMarca()
				+ ", getPerfil()=" + getPerfil() + ", getColor()=" + getColor() + ", getTalla()=" + getTalla()
				+ ", getStock()=" + getStock() + ", getPrecio_v()=" + getPrecio_v() + ", getPrecio_c()=" + getPrecio_c()
				+ ", getFoto()=" + getFoto() + ", getId_proveedor()=" + getId_proveedor() + "]";
	}

}
