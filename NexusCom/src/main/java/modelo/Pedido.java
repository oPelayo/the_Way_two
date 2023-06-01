package modelo;

import java.sql.Date;
import java.sql.SQLException;

import dao.DaoPedido;

public class Pedido {

	private int id_pedido;
	private Date fecha;
	private int id_carrito;
	private int id_vendedor;

	/**
	 * Constructor vacio
	 */
	public Pedido() {
		super();
	}

	/**
	 * Constructor para el back-end
	 *
	 * @param fecha
	 * @param id_carrito
	 * @param id_vendedor
	 */
	public Pedido(Date fecha, int id_carrito, int id_vendedor) {
		super();
		this.fecha = fecha;
		this.id_carrito = id_carrito;
		this.id_vendedor = id_vendedor;
	}

	/**
	 * Constructor con todos los atributos
	 *
	 * @param id_pedido
	 * @param fecha
	 * @param id_carrito
	 * @param id_vendedor
	 */
	public Pedido(int id_pedido, Date fecha, int id_carrito, int id_vendedor) {
		super();
		this.id_pedido = id_pedido;
		this.fecha = fecha;
		this.id_carrito = id_carrito;
		this.id_vendedor = id_vendedor;
	}

	/**
	 * @return the id_pedido
	 */
	public int getId_pedido() {
		return id_pedido;
	}

	/**
	 * @param id_pedido the id_pedido to set
	 */
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * Método para insertar la sesion en la Base de datos
	 *
	 * @throws SQLException
	 */
	public void insertar() throws SQLException {
		DaoPedido p = new DaoPedido();
		p.Insertar(this);
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", fecha=" + fecha + ", id_carrito=" + id_carrito + ", id_vendedor="
				+ id_vendedor + ", getId_pedido()=" + getId_pedido() + ", getFecha()=" + getFecha()
				+ ", getId_carrito()=" + getId_carrito() + ", getId_vendedor()=" + getId_vendedor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
