//EJERCICIO 1

package ejercicio1;

import cliente.ClienteServicio;

import java.net.MalformedURLException;

/**
 * @author Fco Javier Torrejon Aragon
 *
 */

public class Ejercicio1 {

	/**
	 * @param args
	 */
	//MAIN
	public static void main(String[] args) {
		//SE CREAN E INSTANCIAN LOS DIFERENTES OBJETOS
		//PRIMERO SE CREAN LAS TIENDAS, LUEGO LOS PEDIDOS Y POR ÚLTIMO LOS PRODUCTOS

		ClienteServicio c = new ClienteServicio();

		int idTienda1 = c.nuevoEstablecimiento("Establecimiento%20uno");
		int idTienda2 = c.nuevoEstablecimiento("Establecimiento%20dos");
		int idTienda3 = c.nuevoEstablecimiento("Establecimiento%20tres");

		int idPed1 = c.nuevoPedido(idTienda1);
		int idPed2 = c.nuevoPedido(idTienda1);
		int idPed3 = c.nuevoPedido(idTienda2);

		c.annadirProducto(idTienda1,idPed1,"CARBONARA");
		c.annadirProducto(idTienda1,idPed1,"CARBONARA");
		c.annadirProducto(idTienda1,idPed1,"CARBONARA");
		c.annadirProducto(idTienda1,idPed1,"BARBACOA");
		c.annadirProducto(idTienda1,idPed1,"BARBACOA");
		c.annadirProducto(idTienda1,idPed1,"CASA");
		c.annadirProducto(idTienda1,idPed2,"MARGARITA");

		c.annadirProducto(idTienda2,idPed3,"EXTRAQUESO");
		c.annadirProducto(idTienda2,idPed3,"4ESTACION");

		int idPed4 = c.nuevoPedido(idTienda3);
	}

}
