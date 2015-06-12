/**
 * 
 */
package interfaces;

import java.util.List;
import tablas_Clases.Jobs;

/**
 * @author Alberto Vivas
 *
 * 
 */
public interface InterfaceJobsDAO extends InterfaceDAO{
	List<Jobs> obtenerJobs();
}
