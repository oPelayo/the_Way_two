package modelo;

import java.sql.SQLException;

import dao.DaoSesion;

public class Sesion {

	private int id_sesion;
	private int id_usuario;
	private int privilegios;
	private String nombre;
	private int id_carrito;

	/**
	 * Constructor vacio
	 */
	public Sesion() {
		super();
	}


	/**
	 * Constructor <strong>sin el id</strong> para cuando estamos haciendo login
	 * @param id_usuario
	 * @param privilegios
	 * @param nombre
	 * @param id_carrito
	 */
	public Sesion(int id_usuario, int privilegios, String nombre, int id_carrito) {
		super();
		this.id_usuario = id_usuario;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.id_carrito = id_carrito;
	}


	/**
	 * Constructor sin carrito
	 *
	 * @param id_sesion
	 * @param id_usuario
	 * @param privilegios
	 * @param nombre
	 */
	public Sesion(int id_sesion, int id_usuario, int privilegios, String nombre) {
		super();
		this.id_sesion = id_sesion;
		this.id_usuario = id_usuario;
		this.privilegios = privilegios;
		this.nombre = nombre;
	}

	/**
	 * Constructor con todo
	 *
	 * @param id_sesion
	 * @param id_usuario
	 * @param privilegios
	 * @param nombre
	 * @param id_carrito
	 */
	public Sesion(int id_sesion, int id_usuario, int privilegios, String nombre, int id_carrito) {
		super();
		this.id_sesion = id_sesion;
		this.id_usuario = id_usuario;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.id_carrito = id_carrito;
	}

	/**
	 * @return the id_sesion
	 */
	public int getId_sesion() {
		return id_sesion;
	}

	/**
	 * @param id_sesion the id_sesion to set
	 */
	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	/**
	 * @return the id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @return the privilegios
	 */
	public int getPrivilegios() {
		return privilegios;
	}

	/**
	 * @param privilegios the privilegios to set
	 */
	public void setPrivilegios(int privilegios) {
		this.privilegios = privilegios;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * Método para insertar la <strong>sesion</strong> en la Base de datos
	 *
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoSesion s = new DaoSesion();
		s.Insertar(this);
	}

	@Override
	public String toString() {
		return "Sesion [id_sesion=" + id_sesion + ", id_usuario=" + id_usuario + ", privilegios=" + privilegios
				+ ", nombre=" + nombre + ", id_carrito=" + id_carrito + ", getId_sesion()=" + getId_sesion()
				+ ", getId_usuario()=" + getId_usuario() + ", getPrivilegios()=" + getPrivilegios() + ", getNombre()="
				+ getNombre() + ", getId_carrito()=" + getId_carrito() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
