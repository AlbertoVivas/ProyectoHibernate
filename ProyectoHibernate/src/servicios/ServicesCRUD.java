/**
 * 
 */
package servicios;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import session.SessionManager;
import sup.clases.SuperClaseDAO;
import interfaces.InterfaceDAO;

/**
 * @author Alberto Vivas
 * Clase con todos los servicios comunes, contiene Crear, Leer, Borrar y Actualizar. 
 * 
 */
public class ServicesCRUD implements InterfaceDAO {
	private SuperClaseDAO objetoDAO;
	
	public ServicesCRUD(){
		objetoDAO= new SuperClaseDAO();
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#create(java.lang.Object)
	 */
	@Override
	public Object create(Object object) {
			Transaction trans = null;
			try{
			Session sm = SessionManager.obtenerSession();
			objetoDAO.setSession(sm);
			trans = objetoDAO.getSession().beginTransaction();
			objetoDAO.getSession().save(object);
			trans.commit();
			}catch(Exception e){
				e.printStackTrace();
				trans.rollback();
			}finally{
				SessionManager.disconectSession(objetoDAO.getSession());
				SessionManager.closeFactory();
			}
			return object;
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#Read(java.lang.Object)
	 */
	@Override
	public Object Read(Class clase,Object id) {
		Transaction trans = null;
		Object object = null;
		try{
		Session sm = SessionManager.obtenerSession();
		objetoDAO.setSession(sm);
		trans = objetoDAO.getSession().beginTransaction();
		object = objetoDAO.getSession().get(clase,(Serializable) id);
		trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			SessionManager.disconectSession(objetoDAO.getSession());
			SessionManager.closeFactory();
		}
		return object;
	}


	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#update(java.lang.Object)
	 */
	@Override
	public Object update(Object object) {
		Transaction trans = null;
		try{
		Session sm = SessionManager.obtenerSession();
		objetoDAO.setSession(sm);
		trans = objetoDAO.getSession().beginTransaction();
		objetoDAO.getSession().save(object);
		trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			SessionManager.disconectSession(objetoDAO.getSession());
			SessionManager.closeFactory();
		}
		return object;
	}

	/* (non-Javadoc)
	 * @see interfaces.InterfaceDAO#delete(java.lang.Object)
	 */
	@Override
	public Object delete(Object object) {
		Transaction trans = null;
		try{
		Session sm = SessionManager.obtenerSession();
		objetoDAO.setSession(sm);
		trans = objetoDAO.getSession().beginTransaction();
		objetoDAO.getSession().delete(object);
		trans.commit();
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			SessionManager.disconectSession(objetoDAO.getSession());
			SessionManager.closeFactory();
		}
		return object;
	}

}
