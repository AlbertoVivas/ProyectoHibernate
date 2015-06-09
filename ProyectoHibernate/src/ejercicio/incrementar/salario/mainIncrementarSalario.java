/**
 * 
 */
package ejercicio.incrementar.salario;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class mainIncrementarSalario {

	
	
	public static void main(String[] args) {
		//IncrementarSalarios is = null;
		IncrementarSalarios is =new IncrementarSalarios();
		try{
		is.mostrarDepVentas();
		is.incrementarSalario20();
		is.mostrarDepVentas();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			is.closeSession();
		}
	}
}
