package ex3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Etudiant extends Remote {
	void ajouterEpreuve(String nom, double note, double coefficient) throws RemoteException;
    String afficherListeDesEpreuves() throws RemoteException;
    double calculerLaMoyenne() throws RemoteException;
}
