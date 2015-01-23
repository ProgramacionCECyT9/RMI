import java.rmi.Naming;

public class rmiClient{
	public static void main(String args[]) throws Exception {
		rmiServerInterface serv = (rmiServerInterface)Naming.lookup("//localhost/rmiServer");
		
		//ejecutamos Metodo2 el número de veces que regrese Metodo1
		for(int j=1; j<=serv.Metodo1(4,3); j++){
		//for(int i=1; i<=serv.Metodo1(); i++){
			serv.Metodo2();
		}
		
		//serv.OtroMetodo(); no se puede usar porque no está en la interfaz
	}
}
