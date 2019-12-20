package personne;
import pays.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Client est une personne qui va pouvoir être client de l'hotel 
 *
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

    /* *nombre de ticket sortis*/
    private int nb_ticket_sorti;
    
    /* *tableau du nombre de massage effectues*/
    private int[] tableau_massage;

    /* *Supplement du restaurant */
    private double supplement;

   

    
    ////////////////////////////
    // Constructeurs
    ///////////////////////////

    
    public Client(String nom, String prenom, int a, int m, int j, Pays p, String email, String numero){
	super(nom,prenom,LocalDateTime.of(a,m,j,0,0,0));
	pays = p;
	setEmail(email);
	setNumero(numero, p);
	tableau_massage = new int[3];

	tableau_massage[0] = 0;
	tableau_massage[1] = 0;
	tableau_massage[2] = 0;

	nb_ticket_restau = 0;
    }

    public Client(String nom, String prenom, LocalDateTime naissance){
	super(nom,prenom,naissance);

	tableau_massage = new int[3];

	tableau_massage[0] = 0;
	tableau_massage[1] = 0;
	tableau_massage[2] = 0;

	nb_ticket_restau = 0;
    }
    


    //************************************
    // Geters
    //************************************

    /**
     * Retourne le tableau qui contient le nombre de massage du client
     */
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

    /**
     * Retourne le nombre de ticket restaurant restant du client
     */
    public int getNbTicketRestau(){
	return nb_ticket_restau;
    }

    /**
     * Retourne les supplements que le client doit payer a cause du restaurant.
     */
    public double getSupplement(){
	return supplement;
    }

    /**
     * Retourne le nombre de ticket que le cient a recu au debut.
     */
    public int getNbTicketTotal(){
	return nb_ticket_sorti;
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
     * Modifie le nombre de ticket sortis du client
     */
    public void setSortis(int n){
	nb_ticket_sorti = n;
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

    /**
     * Modifie les supplements a payer du client.
     */
    public void setSupplement(int s){
	supplement = s;
    }

    ////////////////////////////////////////////////
    ////////////////// Autres //////////////////////
    ///////////////////////////////////////////////

    /**
     * Retourne une chaine de caractere qui permet d'identifier le client
     */
    public String toString(){
	String l1 = "Nom et prenom du client : " + nom + " "+prenom;
	String l2 = "email : " + email;
	String l3 = "Telephone : "+ numero;
	return l1 + "\n" + l2 + "\n" + l3;
    }

    /**
     * Retourne une chaine de caractere qui contient le nom et le prenom du client.
     */
    public String pe(){
	return ""+nom+" "+prenom;

    }

    /**
     * Modifie le nombre de ticket du client et les supplements que le client doit payer. 
     */
    public void modificationRepas(double prix){
	nb_ticket_restau = nb_ticket_restau - 1;
	double ecart = prix - 5;
	supplement +=ecart;	
    }

    /**
     * Ajoute un message dans la case correspondante au massage que le client à fait.
     */
    public void ajouterUnMassage(int num_massage){
	if(tableau_massage == null) System.out.println(".........");
	tableau_massage[num_massage-1] = tableau_massage[num_massage-1]+1;
    }

    
    public void afficheOption(){
	afficheNombreMassage();
	///////// A MODIFIER AVEC LE RESTAURANT /////////////
    }

    /**
     * Affiche le nombre de massage que le client à fait, leur prix, et le total que le client doit payer.
     */
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

    /**
     * Affiche le nombre de ticket que le client a recu de base, le prix de ce qu'il doit payer en supplement
     * et le nombre de tickets qui lui reste.
     */
    public void afficheRestaurant(){
	String l1 = "Restaurant Mojito-Mojito";
	String l2_a = "Nombre de tickets sortis: " + nb_ticket_sorti;
	String l2_b = "Nombre de tickets utilisés: " + (nb_ticket_sorti-nb_ticket_restau);
	String l3 = "Total des suppléments à payer: " + supplement;
	System.out.println( "\n" + l1 + "\n" + l2_a + "    "+ l2_b + "\n" + l3);

    }

    /**
     * Fonction qui permet la sauvegarde d'un client dans un fichier texte.
     */
    public String sauv(){
	String data = "";
	
	data +="u#" + nom + "\n";
	data +="p#"+ prenom +"\n";
	data +="pa#"+ pays.getNom() +"\n";
	data +="e#"+ email +"\n";
	data +="num#"+ numero +"\n";
	data +="tot#"+ nb_ticket_sorti +"\n";
	data +="sor#"+ nb_ticket_restau +"\n";
	data +="m#"+ tableau_massage[0]+ tableau_massage[1] + tableau_massage[2] +"\n";
	data +="sup#"+ supplement+"\n";
	data += " #" + naissance.format(DateTimeFormatter.BASIC_ISO_DATE)+"\n";
	return data;
    }
    
}
