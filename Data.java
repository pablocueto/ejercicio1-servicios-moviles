package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/**
 * Esta clase contiene los datos que se envian en el protocolo
 * @author pablocueto
 *
 */
public class Data {
	protected int operando1=0;
	protected int operando2=0;
	protected int id=0;
	
	/**
	 * define los operandos
	 * @param op1 primer valor de la operacion
	 * @param op2 segundo valor de la operacion
	 */
	public Data (int op1, int op2){
		this.operando1=op1;
		this.operando2=op2;
	}	
	/**
	 * Se convierten los operandos en string
	 * @param dato1 operando1 en string
	 * @param dato2 operando2 en string 
	 */
	public Data (String dato1, String dato2){
		this.operando1=Integer.parseInt(dato1);
		this.operando2=Integer.parseInt(dato2);
	}
	/**
	 * Lee los datos y pone excepcion
	 * @param dis nombre para DataInputStream
	 */
	public Data (DataInputStream dis){
		try{
			this.operando1=dis.readInt();
			this.operando2=dis.readInt();
		} catch (IOException e) {
			this.operando1=0;
			this.operando2=0;
			e.printStackTrace();
		}
	}
	/**
	 * Escribe los datos y pone excepcion
	 * @param dos nombre para DataOutoutStream
	 */
	public void toByteArray (DataOutputStream dos){
		try{
			dos.writeInt(this.operando1);
			dos.writeInt(this.operando2);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	//devuelve los operandos
	public String toString(){
		return operando1+" "+operando2;
	}
	
}
	