/**
 * 
 */
package sup.clases;

import interfaces.InterfaceDAO;

import org.hibernate.Session;


/**
 * @author Alberto Vivas
 *
 * 
 */
public class SuperClaseDAO{
	
	private  Session session;

	public  Session getSession() {
		return session;
	}

	public  void setSession(Session session) {
		this.session = session;
	}
}
