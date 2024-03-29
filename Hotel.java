import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import java.time.LocalDateTime;

import personne.Client;
import personne.Personne;
import chambre.*;
import pays.*;
import spa.*;
import reservation.*;


public class Hotel{
    private ArrayList<Pays> mes_pays; 
    private String nom;
    private Simple[] etage_simple;
    private CDouble[] etage_double;
    private Deluxe[] etage_deluxe;
    private Triple[] etage_triple;
    private ArrayList<Client> liste_clients;

    public Hotel(int s, int dou, int de, int tr, String nom){
	this.nom = nom;
	//	intialisationPays();
	etage_simple = new Simple[s];
	for(int i = 0; i<s; i++){
	    etage_simple[i] = new Simple();
	}

	etage_double = new CDouble[dou];
	for(int i = 0; i<dou; i++){
	    etage_double[i] = new CDouble();
	}
	
	etage_deluxe = new Deluxe[de];
	for(int i = 0; i < de; i++){
	    etage_deluxe[i] = new Deluxe();
	}

	
	etage_triple = new Triple[tr];
	for(int i = 0; i < tr; i++){
	    etage_triple[i] = new Triple();
	}
	liste_clients = new ArrayList<Client>();
	mes_pays = new ArrayList<Pays>();

    }

    ///////////////////////////////////////////////////////
    public void initialisationPays(){
	mes_pays.add(new Pays("Afrique de Sud", 93));
	mes_pays.add(new Pays("Brésil", 55));
	mes_pays.add(new Pays("Chine", 86));
	mes_pays.add(new Pays("Espagne", 34));
	mes_pays.add(new Pays("France", 33));
	
	mes_pays.add(new Pays("Italie", 39));
	mes_pays.add(new Pays("Inde", 91));
	mes_pays.add(new Pays("Perou", 51));
	mes_pays.add(new Pays("Royaume-Uni", 44));
	
    }


    //////////////////////////////////////////////////


    


    public Simple[] getEtageSimple(){
	return etage_simple;
    }

    public CDouble[] getEtageDouble(){
	return etage_double;
    }

    public Triple[] getEtageTriple(){
	return etage_triple;
    }

    public Deluxe[] getEtageDeluxe(){
	return etage_deluxe;
    }














    


