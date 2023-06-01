package modelo;

import java.sql.Date;
import java.sql.SQLException;

import dao.DaoUsuario;

/*
 * Esta classe define objetos Usuario
 * @author Orlando
 */
public class Usuario {

	private int id_usuario;
	private boolean estado;
	private int privilegios;
	private String nombre;
	private String apellidos;
	private String nif;
	private Date fecha_nacimiento;
	private String direccion;
	private int codigo_postal;
	private String telefono;
	private String email;
	private String password;
	private String foto;
	private boolean notificaciones;
	private boolean gdpr;

	/*
	 * Constructor <strong>vacio</strong>
	 * @author Orlando
	 */
	public Usuario() {
		super();
	}

	/**
	 * Constructor para Clientes de tienda fisica: <strong>sin datos no necesarios
	 * como nif,foto,direccion o contraseña</strong>
	 * @author Orlando
	 * @param estado
	 * @param privilegios
	 * @param nombre
	 * @param apellidos
	 * @param codigo_postal
	 * @param telefono
	 * @param notificaciones
	 * @param gdpr
	 */
	public Usuario(boolean estado, int privilegios, String nombre, String apellidos, int codigo_postal, String telefono,
			boolean notificaciones, boolean gdpr) {
		super();
		this.estado = estado;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
		this.notificaciones = notificaciones;
		this.gdpr = gdpr;
	}

	/**
	 * Constructor para alta de cliente <strong>sin foto</strong>
	 * @author Orlando
	 * @param estado
	 * @param privilegios
	 * @param nombre
	 * @param apellidos
	 * @param direccion
	 * @param codigo_postal
	 * @param telefono
	 * @param email
	 * @param notificaciones
	 * @param gdpr
	 */
	public Usuario(boolean estado, int privilegios, String nombre, String apellidos, String direccion,
			int codigo_postal, String telefono, String email, boolean notificaciones, boolean gdpr) {
		super();
		this.estado = estado;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.telefono = telefono;
		this.email = email;
		this.notificaciones = notificaciones;
		this.gdpr = gdpr;
	}

	/**
	 * Constructor para el alta de Usuario <strong>con foto</strong>
	 * @author Orlando
	 * @param estado
	 * @param privilegios
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param fecha_nacimiento
	 * @param direccion
	 * @param codigo_postal
	 * @param telefono
	 * @param email
	 * @param password
	 * @param foto
	 * @param notificaciones
	 * @param gdpr
	 */
	public Usuario(boolean estado, int privilegios, String nombre, String apellidos, String nif, Date fecha_nacimiento,
			String direccion, int codigo_postal, String telefono, String email, String password, String foto,
			boolean notificaciones, boolean gdpr) {
		super();
		this.estado = estado;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha_nacimiento = fecha_nacimiento;
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
	 * Constructor para el alta de un <strong>nuevo usuario</strong>
	 * @author Orlando
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param fecha_nacimiento
	 * @param direccion
	 * @param codigo_postal
	 * @param telefono
	 * @param email
	 * @param password
	 * @param foto
	 * @param notificaciones
	 * @param gdpr
	 */
	public Usuario(String nombre, String apellidos, String nif, Date fecha_nacimiento, String direccion,
			int codigo_postal, String telefono, String email, String password, String foto, boolean notificaciones,
			boolean gdpr) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha_nacimiento = fecha_nacimiento;
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
	 * Constructor completo para <strong>administración</strong>
	 * @author Orlando
	 * @param id_usuario
	 * @param estado
	 * @param privilegios
	 * @param nombre
	 * @param apellidos
	 * @param nif
	 * @param fecha_nacimiento
	 * @param direccion
	 * @param codigo_postal
	 * @param telefono
	 * @param email
	 * @param password
	 * @param foto
	 * @param notificaciones
	 * @param gdpr
	 */
	public Usuario(int id_usuario, boolean estado, int privilegios, String nombre, String apellidos, String nif,
			Date fecha_nacimiento, String direccion, int codigo_postal, String telefono, String email, String password,
			String foto, boolean notificaciones, boolean gdpr) {
		super();
		this.id_usuario = id_usuario;
		this.estado = estado;
		this.privilegios = privilegios;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha_nacimiento = fecha_nacimiento;
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
	 * @author Orlando
	 * @return the id_usuario
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * @author Orlando
	 * @param id_usuario the id_usuario to set
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * @author Orlando
	 * @return the estado
	 */
	public boolean isEstado() {
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
	 * @return the privilegios
	 */
	public int getPrivilegios() {
		return privilegios;
	}

	/**
	 * @author Orlando
	 * @param privilegios the privilegios to set
	 */
	public void setPrivilegios(int privilegios) {
		this.privilegios = privilegios;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @author Orlando
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @author Orlando
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @author Orlando
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @author Orlando
	 * @return the fecha_nacimiento
	 */
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	/**
	 * @author Orlando
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/**
	 * @author Orlando
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @author Orlando
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @author Orlando
	 * @return the codigo_postal
	 */
	public int getCodigo_postal() {
		return codigo_postal;
	}

	/**
	 * @author Orlando
	 * @param codigo_postal the codigo_postal to set
	 */
	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	/**
	 * @author Orlando
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @author Orlando
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @author Orlando
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @author Orlando
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @author Orlando
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @author Orlando
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the notificaciones
	 */
	public boolean isNotificaciones() {
		return notificaciones;
	}

	/**
	 * @author Orlando
	 * @param notificaciones the notificaciones to set
	 */
	public void setNotificaciones(boolean notificaciones) {
		this.notificaciones = notificaciones;
	}

	/**
	 * @author Orlando
	 * @return the gdpr
	 */
	public boolean isGdpr() {
		return gdpr;
	}

	/**
	 * @author Orlando
	 * @param gdpr the gdpr to set
	 */
	public void setGdpr(boolean gdpr) {
		this.gdpr = gdpr;
	}

	/**
	 * Método para insertar al <strong>Usuario</strong> en la Base de datos
	 * @author Orlando
	 * @see (#Insertar(); DaoUsuario#Insertar(); dao.DaoUsuario; {@link dao.DaoUsuario#Insertar(Usuario)}
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoUsuario u = new DaoUsuario();
		u.Insertar(this);

	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", estado=" + estado + ", privilegios=" + privilegios + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", direccion=" + direccion + ", codigo_postal=" + codigo_postal + ", telefono=" + telefono
				+ ", email=" + email + ", password=" + password + ", foto=" + foto + ", notificaciones="
				+ notificaciones + ", gdpr=" + gdpr + ", getId_usuario()=" + getId_usuario() + ", isEstado()="
				+ isEstado() + ", getPrivilegios()=" + getPrivilegios() + ", getNombre()=" + getNombre()
				+ ", getApellidos()=" + getApellidos() + ", getNif()=" + getNif() + ", getFecha_nacimiento()="
				+ getFecha_nacimiento() + ", getDireccion()=" + getDireccion() + ", getCodigo_postal()="
				+ getCodigo_postal() + ", getTelefono()=" + getTelefono() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getFoto()=" + getFoto() + ", isNotificaciones()="
				+ isNotificaciones() + ", isGdpr()=" + isGdpr() + "]";
	}

}
