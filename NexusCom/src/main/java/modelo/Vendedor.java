package modelo;

import java.sql.Date;
import java.sql.SQLException;

import dao.DaoVendedor;

/*
 * Atributos del Objeto
 */
public class Vendedor {

	private int id_vendedor;
	private boolean estado;
	private int privilegios;
	private String nombre;
	private String apellidos;
	private String nif;
	private Date fecha_nacimiento;
	private String puesto;
	private String direccion;
	private int codigo_postal;
	private String telefono;
	private String email;
	private String password;
	private String foto;
	private boolean notificaciones;
	private boolean gdpr;

	/*
	 * Constructor <strong>Vacio</strong>
	 */
	public Vendedor() {

	}

	/**
	 * Constructor para el <strong>Alta Vendedor</strong>
	 *
	 * @param estado
	 * @param privilegios
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param fecha_nacimiento
	 * @param puesto
	 * @param direccion
	 * @param codigo_postal
	 * @param telefono
	 * @param email
	 * @param password
	 * @param foto
	 * @param notificaciones
	 * @param gdpr
	 */
	public Vendedor(boolean estado, int privilegios, String nombre, String apellidos, String nif, Date fecha_nacimiento,
			String puesto, String direccion, int codigo_postal, String telefono, String email, String password,
			String foto, boolean notificaciones, boolean gdpr) {
		super();
		this.estado = estado;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha_nacimiento = fecha_nacimiento;
		this.puesto = puesto;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.foto = foto;
		this.notificaciones = notificaciones;
		this.gdpr = gdpr;
	}

	/**
	 * Constructor para <strong>administración</strong>
	 *
	 * @param id_vendedor
	 * @param estado
	 * @param privilegios
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param fecha_nacimiento
	 * @param puesto
	 * @param direccion
	 * @param codigo_postal
	 * @param telefono
	 * @param email
	 * @param password
	 * @param foto
	 * @param notificaciones
	 * @param gdpr
	 */
	public Vendedor(int id_vendedor, boolean estado, int privilegios, String nombre, String apellidos, String nif,
			Date fecha_nacimiento, String puesto, String direccion, int codigo_postal, String telefono, String email,
			String password, String foto, boolean notificaciones, boolean gdpr) {
		super();
		this.id_vendedor = id_vendedor;
		this.estado = estado;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha_nacimiento = fecha_nacimiento;
		this.puesto = puesto;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.foto = foto;
		this.notificaciones = notificaciones;
		this.gdpr = gdpr;
	}

	/**
	 * @return the id_vendedor
	 */
	public int getId_vendedor() {
		return id_vendedor;
	}

	/**
	 * @param id_vendedor the id_vendedor to set
	 */
	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @return the fecha_nacimiento
	 */
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	/**
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the codigo_postal
	 */
	public int getCodigo_postal() {
		return codigo_postal;
	}

	/**
	 * @param codigo_postal the codigo_postal to set
	 */
	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the notificaciones
	 */
	public boolean isNotificaciones() {
		return notificaciones;
	}

	/**
	 * @param notificaciones the notificaciones to set
	 */
	public void setNotificaciones(boolean notificaciones) {
		this.notificaciones = notificaciones;
	}

	/**
	 * @return the gdpr
	 */
	public boolean isGdpr() {
		return gdpr;
	}

	/**
	 * @param gdpr the gdpr to set
	 */
	public void setGdpr(boolean gdpr) {
		this.gdpr = gdpr;
	}

	/**
	 * Método para insertar al <strong>vendedor</strong> en la Base de datos
	 *
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoVendedor v = new DaoVendedor();
		v.Insertar(this);

	}

	@Override
	public String toString() {
		return "Vendedor [id_vendedor=" + id_vendedor + ", estado=" + estado + ", privilegios=" + privilegios
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", fecha_nacimiento="
				+ fecha_nacimiento + ", puesto=" + puesto + ", direccion=" + direccion + ", codigo_postal="
				+ codigo_postal + ", telefono=" + telefono + ", email=" + email + ", password=" + password + ", foto="
				+ foto + ", notificaciones=" + notificaciones + ", gdpr=" + gdpr + "]";
	}

}
