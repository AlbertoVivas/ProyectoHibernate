/**
 * 
 */
package clases.DAO;

import java.util.Iterator;
import java.util.List;
import sup.clases.SuperClaseDAO;
import tablas_Clases.Employees;
import interfaces.InterfaceDAO;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmployeesDAO extends SuperClaseDAO{
	
	

	/**
	 * de la session obtenida por la 
	 * @return List<Employees>
	 */
	@SuppressWarnings("unchecked")
	public List<Employees> obtenerEmpleados(){	
		return getSession().createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();	
		}
	
	@SuppressWarnings("unchecked")
	public List<Employees> obtenerEmpleadosPorDepartamento(Object arg){
		int s = (Integer)arg;
		return getSession().createSQLQuery("SELECT * FROM EMPLOYEES where DEPARTMENT_ID="+s).addEntity(Employees.class).list();
	}

	
}
