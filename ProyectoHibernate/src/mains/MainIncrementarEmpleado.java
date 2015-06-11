/**
 * 
 */
package mains;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import servicios.EmployeesServices;
import session.SessionManager;
import tablas_Clases.Departments;
import tablas_Clases.Employees;
import tablas_Clases.Jobs;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class MainIncrementarEmpleado {

	
	public static void main(String[] args) {
		EmployeesServices es = new EmployeesServices();
		BigDecimal d = new BigDecimal(20);
		//es.incrementarSalario(d);
		try{
		es.mostrarEmpleados();
		//es.incrementarSalario(d);
		/*Jobs jobs = new Jobs("ZGZ_mal", "Malavarista");
		Date hireDate = new Date(2015, 6, 11);
		String email = "malavarista@gmail.com";
		int employeeId = 2000;
		String lastName = "geta";
		Set jobHistories = null;
		short s = 100;
		Departments departments = new Departments(s, "entretenimiento");
		String firstName = "Juanton";
		BigDecimal salary = new BigDecimal(2000);
		String phoneNumber = "666111000";
		Set departmentses = null;
		Set employeeses = null;
		BigDecimal commissionPct= new BigDecimal(5);
		Employees employees = null;
		Employees em = new Employees(employeeId, jobs, departments, employees, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, employeeses, departmentses, jobHistories);
		es.insertarempleado(em);
		es.mostrarEmpleados();*/
		
		System.out.println("\n mostrar empleado\n"+es.mostrarempleado(105));
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally{
			SessionManager.closeAll();
		}
	}
}
