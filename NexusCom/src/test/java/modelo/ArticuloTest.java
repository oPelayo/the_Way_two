package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArticuloTest {
	
	private Articulo articulo;
	

	@Before
	public void setUp() {
		articulo = new Articulo();
	}

	@Test
	public void testSetAndGetNombre() {
		String nombre = "pantalon azul";
		articulo.setNombre(nombre);
		assertEquals(nombre, articulo.getNombre());
	}

	@Test
	public void testSetAndGetEstado() {
		boolean estado = true;
		articulo.setEstado(estado);
		assertTrue(articulo.getEstado());
	}

	@Test
	public void testSetAndGetReferencia() {
		String referencia = "REF-001";
		articulo.setReferencia(referencia);
		assertEquals(referencia, articulo.getReferencia());
	}

	@Test
	public void testSetAndGetStock() {
		int stock = 10;
		articulo.setStock(stock);
		assertEquals(stock, articulo.getStock());
	}


	@Test
	public void testToString() {
		String nombre = "Artículo de prueba";
		String referencia = "REF-001";
		articulo.setNombre(nombre);
		articulo.setReferencia(referencia);
		String expected = "Articulo [id_articulo=0, estado=false, nombre=" + nombre + ", referencia=" + referencia + ", descripcion=" + null + ", familia_productos=" + null + ", marca=" + null + ", perfil=" + null + ", color=" + null + ", talla=" + null + ", stock=0, precio_v=0.0, precio_c=0.0, foto=" + null + ", id_proveedor=0, getId_articulo()=0, getEstado()=false, getNombre()=Artículo de prueba, getReferencia()=REF-001, getDescripcion()=null, getFamilia_productos()=null, getMarca()=null, getPerfil()=null, getColor()=null, getTalla()=null, getStock()=0, getPrecio_v()=0.0, getPrecio_c()=0.0, getFoto()=null, getId_proveedor()=0]";
		assertEquals(expected, articulo.toString());
	}

}

