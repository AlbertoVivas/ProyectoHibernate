/**
 * 
 */
package servicios;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import session.SessionManager;
import sup.clase.DAO.SuperClaseDAO;
import tablas_Clases.Employees;

import clases.DAO.EmployeesDAO;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmployeesServices {
	
	private static EmployeesDAO eDAO;
	
	public EmployeesServices() {
		eDAO = new EmployeesDAO();
	}
	
	@SuppressWarnings("finally")
	public boolean incrementarSalario(BigDecimal d){
		boolean b_dev= false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		if(d.signum()==-1){
			System.out.println("\n Decrementando el salario en: "+d+ "%\n" );
		}
		if (d.signum()==1){
			System.out.println("\n Incrementando el salario en: "+d+"%\n");
		}
		if (d.signum()==0){
			System.out.println("\n No incrementamos el salario, inc = "+d+"%\n");
		}	
		session = SessionManager.obtenerSession();
		SuperClaseDAO.setSession(session);
		transaction = session.beginTransaction();
		List<Employees> le = eDAO.obtenerEmpleados();
		Iterator<Employees> it = le.iterator();
		Employees employees =null;
		BigDecimal n_salary = new BigDecimal(0);
		BigDecimal inc = new BigDecimal(1).add(d.divide(new BigDecimal(100)));
		while(it.hasNext()){
			employees=it.next();
			n_salary= employees.getSalary().multiply(inc);
			employees.setSalary(n_salary);
		}
		transaction.commit();
		b_dev = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}

	@SuppressWarnings("finally")
	public boolean mostrarEmpleados(){
		boolean b_dev= false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		SuperClaseDAO.setSession(session);
		transaction = session.beginTransaction();
		List<Employees> le = eDAO.obtenerEmpleados();
		Iterator<Employees> it = le.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		transaction.commit();
		b_dev = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean insertarempleado(Employees em){
		boolean b_dev = false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		SuperClaseDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = eDAO.create(em);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}
	@SuppressWarnings("finally")
	public Employees mostrarempleado(int emp_id){
		Employees b_dev = null;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		SuperClaseDAO.setSession(session);
		transaction = session.beginTransaction();
		b_dev = (Employees) eDAO.Read(emp_id);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession();
			return b_dev;
		}
	}
	
	
	
	
	
}
