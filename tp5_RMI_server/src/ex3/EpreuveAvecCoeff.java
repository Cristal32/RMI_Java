package ex3;

import java.io.Serializable;

public class EpreuveAvecCoeff implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2536468467467264118L;
	private String nom;
    private double note;
    private double coeff;

    public EpreuveAvecCoeff(String nom, double note, double coeff) {
        this.nom = nom;
        this.note = note;
        this.coeff = coeff;
    }
    
    //getters
    public String getNom() {
    	return nom;
    }
    
    public double getNote() {
    	return note;
    }
    
    public double getCoeff() {
    	return coeff;
    }
    
  //setters
    public void setNom(String nom) {
    	this.nom = nom;
    }
    
    public void setNote(double note) {
    	this.note = note;
    }
    
    public void setCoeff(double coeff) {
    	this.coeff = coeff;
    }
}
