package ex3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class EtudiantImpl extends UnicastRemoteObject implements Etudiant{
	private String nom;
    private String prenom;
    private String numeroEtudiant;
    private List<EpreuveAvecCoeff> epreuves = new ArrayList<>();

    public EtudiantImpl(String nom, String prenom, String numeroEtudiant) throws RemoteException {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtudiant = numeroEtudiant;
    }

    @Override
    public void ajouterEpreuve(String nom, double note, double coefficient) throws RemoteException {
        EpreuveAvecCoeff epreuve = new EpreuveAvecCoeff(nom, note, coefficient);
        epreuves.add(epreuve);
    }

    @Override
    public String afficherListeDesEpreuves() throws RemoteException {
        StringBuilder result = new StringBuilder();
        for (EpreuveAvecCoeff epreuve : epreuves) {
            result.append(epreuve.getNom()).append(": ").append(epreuve.getNote()).append(", Coefficient: ")
                    .append(epreuve.getCoeff()).append("\n");
        }
        return result.toString();
    }

    @Override
    public double calculerLaMoyenne() throws RemoteException {
        double sommeNotesPonderees = 0;
        double sommeCoefficients = 0;

        for (EpreuveAvecCoeff epreuve : epreuves) {
            sommeNotesPonderees += epreuve.getNote() * epreuve.getCoeff();
            sommeCoefficients += epreuve.getCoeff();
        }

        if (sommeCoefficients != 0) {
            return sommeNotesPonderees / sommeCoefficients;
        } else {
            return 0;
        }
    }
}
