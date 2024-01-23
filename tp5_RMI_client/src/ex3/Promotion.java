package ex3;

import java.rmi.*;

public interface Promotion extends Remote{
	void ajouterUnEtudiant(String nom, String prenom, String numeroEtudiant) throws RemoteException;
    Etudiant rechercherUnEtudiant(String numeroEtudiant) throws RemoteException;
    double calculerMoyenneDeLaPromotion() throws RemoteException;
}
