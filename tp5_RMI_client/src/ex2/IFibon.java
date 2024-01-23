package ex2;
import java.rmi.*;

public interface IFibon extends Remote {
	public int fibonnaci(int rang) throws RemoteException;
}

//extends remote : pour travailler avec RMI