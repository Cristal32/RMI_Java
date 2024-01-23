package ex3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class PromotionImpl extends UnicastRemoteObject implements Promotion {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2518780771617120765L;
	private Map<String, Etudiant> etudiants = new HashMap<>();

    public PromotionImpl() throws RemoteException {
    }

    @Override
    public void ajouterUnEtudiant(String nom, String prenom, String numeroEtudiant) throws RemoteException {
        Etudiant etudiant = new EtudiantImpl(nom, prenom, numeroEtudiant);
        etudiants.put(numeroEtudiant, etudiant);
    }

    @Override
    public Etudiant rechercherUnEtudiant(String numeroEtudiant) throws RemoteException {
        return etudiants.get(numeroEtudiant);
    }

    @Override
    public double calculerMoyenneDeLaPromotion() throws RemoteException {
        double sommeMoyennes = 0;
        int nombreEtudiants = 0;

        for (Etudiant etudiant : etudiants.values()) {
            sommeMoyennes += etudiant.calculerLaMoyenne();
            nombreEtudiants++;
        }

        if (nombreEtudiants != 0) {
            return sommeMoyennes / nombreEtudiants;
        } else {
            return 0;
        }
    }
}
