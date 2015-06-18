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
		
		Employees e1 = (Employees) es.Read(Employees.class,105);
		es.incrementarSalario(new BigDecimal(20));
		Employees e2 = (Employees) es.Read(Employees.class,105);
		int ie1 = e1.getSalary().intValue();
		int ie2 = e2.getSalary().intValue();
		assertEquals(ie1*12/10,ie2);
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
	 * Test method for {@link servicios.EmployeesServices#obtenerEmpleados()}.
	 */
	@Test
	public void testObtenerEmpleados() {
		EmployeesServices es = new EmployeesServices();
		List<Employees> le = es.obtenerEmpleados();
		Employees e=(Employees) es.Read(Employees.class,105);
		assertTrue(le.contains(e));
	}

}
