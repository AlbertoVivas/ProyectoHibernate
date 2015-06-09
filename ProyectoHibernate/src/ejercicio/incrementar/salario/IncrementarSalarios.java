/**
 * 
 */
package ejercicio.incrementar.salario;



import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class IncrementarSalarios {
	
	private static Session session;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Transaction transaction;
	
	public IncrementarSalarios(){
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		//session = factory.openSession();
		setSession(factory.openSession());
		//disconectSession();
	}
	
	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		IncrementarSalarios.session = session;
	}



	private static void obtenerSession(){
		session = factory.getCurrentSession(); // este suele usarse mas para no crear multiples sesiones y cerrarlas sino usar una unica
	}
	
	private static void disconectSession(){
		session.disconnect();
	}
	
	public void closeSession(){
		try{
		session.close();
		factory.close();
		//HibernatilUtil.closeSession();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void incrementarSalario20(){
		try {
			System.out.println("\n Incrementando el salario\n");
			//obtenerSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME like 'Sales') ").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			Employees employees =null;
			BigDecimal n_salary = new BigDecimal(0);
			BigDecimal inc = new BigDecimal(1.2);
			while(it.hasNext()){
			//	transaction = session.beginTransaction();
				employees=it.next();
				n_salary= employees.getSalary().multiply(inc);
				employees.setSalary(n_salary);
			//	session.merge(employees);
				//session.update(employees);
				//session.save(employees);
				session.saveOrUpdate(employees);
				//transaction.commit();
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally{
			System.out.println("Termino de incrementar");
			//disconectSession();
		}
	}
	
	public void mostrarDepVentas(){
		System.out.println("dep ventas");
		try {
			//obtenerSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME like 'Sales') ").addEntity(Employees.class).list();// entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			//disconectSession();
		}

	}
	
	
	
	
	
}
