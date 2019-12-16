package personne;
import pays.*;
import java.time.LocalDateTime;
/**
 * @author Geraci Lucas and Tores Julie  
 * @version 2019.11.25
 */

public class Client extends Personne{
    /* *Pays du client */
    private Pays pays;

    /* *email du client */
    private String email;

    /* *Numero de telephone du client*/
    private String numero;

    /* *nombre de ticket de 5euros*/
    private int nb_ticket_restau;

    /* *tableau du nombre de massage effectues*/
    private int[] tableau_massage;

    
    ////////////////
    // Constructeurs
    ////////////////

    
    public Client(String nom, String prenom, int a, int m, int j, Pays p, String email, String numero){
	super(nom,prenom,LocalDateTime.of(a,m,j,0,0,0));
	pays = p;
	setEmail(email);
	setNumero(numero, p);
	tableau_massage = new int[3];

	tableau_massage[0] = 0;
	tableau_massage[1] = 0;
	tableau_massage[2] = 0;	
    }

    public Client(String nom, String prenom, LocalDateTime naissance){
	super(nom,prenom,naissance);
    }
    


    //************************************
    // Geters
    //************************************

    public int[] getTableauMassage(){
	return tableau_massage;
    }

    

    /**
     *Retourne le pays d'ou vient le client
     */
    public Pays getPays(){
	return pays;
    }

    /**
     * Retourne l'email du client
     */
    public String getEmail(){
	return email;
    }

    /**
     * Retourne le numero de telephone du client
     */
    public String getNumero(){
	return numero;
    }

    public int getNbTicketRestau(){
	return nb_ticket_restau;
    }

    
    //*************************************
    //Seters
    //*************************************

    /**
     * Modifie le nombre de ticket pour le restaurant
     */

    public void setTableauMassage(int i, int res){
	tableau_massage[i] = res;
    }

    public void setNbTicketRestau(int n){
	nb_ticket_restau = n;
    }

    
    /**
     * Modifie le pays du client
     */
    public void setPays(Pays p){
	pays = p;
    }

    /**
     * Modifie l'email du client
     */
    public boolean setEmail(String email){
	if(email.indexOf("@") > 0){
		String[] tmp = email.split("@");
		if(tmp[1].contains(".")){
		    this.email = email;
		    System.err.println("Adresse valide.");
		    return true;
		}
		else{
		    System.err.println("Adresse invalide: rentrez une nouvelle adresse.");
		    return false;
		}
	    }
	    else{
		System.err.println("Adresse invalide: rentrez une nouvelle adresse.");
		return false;
	    }
    }


    /**
     * Modifie le numero du client
     */
	public boolean setNumero(String num, Pays p){
	    int code = p.getCode();
	    if(num.length() <=10 ){
		if(code == -1){
		    numero = num;
		}
		else{
		    numero = "+"+code+num.substring(1);
		}
		return true;
	    }
	    return false;
	}

    public String toString(){
	String l1 = "Nom et prenom du client : " + nom + " "+prenom;
	String l2 = "email : " + email;
	String l3 = "Telephone : "+ numero;
	return l1 + "\n" + l2 + "\n" + l3;
    }

    public String pe(){
	return ""+nom+" "+prenom;

    }

    public void ajouterUnMassage(int num_massage){
	tableau_massage[num_massage-1] = tableau_massage[num_massage-1]+1;
    }

    public void afficheOption(){
	afficheNombreMassage();
	///////// A MODIFIER AVEC LE RESTAURANT /////////////
    }

    public void afficheNombreMassage(){
	System.out.println("Spa Yuma Massage\n\n");
	int un =  tableau_massage[0];
	int deux = tableau_massage[1];
	int trois = tableau_massage[2];
	int somme_un = un * 50;
	int somme_deux = deux * 70;
	int somme_trois = trois * 80;
	int total = somme_un + somme_deux + somme_trois;
	System.out.println("Nombre Massage relaxant : " + un + " x 50€ = " + somme_un );
	System.out.println("Nombre Massage aux pierres chaudes : " + deux +" x 70€ = " + somme_deux);
	System.out.println("Nombre Massage à l'élixir de bougie : "+ trois + " x 80€ = " + somme_trois);
	System.out.println("Total des massages à payer : " + total + " €");
    }
    
}
