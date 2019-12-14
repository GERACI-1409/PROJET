package personne;

/**
 * @author Geraci Lucas and Tores Julie
 * @version 2019.11.25
 */
import java.time.LocalDateTime;
import java.time.Duration;

public class Personne{
    /* *nom de la personne */
    protected String nom;
    /* *prenom de la personne */
    protected String prenom;

    /* *age de la personne */
    protected int age;

    /* *date de naissance en type date*/
    protected LocalDateTime naissance;

    // *******************************
    // Constructeurs
    // *******************************

    public Personne(String nom, String prenom, LocalDateTime d){
	this.nom = nom;
	this.prenom = prenom;
	this.naissance = d;
	calculeAge(LocalDateTime.now());
	
    }
    


    // ********************************
    // Seters
    // ********************************

    /**
     * Modifie le nom de la personne
     */
    public void setNom(String nom){
	this.nom = nom;
    }

    /**
     * Modifie le prenom de la personne
     */
    public void setPrenom(String prenom){
	this.prenom = prenom;
    }

    /**
     * Modifie la date de naissance de la personne
     */
    public void setDate(LocalDateTime date){
	naissance = date;
    }

    // ********************************************
    // Geters
    // ********************************************
    /**
     * Retourne le nom de la personne
     */
    public String getNom(){
	return nom;
    }

    /**
     * Retourne le prenom de la personne
     */
    public String getPrenom(){
	return prenom;
    }

    /**
     * Retourne la date de naissance de la personne
     */
    public LocalDateTime getDateNaissance(){
	return naissance;
    }

    /**
     * Retourne l'age de la personne
     */
    public int getAge(){
	
	return age;
    }


    // *********************
    // autres
    // *********************

    /**
     * Retourne les attributs de la personne
     */

    public String toString(){
	String s = "Nom et Prenom: "+nom+", "+prenom;
	return s;
    }

    /** 
     * Methode qui calcule l'age de la personne
     */


    public void calculeAge(LocalDateTime ajd){
	Duration duration = Duration.between(naissance, ajd).abs();
	long duree = duration.toDays();
	long annees = duree/ (long)365.25;
	int age = (int) annees;

	
    }

}
