package ejercicio1;

public interface Client {
	public static final byte MSJ_INICIO=0x01;
	public static final byte MSJ_OPERACIONES=0x02;
	public static final byte MSJ_FINAL=0x04;
	
	public int inicioSesion(String user, String password, String id);
	public int operaciones (int suma, int resta);
	public int cerrarSesion ();
	

	

	
}
