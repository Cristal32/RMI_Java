package ex3;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Serveur{
	
    public static void main(String[] args) {
    	System.setProperty("java.security.policy","file./security.policy");
        try {
            java.rmi.registry.LocateRegistry.createRegistry(2034);
            Promotion Promotion = new PromotionImpl();
            Naming.rebind("rmi://localhost:2034/Promotion", Promotion);
            System.out.println("PromotionService server bound in registry at the URL");
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("PromotionService failed.\n" + e);
        }
    }

}
