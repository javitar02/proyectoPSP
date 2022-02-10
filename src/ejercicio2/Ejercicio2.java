//EJERCICIO 2
package ejercicio2;

import cliente.ClienteServicio;
import modelo.Pedido;
import modelo.Producto;
import modelo.Tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Fco Javier Torrejon Aragon
 *
 */
public class Ejercicio2 {

	private static final Scanner teclado = new Scanner(System.in);

	//MAIN
	public static void main(String[] args) {
		tratarMenu();
	}

	//MÉTODO TRATAR MENÚ: CONTIENE LA MAYORÍA DEL PROGRAMA, YA QUE SE USARÁ LA RECURSIVIDAD
	//CADA VEZ QUE EL USUARIO PULSE NO EN LA CONFIRMACIÓN DEL REGISTRO DEL PEDIDO
	private static void tratarMenu() {
		//CREACIÓN DE VARIABLES
		ClienteServicio cs = new ClienteServicio();

		Producto pizza;
		ArrayList<Producto>listaProductos = new ArrayList<>();
		Pedido p = new Pedido(listaProductos,0);

		int optCliente;
		int finalizaPedido = -1;
		int registraPedido;
		int idTienda;
		boolean pedidoRealizado;

		optCliente = registrarPedidoONo();

		//SE RECOGE LA OPCIÓN DEL USUARIO. SI MARCA 1, EL PROGRAMA SIGUE ADELANTE. SINO, MUESTRA UN MENSAJE DE DESPEDIDA
		if(optCliente == 1){
			System.out.println("\nIniciando su pedido");

			//SE CONTROLA QUE EL USUARIO META PRODUCTOS EN EL PEDIDO HASTA QUE PULSE 2
			//MIENTRAS SE LLAMA A ELEGIR PIZZA Y SE AÑADE AL ARRAY
			while (finalizaPedido != 1){
				pizza = elegirPizza();
				p.annadirProducto(pizza);

				System.out.println("¿Finalizar el pedido? (1-SI Ó 2-NO): ");
				finalizaPedido = Integer.parseInt(teclado.nextLine());
			}

			//SE MUESTRA EL PEDIDO CON LAS DISTINTAS PIZZAS
			System.out.println("\nPedido pendiente de registrar");
			mostrarProductos(listaProductos);

			System.out.println("\n¿Desea registrar el pedido? (1:SI Ó 2:NO): ");
			registraPedido = Integer.parseInt(teclado.nextLine());

			//SE RECOGE DE NUEVO LA OPCIÓN. SI SE PULSA 1, SE REGISTRA EL PEDIDO. SINO, SE LLAMA DE NUEVO A ESTE MISMO MÉTODO
			if(registraPedido == 1){
				Tienda tiendaNueva = new Tienda();

				//SE REGISTRA LA TIENDA NUEVA, SE ACTUALIZA EL IDTIENDA DEL PEDIDO QUE AL PRINCIPIO ESTABA INICIALIZADA A 0
				//SE REGISTRA EL PEDIDO. SI ESE MÉTODO DEVUELVE TRUE SE MUESTRA MENSAJE DE QUE HA SIDO SATISFACTORIA LA INSERCIÓN
				//SINO, SE MUESTRA MENSAJE DE ERROR
				idTienda = tiendaNueva.registraTienda(cs,"A%20la%20carta");
				p.setIdTienda(idTienda);
				pedidoRealizado=tiendaNueva.registraPedido(p);

				if(pedidoRealizado){
					System.out.println("Pedido realizado correctamente");
				}else{
					System.out.println("El pedido no se ha podido realizar");
				}
			}else{
				tratarMenu();
			}
		}else{
			System.out.println("\nPase un buen dia");
		}
	}

	//MÉTODO REGISTRAR PEDIDO O NO: SE LE PIDE AL USUARIO QUE PULSE 1 SÍ QUIERE REGISTRAR UN PEDIDO Ó 2 SI NO QUIERE
	//SE RECOGE LA OPCIÓN EN UNA VARIABLE ENTERA Y SE DEVUELVE
	private static int registrarPedidoONo(){
		int optCliente;

		System.out.println("\nPizzería “A la carta”");
		System.out.println("¿Desea registrar un pedido?  1-SI ó 2-NO: ");
		optCliente = Integer.parseInt(teclado.nextLine());

		return optCliente;
	}

	//MÉTODO MOSTRAR PRODUCTOS: SE RECORRE EL ARRAYLIST DE PRODUCTOS Y SE MUESTRAN SEGÚN EL PEDIDO QUE SE HAYA REALIZADO
	//SI AL RECORRERLO SE TRATA DEL ÚLTIMO ELEMENTO, LO PINTA SIN COMA, PUESTO QUE YA NO HAY MÁS PRODUCTOS
	//SINO, LO PINTA CON COMA
	private static void mostrarProductos(ArrayList<Producto> listaProductos) {
		System.out.print("Productos-> ");
		for (Producto pr: listaProductos) {
			if (listaProductos.indexOf(pr) == listaProductos.size()-1){
				System.out.print(pr.getNombreProducto());
			}else{
				System.out.print(pr.getNombreProducto()+", ");
			}
		}
	}

	//MÉTODO ELEGIR PIZZA: SE LE PIDE AL USUARIO QUE INTRODUZCA LA PIZZA QUE DESEE PEDIR
	//LA OPCIÓN ES CONTROLADA MEDIANTE UNA VARIABLE ENTERA Y UN SWITCH
	//SE CREARÁ Y DEVOLVERÁ EN UN OBJETO UNA PIZZA DISTINTA SEGÚN LO QUE DESEE EL USUARIO
	private static Producto elegirPizza() {
		int tipoPizza;
		Producto pizza = null;

		System.out.println("¿Qué artículo desea?");
		System.out.println("1.Cuatro Estaciones 2.Barbacoa 3.Carbonara 4.De la Casa 5.Extra de queso 6.Margarita");
		tipoPizza = Integer.parseInt(teclado.nextLine());

		switch (tipoPizza) {
			case 1 -> pizza = new Producto("Cuatro estaciones","4ESTACION");
			case 2 -> pizza = new Producto("Barbacoa","BARBACOA");
			case 3 -> pizza = new Producto("Carbonara","CARBONARA");
			case 4 -> pizza = new Producto("De la Casa","CASA");
			case 5 -> pizza = new Producto("Extra queso","EXTRAQUESO");
			case 6 -> pizza = new Producto("Margarita","MARGARITA");
		}
		return pizza;
	}
}
