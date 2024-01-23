package ex1;
import java.rmi.*;

public interface IHello extends Remote {
	public String say() throws RemoteException;
}

//extends remote : pour travailler avec RMI