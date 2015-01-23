import java.rmi.Remote;
import java.rmi.RemoteException;

public interface rmiServerInterface extends Remote{
	//public int Metodo1() throws RemoteException;
	public int Metodo1(int a, int b) throws RemoteException;
	public void Metodo2() throws RemoteException;
}
