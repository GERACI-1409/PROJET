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


    /** *Modifie la liste des clients de la chambre*/
    public void setCliets(Client[] c){
	clients = c;
    }




    ////////////////////////////////


    
    /**
     * Methode qui permet d'ajouter un client d'ajouter
     * un client si le tableau n'est pas deja complet
     * Retourne true si on a reussi, false sinon
     */
    public boolean ajouterClient(Client c){
	int n = clients.length;
	int i = 0;
	// tant qu'on ne depasse pas la taille du taleau
	// et que la case courante n'est pas nulle
	// on ajoute un à l'indice
	while(i < n && clients[i]!=null){
	    i++;
	}
	// si on n'a pas atteint la fin du tableau on
	// peut ajouter le client
	if(i<n){
	    clients[i] = c;
	    attribueTicket();
	    return true;
	}
	return false;
    }

    /**
     * Retourne une chaine de caractere contenant la date de début,
     * la date de fin, et la liste des clients.
     */
    public String toString(){
	String s = "";
	for(int i = 0; i < clients.length; i++){
	    if (clients[i] != null){
		s += clients[i].toString() + "\n";
	    }	
	}
	return "du " +debut.toString()  + " au " + fin.toString() +s;
    }

    /**
     * Permet de calculer la duree de la reservation.
     */
    public void calculeDuree(){
        Duration duration = Duration.between(debut,fin);
	duree =(int) Math.abs(duration.toDays());
	
    }

    /**
     * Methode qui calcule le nombre de ticket que le client va recevoir
     * en fonction de la duree de son sejour.
     */
    public void attribueTicket(){
	int n = duree * 2; // n est le nombre de ticket que le client va recevoir
	//Parcours du tableau de client
	for(int i = 0; i <clients.length ;i++){
	    // si la case n'est pas nulle 
	    if(clients[i] != null){
		// on met à jour le nombre de ticket.
		clients[i].setNbTicketRestau(n);
		clients[i].setSortis(n);
	    }
	}
    }

    /**
     * Methode qui permet de trouver un client dans 
     * le tableau de clients à partir de son mail.
     */
    public Client trouveClient(String mail){
	int n = clients.length;
	int i = 0;
	boolean trouve = false;
	Client c = null;
	// tant qu'on a pas atteint la fin du tableau
	// et qu'on a pas trouve le client 
	while(i < n && !trouve){
	    c = clients[i];
	    // on verifie si le client courrant à le bon mail
	    if(c.getEmail().equals(mail)) trouve = true;
	    i++;
	}
	// si on a trouve le client on le renvoie
	if(trouve) return c;
	// sinon on retourne null
	else return null;
    }


}
