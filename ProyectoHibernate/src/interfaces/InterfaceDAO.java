/**
 * 
 */
package interfaces;

/**
 * Interfaz comun para todos los objetos DAO, con todos los crud comunes.
 * 
 * @author Alberto Vivas
 */
public interface InterfaceDAO {

	
	//TODO CRUD
	Object create(Object objeto);
	
	Object Read(Class clase,Object id);
	
	Object update(Object objeto);
	
	Object delete(Object objeto);

	
	
	
	
}
