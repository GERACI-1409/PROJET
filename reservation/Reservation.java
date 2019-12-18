package reservation;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Duration;
import personne.*;


public class Reservation{
    /* *Date de debut de reservation */
    private LocalDateTime debut;

    /* *Date de fin de reservation */
    private LocalDateTime fin;

    /* *duree de la resservation*/
    private int duree;

    /* *liste des clients qui participent à la reservation*/
    private Client[] clients;


    //////////////////////////////////////
    /////////// Constructeurs ///////////
    /////////////////////////////////////
    public Reservation(LocalDateTime debut, LocalDateTime fin,int nb_client){
	this.debut = debut;
	this.fin = fin;
	clients = new Client[nb_client];
	calculeDuree();

    }
    /////////////////////////////////
    //////////////GETTERS////////////
    /////////////////////////////////
    
    /**
     * Retourne la date de debut de la reservation
     */
    public LocalDateTime getDebut(){
	return debut;
    }

    /**
     * Retourne la date de fin de reservation
     */
    public LocalDateTime getFin(){
	return fin;
    }
    
    /**
     * Retourne la liste des clients de la resservation
     */
    public Client[] getClients(){
	return clients;
    }

    /**
     * Retourne la duree de la reservation
     */
    public int getDuree(){
	return duree;
    }

    /////////////////////////////////
    //////// Setters ///////////////
    ///////////////////////////////

    /** *Modifie la date de debut de la reservation*/
    public void setDebut(LocalDateTime d){
	debut = d;
    }

    /** *Modifie la date de fin de la reservation*/
    public void setFin(LocalDateTime f){
	fin = f;
    }

    /** *Modifie la duree de la reservation*/
    public void setDuree(int d){
	duree = d;
    }






    ////////////////////////////////


    

    public boolean ajouterClient(Client c){
	int n = clients.length;
	int i = 0;
	while(i < n && clients[i]!=null){
	    i++;
	}
	if(i<n){
	    clients[i] = c;
	    attribueTicket();
	    return true;
	}
	return false;
    }

    public String toString(){
	String s = "";
	for(int i = 0; i < clients.length; i++){
	    if (clients[i] != null){
		s += clients[i].toString() + "\n";
	    }
		
	}
	    
	return "du " +debut.toString()  + " au " + fin.toString() +s ;
    }

    public void calculeDuree(){
        Duration duration = Duration.between(debut,fin);
	duree =(int) Math.abs(duration.toDays());
	
    }

    public void attribueTicket(){
	int n = duree * 2;
	for(int i = 0; i <clients.length ;i++){
	    if(clients[i] != null){
		clients[i].setNbTicketRestau(n);
		clients[i].setSortis(n);
		    }
	}
    }

    public Client trouveClient(String mail){
	int n = clients.length;
	int i = 0;
	boolean trouve = false;
	Client c = null;
	while(i < n && !trouve){
	    c = clients[i];
	    if(c.getEmail().equals(mail)) trouve = true;
	    i++;
	}
	if(trouve) return c;
	else return null;
    }


}
