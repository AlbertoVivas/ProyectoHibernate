/**
 * 
 */
package clases.DAO;

import java.util.Iterator;
import java.util.List;

import interfaces.InterfaceJobsDAO;
import sup.clases.SuperClaseDAO;
import tablas_Clases.Jobs;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class JobsDAO extends SuperClaseDAO{

	/* (non-Javadoc)
	 * @see interfaces.InterfaceJobsDAO#obtenerJobs()
	 */
	@SuppressWarnings("unchecked")
	public List<Jobs> obtenerJobs() {
		return getSession().createSQLQuery("SELECT * FROM JOBS").addEntity(Jobs.class).list();
	}

}
