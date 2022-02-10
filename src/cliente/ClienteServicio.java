//CLASE CLIENTE SERVICIO
package cliente;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author JAVI
 *
 */
public class ClienteServicio {
	//CONSTANTES
	public static final String CODAUTOR = "FTORARA2002";
	public static final String URL = "http://idocentic.website/servicios_para_explotar/pizzeria_psp/";
	private static final Scanner teclado = new Scanner(System.in);

	//MÉTODO NUEVO ESTABLECIMIENTO: SE LE PASA POR PARÁMETRO EL NOMBRE DEL ESTABLECIMIENTO
	//SE CREA LA CONEXIÓN MEDIANTE URL, QUE LLEVA LOS PARÁMETROS NECESARIOS PARA INSERTAR EL NUEVO ESTABLECIMIENTOÇ
	//SE ABRE LA CONEXIÓN CON URLCONECTION
	//CON BUFFERED READER E INPUTSTREAM SE LEE EL CONTENIDO DE LA WEB
	//COMO EL SERVICIO DEVUELVE EL ID DE LA TIENDA NUEVA, SE RECOGE EN UNA VARIABLE Y SE USA MÁS ADELANTE
	public Integer nuevoEstablecimiento(String nomEstablecimiento){
		String linea;
		int idPizzeria = 0;

		try {
			URL url = new URL(URL+"inicializaPizzeria.php?COD_AUTOR="+CODAUTOR+"&NOMBRE_TIENDA="+nomEstablecimiento);
			URLConnection urlC = url.openConnection();
			InputStream is = urlC.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while((linea = br.readLine()) != null){
				idPizzeria = Integer.parseInt(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return idPizzeria;
	}

	//MÉTODO NUEVO PEDIDO: SE LE PASA POR PARÁMETRO EL IDTIENDA RECOGIDO ANTERIORMENTE
	//SE CREA LA CONEXIÓN MEDIANTE URL, QUE LLEVA LOS PARÁMETROS NECESARIOS PARA INSERTAR EL NUEVO PEDIDO
	//SE ABRE LA CONEXIÓN CON URLCONECTION
	//CON BUFFERED READER E INPUTSTREAM SE LEE EL CONTENIDO DE LA WEB
	//COMO EL SERVICIO DEVUELVE EL ID DEL PEDIDO NUEVO, SE RECOGE EN UNA VARIABLE Y SE USA MÁS ADELANTE
	public Integer nuevoPedido(int idTienda){
		String linea;
		int idPedido = 0;

		try {
			URL url = new URL(URL+"insertaPedido.php?COD_AUTOR="+CODAUTOR+"&ID_TIENDA="+idTienda);
			URLConnection urlC = url.openConnection();
			InputStream is = urlC.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while((linea = br.readLine()) != null){
				idPedido = Integer.parseInt(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return idPedido;
	}

	//MÉTODO NUEVO PRODUCTO: SE LE PASA POR PARÁMETRO EL IDTIENDA Y EL IDPEDIDO RECOGIDOS ANTERIORMENTE JUNTO AL IDPRODUCTO
	//SE CREA LA CONEXIÓN MEDIANTE URL, QUE LLEVA LOS PARÁMETROS NECESARIOS PARA INSERTAR EL NUEVO PRODUCTO
	//SE ABRE LA CONEXIÓN CON URLCONECTION
	//CON BUFFERED READER E INPUTSTREAM SE LEE EL CONTENIDO DE LA WEB
	//CON UNA VARIABLE BOOLEANA SE CONTROLA QUE EL PEDIDO SE HAY INSERTADO O NO
	//COMO EL SERVICIO DEVUELVE OK SI SE INSERTA, SE RECOGE EL VALOR Y SE MODIFICA EL BOOLEAN
	public boolean annadirProducto(int idTienda, int idPedido, String codProducto){
		String linea;
		boolean annadido = false;

		try {
			URL url = new URL(URL+"insertaProductoPedido.php?COD_AUTOR="+CODAUTOR+"&ID_TIENDA="+idTienda+"&ID_PEDIDO="+idPedido+"&COD_PRODUCTO="+codProducto);
			URLConnection urlC = url.openConnection();
			InputStream is = urlC.getInputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while((linea = br.readLine()) != null){
				if(linea.equals("OK")){
					annadido = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return annadido;
	}
}


