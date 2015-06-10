/**
 * 
 */
package ejercicio.incrementar.salario;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import tablas_Clases.Employees;

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
		Session session = incs.getSession();
		List<Employees> le1 =session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 145").addEntity(Employees.class).list();
		//incs.incrementarSalario20();
		List<Employees> le2 = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 145").addEntity(Employees.class).list();
		//assertTrue(e2.getSalary().divide(e1.getSalary()).equals(new BigDecimal(1.2)));
		//assertThat(new BigDecimal(1.2), e2.getSalary().divide(e1.getSalary()));
		Iterator<Employees> ite1 = le1.iterator();
		Employees e1 = ite1.next();
		incs.incrementarSalario20();
		Iterator<Employees> ite2 = le1.iterator();
		Employees e2 = ite2.next();
		System.out.println(e1.getSalary());
		System.out.println(e2.getSalary());
		assertTrue(e2.getSalary().divide(e1.getSalary()).equals(new BigDecimal(1.2)));
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
