/**
 * 
 */
package interfaces;

/**
 * @author Alberto Vivas
 *
 * 
 */
public interface InterfaceDAO {

	
	//TODO CRUD
	Object create(Object objeto);
	
	Object Read(Class clase,Object id);
	
	Object update(Object objeto);
	
	Object delete(Object objeto);

	
	
	
	
}
