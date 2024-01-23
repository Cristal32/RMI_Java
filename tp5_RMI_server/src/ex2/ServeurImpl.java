package ex2;
import java.rmi.*;
import java.rmi.server.*;

public class ServeurImpl extends UnicastRemoteObject implements IFibon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7559537248183955219L;

	public ServeurImpl() throws RemoteException {
		super();
	}

	public int fibonnaci(int n) throws RemoteException {
        if (n == 0) {
            return 0;
        } else {
        	if (n == 1) {
                return 1;
            }
        	return fibonnaci(n - 1) + fibonnaci(n - 2);
        }
    }

	public static void main(String[] args) {
		//System.setSecurityManager(new SecurityManager());
		System.setProperty("java.security.policy","file./security.policy");

		try {
			java.rmi.registry.LocateRegistry.createRegistry(2032); //si j'utilise le port defaut : 1099, pas besoin de l'ecrire dans rebind()
			ServeurImpl ServeurImpl = new ServeurImpl();
			Naming.rebind("rmi://localhost:2032/ServeurImpl", ServeurImpl);
		    System.out.println("ServerImpl bound in registry at the url "); 
			System.out.println("Server is ready.");
		} catch (Exception e) {
			System.out.println("Server failed.\n" + e);
		}
	}
}