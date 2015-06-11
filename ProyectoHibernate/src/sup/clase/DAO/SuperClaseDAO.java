/**
 * 
 */
package sup.clase.DAO;

import org.hibernate.Session;


/**
 * @author Alberto Vivas
 *
 * 
 */
public class SuperClaseDAO {

	
	private static Session session;

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		SuperClaseDAO.session = session;
	}
}
