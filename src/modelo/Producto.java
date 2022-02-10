//CLASE PRODUCTO
package modelo;

/**
 * @author JESUS
 *
 */
public class Producto {
	//ATRIBUTOS
	private String codProducto;
	private String nombreProducto;

	//CONSTRUCTOR
	public Producto(String nombreProducto, String codProducto) {
		this.codProducto = codProducto;
		this.nombreProducto = nombreProducto;
	}

	//GETTERS Y SETTERS
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCodProducto() {
		return codProducto;
	}
}
