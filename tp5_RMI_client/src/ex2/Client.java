package ex2;
import java.rmi.*;

public class Client {
	public static void main(String[] args) {
		//System.setSecurityManager(new SecurityManager());
		 System.setProperty("java.security.policy","file./security.policy");

		try {
			IFibon iFibon = (IFibon) Naming.lookup("rmi://127.0.0.1:2032/ServeurImpl");

            int n = 5; 
            long result = iFibon.fibonnaci(n);

            System.out.println("Fibonacci(" + n + ") = " + result);
		} catch (Exception e) {
			System.out.println("Client exception: " + e);
		}
	}
}