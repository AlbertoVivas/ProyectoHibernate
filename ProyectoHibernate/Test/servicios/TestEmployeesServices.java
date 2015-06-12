/**
 * 
 */
package servicios;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class TestEmployeesServices {

	/**
	 * Test method for {@link servicios.EmployeesServices#EmployeesServices()}.
	 */
	@Test
	public void testEmployeesServices() {
		assertNotNull(new EmployeesServices());
	}

	/**
	 * Test method for {@link servicios.EmployeesServices#incrementarSalario(java.math.BigDecimal)}.
	 */
	@Test
	public void testIncrementarSalario() {
		EmployeesServices es = new EmployeesServices();
		Employees e1 = es.obtenerempleado(105);
		es.incrementarSalario(new BigDecimal(20));
		Employees e2 = es.obtenerempleado(105);
		assertTrue((e2.getSalary().divide(e1.getSalary())).doubleValue()==1.2);
		
		//assertArrayEquals(message, expecteds, actuals, delta)
	}

	/**
	 * Test method for {@link servicios.EmployeesServices#mostrarEmpleados()}.
	 */
	@Test
	public void testMostrarEmpleados() {
		EmployeesServices es = new EmployeesServices();
		assertNotNull(es.mostrarEmpleados());
	}

	
	/**
	 * Test method for {@link servicios.EmployeesServices#insertarempleado(tablas_Clases.Employees)}.
	 */
	/*
	@Test
	public void testInsertarempleado() {
		//fail("Not yet implemented");
	}
	*/

	/**
	 * Test method for {@link servicios.EmployeesServices#obtenerEmpleados()}.
	 */
	@Test
	public void testObtenerEmpleados() {
		EmployeesServices es = new EmployeesServices();
		List<Employees> le = es.obtenerEmpleados();
		Employees e= es.obtenerempleado(105);
		assertTrue(le.contains(e));
	}

}
