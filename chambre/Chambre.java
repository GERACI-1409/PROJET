package chambre;

import pays.*;
import personne.*;
import reservation.Reservation;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Chambre{
    /** *numero de la chambre */
    protected int numero;

    /** *prix de la chambre*/
    protected double prix;
    protected double prix_taxes;

    /** *type de la chambre (simple, double,...) */
    protected String type;

    /** *nombre maximum de client pouvant être dans la chambre */
    public static int nb_client;

    /** *liste des reservations pour la chambre */
    public ArrayList<Reservation> liste_resa;


    ///////////////////////////////////////////
    /////////////// Constructeurs /////////////
    //////////////////////////////////////////
    
    public Chambre(int num, double p, int i){
	this(num,p,i,"autre");
	
    }

    public Chambre(int num, double p,int i, String type){
	numero = num;
	nb_client = i;
	prix = p;
	calculPrixTaxes();
	this.type = type;
	liste_resa = new ArrayList<Reservation>();
    }

    ///////////////////////////////////////////
    /////////////// Geters ////// /////////////
    //////////////////////////////////////////
    /** Retourne le numero de la chambre */
    public int getNumero(){
	return numero;
    }


    public ArrayList<Reservation> getListeResa(){
	return liste_resa;
    }

    public void calculPrixTaxes(){
	prix_taxes = prix *14 /100;
    }


    public void imprimeTicket(LocalDateTime date1){
	String l1 = "******************** HOTEL BLUE BAY CARACAO ********************";
	String l2 = "Date de reservation " + date1.toString();
	Reservation r = trouveReservation(date1);

	if(r == null) System.out.println("pas de resa");
	Client c = r.getClients()[0];
	String l3 = c.toString();
	String l4 = "Chambre No. :" + numero + "         " + "Type de chambre :" + type;

	System.out.println( l1+"\n\n\n"  + l2+"\n\n\n"+l3+"\n\n\n"+l4+"\n\n\n");
	    
	c.afficheOption();
	c.afficheRestaurant();
	System.out.println("*****************************************************************");
    }

    public String toString(){

	return ""+numero;
    }

  

    public boolean reservable(Reservation r){
	boolean reservable = true;
	Iterator iter = liste_resa.iterator();
	LocalDateTime debut_r = r.getDebut();
	LocalDateTime fin_r = r.getFin();
	while(iter.hasNext() && reservable ){
	    Reservation a = (Reservation)iter.next();
	    LocalDateTime debut_a = a.getDebut();
	    LocalDateTime fin_a = a.getFin();
	    if( (debut_r.isAfter(debut_a) && debut_r.isBefore(fin_a))|| (fin_r.isAfter(debut_a) && debut_r.isBefore(fin_a))){
		    reservable = false;
	    }

	    
	}
	return reservable;
	
    }

    
    public boolean ajouterReservation(Reservation r){
	boolean reservable = reservable(r);
	
	if(reservable){
	    liste_resa.add(r);
	}
	
	return reservable;
	    
    }


    public Reservation trouveReservation(LocalDateTime debut_resa){
	int ar = debut_resa.getYear();
	int mr = debut_resa.getMonthValue();
	int jr = debut_resa.getDayOfMonth();
	for(Reservation r: liste_resa){
	    LocalDateTime comp = r.getDebut();
	    int ac = comp.getYear();
	    int mc = comp.getMonthValue();
	    int jc = comp.getDayOfMonth();
	    if(ar == ac && mr == mc && jr == jc ){
		return r;
	    }
	}
	return null;
    }
    

}
