package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 * Clase para definir los mensajes del protocolo
 * @author pablocueto
 *
 */
public class Mensaje1 implements Client {
	protected int suma;
	protected int resta;
	protected int resultado=0;
	private String mensaje="";
	private Data data=null;
	
	// Metodos de la interfaz que usamos en esta clase
	@Override
	public int inicioSesion(String user, String password, String id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int operaciones(int suma, int resta) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int cerrarSesion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	/**
	 * Creamos array de 5 parametros y se implemeta el 
	 * DataOutputStream que es el que se encarga de escribir los datos
	 * y ponemos la excepcion
	 * @return
	 */
	public byte[] toByteArray()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(5);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeInt(suma);
			dos.writeInt(resta);
			data.toByteArray(dos);
			dos.close();
			return bos.toByteArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param datos String de los datos del mensaje (leerlos)
	 * @param bytedata divide el mensaje en partes dentro del array
	 */
	public Mensaje1 (String datos, byte [] bytedata){
		ByteArrayInputStream bais=new ByteArrayInputStream (bytedata);
		
		DataInputStream dis=new DataInputStream (bais);
		try{
			this.resultado=dis.readInt();
			
		} catch (IOException ex){
			
		}
		
		String [] campos=datos.split(" ");
		if (campos.length==3){
			resultado=Integer.parseInt(campos[0]);
			data=new Data (campos[1],campos[2]);
			
		}
	}

	/**
	 * Peticion para que devuelva el mensaje
	 * @return Nos devuelve la respuesta de la peticion
	 */
	public String getMensaje(){
		return mensaje;
	}
	
}

