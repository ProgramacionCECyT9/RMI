import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;

public class rmiServer extends UnicastRemoteObject implements rmiServerInterface{

	public rmiServer() throws RemoteException {
		super(0); // Nos sirve para saltarnos el paso del 'rmic'. Es una llamada al constructor de la clase base(UnicastRemoteObject)
		//El resto del código del constructor
	}
	
	/*public int Metodo1(){
		return 3;
		//el código que quieras va aquí
	}*/
	
	public int Metodo1(int a, int b){
		return a+b;
	}
	
	public void Metodo2(){
		System.out.println("Estoy en el Metodo 2");
		//el código que quieras va aquí
	}
	
	public void OtroMetodo(){
		System.out.println("Este método solo funciona en esta clase");
		//este otro método no puede llamarse remotamente ya que no está en la interfaz
		//el código que quieras va aquí
	}
	
	public static void main(String args[]) throws Exception{
		//Iniciamos el server RMI
		
		try{
			LocateRegistry.createRegistry(1099);
			//Registry creado
		}
		catch(RemoteException e){
			//no hacer nada, error significa que el registry ya existía
		}
		
		//instanciamos la clase
		rmiServer obj = new rmiServer();
		
		obj.OtroMetodo();
		
		Naming.rebind("//localhost/rmiServer",obj);
	}
}
