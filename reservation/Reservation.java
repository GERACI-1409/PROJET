package reservation;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Duration;
import personne.*;


public class Reservation{

    private LocalDateTime debut;
    private LocalDateTime fin;
    private int duree;
    private Client[] clients;

    public Reservation(LocalDateTime debut, LocalDateTime fin,int nb_client){
	this.debut = debut;
	this.fin = fin;
	clients = new Client[nb_client];
	calculeDuree();

    }

    //////////////GETTERS////////////

    public LocalDateTime getDebut(){
	return debut;
    }

    public LocalDateTime getFin(){
	return fin;
    }

    public Client[] getClients(){
	return clients;
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
