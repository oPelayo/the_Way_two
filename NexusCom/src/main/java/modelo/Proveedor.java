package modelo;

import java.sql.SQLException;

import dao.DaoProveedor;

/*
 * Atributos Proveedor
 */
public class Proveedor {

	private int id_proveedor;
	private boolean estado;
	private String nombre;
	private String email;
	private String telefono;

	/**
	 * Constructor <strong>vacio</strong>
	 */
	public Proveedor() {
		super();
	}

	/**
	 * Constructor para el <strong>formulario</strong>
	 *
	 * @param estado
	 * @param nombre
	 * @param email
	 * @param telefono
	 */
	public Proveedor(boolean estado, String nombre, String email, String telefono) {
		super();
		this.estado = estado;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * Constructor <strong>completo</strong>
	 *
	 * @param id_proveedor
	 * @param estado
	 * @param nombre
	 * @param email
	 * @param telefono
	 */
	public Proveedor(int id_proveedor, boolean estado, String nombre, String email, String telefono) {
		super();
		this.id_proveedor = id_proveedor;
		this.estado = estado;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * @return the id_proveedor
	 */
	public int getId_proveedor() {
		return id_proveedor;
	}

	/**
	 * @param id_proveedor the id_proveedor to set
	 */
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método para <strong>insertar al proveedor</strong> en la Base de datos
	 *
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoProveedor p = new DaoProveedor();
		p.Insertar(this);
	}

	@Override
	public String toString() {
		return "Proveedor [id_proveedor=" + id_proveedor + ", estado=" + estado + ", nombre=" + nombre + ", email="
				+ email + ", telefono=" + telefono + "]";
	}

}
