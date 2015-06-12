/**
 * 
 */
package interfaces;

import java.util.List;

import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public interface InterfaceEmployeesDAO extends InterfaceDAO {
	List<Employees> obtenerEmpleados();
}
