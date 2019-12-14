package pays;

/**
* The NumberDisplay class represents a digital number display that can hold
* values from zero to a given limit. The limit can be specified when creating
* the display. The values range from zero (inclusive) to limit-1. If used,
* for example, for the seconds on a digital clock, the limit would be 60, 
* resulting in display values from 0 to 59. When incremented, the display 
* automatically rolls over to zero when reaching the limit.
* @author Geraci Lucas and Tores Julie
* @version 2019.11.25
*/

public class Pays{
    /* *Le nom du pays */
    private String nom;
    /* *La langue du pays*/
    private String langue;
    /* *Le code du pays */
    private int code;



    //******************************
    //Constructors
    //******************************
    
    /**
     *Creer un nouveau pays a partir d'un nom, d'une langue et d'un code.
     */
    public Pays(String nom, String langue, int code){
	this.nom = nom;
	this.langue = langue;
	this.code = code;
    }
    
    /**
     *Creer un nouveau pays a partir d'un nom et d'un code.
     */
    public Pays(String nom, int code){
	this(nom, "anglais", code);
    }

    
    /**
     *Creer un nouveau pays a partir d'un nom et d'une langue.
     */
    public Pays(String nom, String langue){
	this(nom, langue, -1);
    }

    /**
     *Creer un nouveau pays a partir d'un nom. 
     */
    public Pays(String nom){
	this(nom, -1);
    }

    // *********************************
    // Seters
    // *********************************

    /**
     * Modifie le nom du pays.
     */
    public void setNom(String nom){
	this.nom = nom;
    }

    /**
     *  Modifie la langue du pays.
     */
    public void setLangue(String langue){
	this.langue = langue;
    }

    /**
     * Modifie le code du pays.
     */
    public void setCode(int code){
	this.code = code;
    }


    //************************
    //Geters
    //************************


    /**
     * Retourne le nom du pays.
     */
    public String getNom(){
	return nom;
    }


    /**
     * Retourne la langue parlee par le pays
     */
    public String getLangue(){
	return langue;
    }

    /**
     * Retourne le code du pays
     */
    public int getCode(){
	return code;
    }


    // ***************
    // Affichage
    // ***************


    public String toString(){
	String s = "Pays: " + nom + "\nLangue: " + langue + "\nCode: ";
	if(code != -1){
	    s += "" + code;
	}
	else{
	    s += "aucun";
	}
	return s;
    }
    
    public void affiche(){
	System.out.println(this);
    }

    public void afficheNomPays(){
	System.out.println(nom);
    }

}
