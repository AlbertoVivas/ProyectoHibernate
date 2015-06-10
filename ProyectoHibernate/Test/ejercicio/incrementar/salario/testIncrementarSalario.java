/**
 * 
 */
package ejercicio.incrementar.salario;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class testIncrementarSalario {

	/**
	 * Test method for {@link ejercicio.incrementar.salario.IncrementarSalarios#IncrementarSalarios()}.
	 */
	@Test
	public void testIncrementarSalarios() {
		assertNotNull(new IncrementarSalarios());
	}


	/**
	 * Test method for {@link ejercicio.incrementar.salario.IncrementarSalarios#incrementarSalario20()}.
	 */
	@Test
	public void testIncrementarSalario20() {
		IncrementarSalarios incs = new IncrementarSalarios();
		assertTrue(incs.incrementarSalario20());
	}

	/**
	 * Test method for {@link ejercicio.incrementar.salario.IncrementarSalarios#mostrarDepVentas()}.
	 */
	@Test
	public void testMostrarDepVentas() {
		IncrementarSalarios incs = new IncrementarSalarios();
		assertTrue(incs.mostrarDepVentas());
	}

}
