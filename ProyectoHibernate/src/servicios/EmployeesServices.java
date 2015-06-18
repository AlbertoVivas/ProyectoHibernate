/**
 * 
 */
package servicios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.Session;
import session.SessionManager;
import tablas_Clases.Employees;

import clases.DAO.EmployeesDAO;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmployeesServices extends ServicesCRUD {
	private final static Logger log = Logger.getLogger("mylog");
	private static EmployeesDAO eDAO;
	public EmployeesServices() {
		eDAO = new EmployeesDAO();
	}
	/**
	 * metodo para incrementar el salario de todos los empleados
	 * @param d tipo Big decimal (+,-,0)
	 * @return T/F 
	 */
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
		eDAO.setSession(session);
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
			log.error("Error al Incrementar el salario de los empleados");
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession(session);
			return b_dev;
		}
	}
	/**
	 * Imprime en consola todos los empleados
	 * @return T/F , e imprime en consola los empleados.
	 */
	@SuppressWarnings("finally")
	public boolean mostrarEmpleados(){
		boolean b_dev= false;
		Session session = null;
		Transaction transaction = null;
		
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		List<Employees> le = eDAO.obtenerEmpleados();
		Iterator<Employees> it = le.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		transaction.commit();
		b_dev = true;
		} catch (Exception e) {
			log.error("Error al mostrar los empleados por consola");
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession(session);
			return b_dev;
		}
	}

	
	/**
	 * Metodo para obtener la lista de los empleados	
	 * @return List<Employees>
	 */
	@SuppressWarnings("finally")
	public List<Employees> obtenerEmpleados(){
		Session session = null;
		Transaction transaction = null;
		List<Employees> le =null;
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		le = eDAO.obtenerEmpleados();
		transaction.commit();
		} catch (Exception e) {
			log.error("Error al recuperar los empleados e introducirlos en una lista");
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession(eDAO.getSession());
			return le;
		}
	}
	
	/**
	 * Metodo que de un arraylist devuelve el empleado con mayor salario
	 * @param ale
	 * @return Employees
	 */
	public Employees obtenerEmpleadoMayor(ArrayList<Employees> ale){
		Employees e_dev= null;
		Employees e_f = null;
		Iterator<Employees> i = ale.iterator();
		e_dev=i.next();
		
		while(i.hasNext()){
			e_f = i.next();
			if(e_f.getSalary().intValue() > e_dev.getSalary().intValue()){
				e_dev=e_f;
			}
		}
		return e_dev;
	}
	
	
	/**
	 * Metodo que devuelve una lista de los empleados con el sueldo mas alto de cada departamento
	 * @return List<Employees> 
	 */
	@SuppressWarnings("finally")
	public ArrayList<Employees> obtenerEmpleadosMejorPagados(){
		Session session = null;
		Transaction transaction = null;
		ArrayList<Employees> le =new ArrayList<Employees>(11);
		try{
		System.out.println("obtenerEmpleadosMejorPagados");	
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		for (int i = 1; i <= 11; i++) {
			le.add(obtenerEmpleadoMayor(eDAO.obtenerEmpleadosPorDepartamento(i*10)));	
		}
		transaction.commit();
		} catch (Exception e) {
			log.error("Error al obtener los empleados mejor pagados");
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession(eDAO.getSession());
			return le;
		}
		
	}
	
	/**
	 * v2.0 de obtener empleados mejor pagados por departamentos
	 * @param le
	 * @return Employees
	 */
	public Employees obtenerEmpleadoMayor(List<Employees> le){
		Employees e_dev= null;
		Employees e_f = null;
		Iterator<Employees> i = le.iterator();
		e_dev=i.next();
		
		while(i.hasNext()){
			e_f = i.next();
			if(e_f.getSalary().intValue() > e_dev.getSalary().intValue()){
				e_dev=e_f;
			}
		}
		return e_dev;
	}
	
	
	/**
	 * Metodo que devuelve una lista de los empleados por el identificador
	 * @param departament_id
	 * @return List<Employees>
	 */
	@SuppressWarnings("finally")
	public List<Employees> obtenerEmpleadosPorDepartamento(int departament_id){
		Session session = null;
		Transaction transaction = null;
		List<Employees> le =null;
		try{
		session = SessionManager.obtenerSession();
		eDAO.setSession(session);
		transaction = session.beginTransaction();
		le = eDAO.obtenerEmpleadosPorDepartamento(departament_id);
		transaction.commit();
		} catch (Exception e) {
			log.error("Error al recuperar una lista de empleados por departamento:"+departament_id);
			e.printStackTrace();
			transaction.rollback();
		}finally{
			SessionManager.disconectSession(eDAO.getSession());
			return le;
		}	
	}
}
