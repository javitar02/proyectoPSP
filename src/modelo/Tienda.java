//CLASE TIENDA
package modelo;


import cliente.ClienteServicio;

/**
 * @author JESUS
 *
 */
public class Tienda {
	//ATRIBUTOS
	private String nombreEstablecimiento;
	private Integer idTienda;
	public ClienteServicio cs;

	//CONSTRUCTOR VACÍO
	public Tienda(){
	}

	//CONSTRUCTOR CON PARÁMETROS
	public Tienda(ClienteServicio cs, String nombreEstablecimiento) {
		this.cs = new ClienteServicio();
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	//GETTERS Y SETTERS
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public ClienteServicio getCs() {
		return cs;
	}

	public void setCs(ClienteServicio cs) {
		this.cs = cs;
	}

	//MÉTODO REGISTRA TIENDA: RECIBE POR PARÁMETRO UN OBJETO CLIENTE SERVICIO Y EL NOMBRE DEL ESTABLECIMIENTO
	//SE LLAMA AL MÉTODO DE REGISTRAR ESTABLECIMIENTO EN LA CLASE CLIENTE SERVICIO, PASÁNDOLE EL NOMBRE COMO PARÁMETRO
	//COMO ESE MÉTODO DEVUELVE EL IDTIENDA, SE RECOGE Y SE DEVUELVE EN UNA VARIABLE
	public int registraTienda(ClienteServicio cs,String nombreEstablecimiento) {
		int idTienda;

		idTienda=cs.nuevoEstablecimiento(nombreEstablecimiento);

		return idTienda;
	}

	//MÉTODO REGISTRA PEDIDO: SE LE PASA UN OBJETO TIPO PEDIDO
	//SE CREA UN OBJETO CLIENTE SERVICIO
	//SE LLAMA AL MÉTODO DE REGISTRAR PEDIDO AL QUE SE LE PASA EL IDTIENDA
	//CON UN FOR EACH SE RECORREN LOS PRODUCTOS Y SE VAN AÑADIENDO AL PEDIDO
	//LA VARIABLE BOOLEANA SE PONE A TRUE CADA VEZ QUE SE AÑADE CORRECTAMENTE Y SE DEVUELVE
	public boolean registraPedido(Pedido ped) {
		boolean insertadoConExito = false;
		int idPedido;

		ClienteServicio clienteServicio = new ClienteServicio();
		idPedido=clienteServicio.nuevoPedido(ped.getIdTienda());

		for (Producto p:ped.getProductosPedido()) {
			clienteServicio.annadirProducto(ped.getIdTienda(),idPedido,p.getCodProducto());
			insertadoConExito = true;
		}

		return insertadoConExito;
	}
}
