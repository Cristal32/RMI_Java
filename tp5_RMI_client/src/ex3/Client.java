package ex3;

import java.rmi.*;

public class Client {
	 public static void main(String[] args) {
		 System.setProperty("java.security.policy","file./security.policy");
	        try {
	            Promotion promotion = (Promotion) Naming.lookup("rmi://127.0.0.1:2034/Promotion");

	            promotion.ajouterUnEtudiant("John", "Doe", "123");
	            Etudiant etudiant = promotion.rechercherUnEtudiant("123");
	            etudiant.ajouterEpreuve("Math", 80, 0.5);
	            etudiant.ajouterEpreuve("Physique", 90, 0.5);

	            System.out.println("Liste des épreuves pour l'étudiant 123:");
	            System.out.println(etudiant.afficherListeDesEpreuves());

	            double moyenneEtudiant = etudiant.calculerLaMoyenne();
	            System.out.println("Moyenne de l'étudiant 123: " + moyenneEtudiant);

	            double moyennePromotion = promotion.calculerMoyenneDeLaPromotion();
	            System.out.println("Moyenne générale de la promotion: " + moyennePromotion);
	        } catch (Exception e) {
	            System.out.println("Client exception: " + e);
	        }
	    }
}
