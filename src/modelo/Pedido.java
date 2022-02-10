//CLASE PEDIDO
package modelo;

import java.util.List;

/**
 * @author JESUS
 *
 */
public class Pedido {
	//ATRIBUTOS
	private final List<Producto> productosPedido;
	private int idTienda;

	//CONSTRUCTOR
	public Pedido(List<Producto> productosPedido,int idTienda) {
		this.productosPedido = productosPedido;
	}

	//GETTERS Y SETTERS
	public List<Producto> getProductosPedido() {
		return productosPedido;
	}

	public int getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public void annadirProducto(Producto p){
		productosPedido.add(p);
	}
}