    public void run(){
	Scanner scan = new Scanner(System.in);
	//int a = scan.nextInt();
	//String s = scan.NetxLine();
	int res = 0;
	do{
	    String menu = "0: quitter\n1: Reserver une chambre\n2: Ajouter client\n3: Imprimer ticket de la chambre\n4: Aller au restaurant(pas encore disponible)\n5: Aller au spa (accessible uniquement si vous etes client de l'hotel)";
	    System.out.println(menu);
	    res = scan.nextInt();
	    if(res == 1){
       
		reserverChambre();
		
	    }
	    if(res == 2){
		NouveauClientv2();
	    }
	    if(res == 3){
		imprimerTicket();
	    }
	    if(res == 4){
		faireRestaurant();
	    }
	    if(res == 5){
		faireSpa();
	    }
	    
	}while(res !=0);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Client NouveauClient(){
	Scanner scan = new Scanner(System.in);	
	System.out.println("Veuillez entrer votre:\nnom:");
	String n = scan.nextLine();
	System.out.println("\nprenom:");
	String p = scan.nextLine();
	System.out.println("\nemail:");
	String email = scan.nextLine();
	System.out.println("\nnumero:");
	String num = scan.nextLine();
	System.out.println("\nannee de naissance:");
	int a = scan.nextInt();
	scan.nextLine() ;
	System.out.println("\nmois de naissance");
	int m = scan.nextInt();
	scan.nextLine() ;
	System.out.println("\njour de naissance");
	int j = scan.nextInt();
	scan.nextLine();
	System.out.println("\nPays:");
	String pa = scan.nextLine();
	Pays pays = new Pays(pa);
	Client c = new Client(n,p,a,m,j,pays,email,num);
	liste_clients.add(c);
	return c;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Client NouveauClientv2(){
	//Demander les infos
	Scanner scan = new Scanner(System.in);	
	System.out.println("Veuillez entrer votre:\nnom:");
	String n = scan.nextLine();
	System.out.println("Prenom:");
	String p = scan.nextLine();

	LocalDateTime date_naiss = null;
	while(date_naiss == null){
	    System.out.println("Entrez votre date de naissance sous le format aaaa/mm/jj");
	    String d = scan.nextLine();
	    date_naiss = obtenirDate(d);
	}
	Client c = new Client(n, p, date_naiss);
	
	
	//Faire choisir le client dans la liste de pays
	System.out.println("Votre pays est-il dans la liste ?\n Si oui entrez le numéro correspondant\nSi non entrez -1");
	initialisationPays();
	for(int i = 0; i < mes_pays.size();i++){
	    System.out.println(""+i+": "+mes_pays.get(i).getNom());
	}
	int numero_pays = scan.nextInt();
	scan.nextLine();
	Pays pays;
	if(numero_pays == -1){
	    System.out.println("Entrez le nom de votre pays");
	    String nom_pays = scan.nextLine();
	    pays = new Pays(nom_pays);

	}
	else{
	    pays = mes_pays.get(numero_pays); 
	}
	
	
	//Demander l'email tant qu'il est pas bon
	boolean valide_1 = false;
	while(!valide_1){
	    System.out.println("Entrez une adresse mail valide");
	    String email = scan.nextLine();
	    valide_1 = c.setEmail(email); 
	}


	
	//Demander le numero tant qu'il est pas bon
	boolean valide_2 = false;
	while(!valide_2){
	    System.out.println("Entrez votre numéro de téléphone");
	    String num = scan.nextLine();
	    valide_2 = c.setNumero(num, pays);
	}
	liste_clients.add(c);
	return c;

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public int faireSpa(){
	Scanner s = new Scanner(System.in);
	System.out.println("\n Quel est votre numero de chambre ?");
	int numero_chambre = s.nextInt();
	s.nextLine();
	System.out.println("Quelle est la date de votre début réservation");
	String d = s.nextLine();
	LocalDateTime date_reservation = obtenirDate(d);
	
	//////////////
	int numero = numero_chambre %100;
	int etage = numero_chambre/10;
	
	System.out.println("\n Quel client etes vous ?");
	afficheClients();
	int i = s.nextInt();
	s.nextLine();
	Client c = liste_clients.get(i-1);
	
	System.out.println("Entrez votre adresse mail pour confirmer votre identité");
	String mail = s.nextLine();

	if(! mail.equals(c.getEmail())){
	    System.out.println("mauvais email");
	    return -1;
	}
	else{
	//////////////////////////// RECHERCHE DU CLIENT DANS LA CHAMBRE ////////////////////////////////
	    //System.out.println("Quel est votre numéro de chambre ?");
	    //int num_chambre = s.nextInt();
	    //s.nextLine();
	    Chambre c1 = trouveChambre(numero_chambre);
	    // System.out.println("Quelle est votre date de debut de reservation");
	    //String date2 = s.nextLine();
	    //LocalDateTime date3 = obtenirDate(date2);
	    Reservation r = c1.trouveReservation(date_reservation);
	    Client vrai_client;
	    if(r != null){
	        vrai_client = r.trouveClient(mail); 
		
	    }else{
		System.out.println("numero ou date invalide");
		vrai_client = null;
	    }

	    if(vrai_client == null) return 1;
	    else{
       
		System.out.println("Voulez vous afficher le descriptif des massages ?");
		System.out.println("1: oui");
		System.out.println("2: non");
		int choix_desc = s.nextInt();
		s.nextLine();
		if(choix_desc == 1) Spa.affichePrix();
		Spa.afficheMenuSpa();
		int choix_massage = s.nextInt();
		s.nextLine();
		System.out.println(vrai_client);

		vrai_client.ajouterUnMassage(choix_massage);

	    }
	 
	}
	return 1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void afficheClients(){
	String s = "";
	for(int i = 0; i < liste_clients.size(); i++){
	    Client c = liste_clients.get(i);
	    s = s+(i+1)+":"+ c.pe();
	    System.out.println(s);
       
	    s = "";
	}

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void reserverChambre(){

	Scanner sc = new Scanner(System.in);
	System.out.println("Faites vous parti du fichier client ?\n1: oui\n2: non");
	int rep = sc.nextInt();
	int nb_client;
	Client c1;
	if(rep == 1){
	    afficheClients();
	    nb_client = sc.nextInt();
	    c1 = liste_clients.get(nb_client -1);
	}
	else{
	    c1 = NouveauClient();
	}

	System.out.println("Quel type de chambre souhaitez vous?\n1: simple\n2: double\n3: triple\n4: deluxe");
	int type_chambre = sc.nextInt();
	sc.nextLine();

	// System.out.println("Combien de clients etes vous pour cette chambre ?");
	// int nombre_client = sc.nextInt();
	// sc.nextLine();
	System.out.println("A quelle date voulez vous reserver la chambre ?(aaaa/mm/jj)");
	String deb = sc.nextLine();
	
        LocalDateTime debut = obtenirDate(deb);
	System.out.println("A quelle date voulez vous quitter la chambre ?(aaaa/mm/jj)");
	String f = sc.nextLine();
	//sc.nextLine();
	LocalDateTime fin = obtenirDate(f);

	Reservation r;
	Chambre c;
	if(type_chambre == 1){
	    r =  new Reservation(debut, fin, 1);
	    c = reservable(etage_simple,r);
	}
	else if(type_chambre == 2){
	    r = new Reservation(debut, fin, 2);
	    c = reservable(etage_double,r);
	}
	else if(type_chambre == 3){
	    r = new Reservation(debut, fin, 3);
	    c = reservable(etage_triple,r);
	}
	else{
	    r = new Reservation(debut, fin, 2);
	    c = reservable(etage_deluxe,r);
	}
	c.ajouterReservation(r);
	System.out.println(r.ajouterClient(c1));
	System.out.println("Votre chambre est la numero:"+c.getNumero());
	
	if(type_chambre == 4) type_chambre = 2;
	int i = 1;
	int sa = 1;
	while(i < type_chambre && sa != 2){
	    System.out.println("Souhaitez vous ajouter un autre client dans votre chambre ?\n1: oui\n2: non");
	    sa = sc.nextInt();
	    if(sa == 1){
		Client c5 = faireClient();
		r.ajouterClient(c5);
	    }
	    i=i+1;
	}

	r.attribueTicket();
    
    
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public LocalDateTime obtenirDate(String chaine){
	String[] date = chaine.split("/");
	if(date.length != 3 || date[0].length() != 4 || date[1].length() > 2 || date[2].length() >2) return null;
	int a = Integer.parseInt(date[0]);
	int m = Integer.parseInt(date[1]);
	int j = Integer.parseInt(date[2]);

	LocalDateTime l = LocalDateTime.of(a,m,j,0,0);
	return l;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    public Chambre reservable(Chambre[] tab, Reservation r){
	int n = tab.length;
	int i = -1;
	boolean trouve = false;
	while(i < n-1 && !trouve){
	    i = i+1;
	   
	    trouve = tab[i].reservable(r);
	   
	    
	}

	if(trouve){ 
	    return tab[i];
	}
	else{
	    return null;
	}
    }
    /////////////////////////////////////////////////////////////////////////////////////
    public Client faireClient(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Etes vous dans le fichier client ?\n1: oui \n2: non");
	int choix = sc.nextInt();
	Client c;
	int i;
	if(choix == 1){
	    afficheClients();
	    i = sc.nextInt();
	    c = liste_clients.get(i-1);
	}
	else{
	    c = NouveauClient();
	}

	return c;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    public void imprimerTicket(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Quel est votre numéro de chambre ?");
	int numero_chambre = sc.nextInt();
	sc.nextLine();
	
	System.out.println("Quel est la date de votre rerservation ?");
	String date = sc.nextLine();
	Chambre c = trouveChambre(numero_chambre);
	LocalDateTime date_resa = obtenirDate(date);
	c.imprimeTicket(date_resa);

    }
    //////////////////////////////////////////////////////////////////////////////////
    public Chambre trouveChambre(int i){
	int n = i % 100;
	int num_etage = i / 100;
	if(num_etage == 1){
	    return etage_simple[n];
	}
	else if(num_etage == 2){
	    return etage_double[n];

	}
	else if(num_etage == 3){
	    return etage_triple[n];
	}
	else{
	    return etage_deluxe[n];
	}
    }

    /////////////////////////////////////////////////////////////////////////////////
    public void faireRestaurant(){
	Restaurant r = new Restaurant();
	// Demande d'info
	Scanner s = new Scanner(System.in);
	System.out.println("\n Quel est votre numero de chambre ?");
	int numero_chambre = s.nextInt();
	s.nextLine();
	System.out.println("Quelle est la date de votre début réservation");
	String d = s.nextLine();
	LocalDateTime date_reservation = obtenirDate(d);
	
	int numero = numero_chambre %100;
	int etage = numero_chambre/10;
	
	System.out.println("\n Quel client etes vous ?");
	afficheClients();
	int i = s.nextInt();
	s.nextLine();
	Client c = liste_clients.get(i-1);
	
	//Affiche carte
	Carte carte = r.getCarte();
	System.out.println(carte);
	
	//demande s'il veut une formule ou carte
	System.out.println("Voulez vous commander ?\n1: A la carte\n2: Mojito (plat + boisson)\n3: Daiquiri (plat + accompagnement + boisson) ");
	int choix = s.nextInt();
	s.nextLine();
	double prix = 0;
	if(choix == 1){ // a la carte
	    //choix du plat
	    System.out.println("Voulez vous un plat ?\n1: oui\n2:non");
	    int n_plat = s.nextInt();
	    if(n_plat==1){
		carte.affichePlat();
		int num_plat = s.nextInt();
		prix += 5;
	    }
	    //choix de l'accompagnement
	    System.out.println("Voulez vous un accompagnement ?\n1: oui\n2:non");
	    int n_accompagnement = s.nextInt();
	    if(n_accompagnement == 1){
		carte.afficheAccompagnement();
		int num_accompagnent = s.nextInt();
		prix +=2;
	    }
	    //choix du dessert
	    System.out.println("Voulez vous un dessert ?\n1: oui\n2:non");
	    int n_dessert = s.nextInt();
	    if(n_dessert == 1){
		carte.afficheAccompagnement();
		int num_dessert = s.nextInt();
		prix += 3.50;
	    }

	    //choix de la boisson
	    System.out.println("Voulez vous une boisson ?\n1: oui\n2:non");
	    int n_boisson = s.nextInt();
	    if(n_boisson == 1){
		carte.afficheAccompagnement();
		int num_boisso = s.nextInt();
		prix += 2;
	    }
	    
	}
	else if(choix == 2){ // mojito
	    carte.affichePlat();
	    int plat = s.nextInt();
	    carte.afficheBoisson();
	    int boi = s.nextInt();
	    
	    prix += 6;
	}
	else{ // daiquiri
	    carte.affichePlat();
	    int plat = s.nextInt();
	    carte.afficheAccompagnement();
	    int acc = s.nextInt();
	    carte.afficheBoisson();
	    int boi = s.nextInt();
	    prix +=8;
	}
	// PAIEMENT //
	System.out.println("Le prix du repas est de" + "\nEn utilisant un ticket, il vous reste " +( prix - 5)+ "€ a payer, ils sont ajouter à la note");
	System.out.println("Vous disposez de " + c.getNbTicketRestau()+ "tickets restaurants");
       
	c.modificationRepas(prix);
    }
     
    
}
