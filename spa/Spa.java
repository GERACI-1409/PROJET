package spa;


import personne.*;
public class Spa{
    /* *nom du spa*/
    private String nom;

    ///////// constructeur ///////////////
    public Spa(String nom){
	this.nom = nom;
    }


    public Spa(){
	this("Yuma Massage");
    }
	
    //////////// geters /////////////////
    /**
     * Methode qui retourne le nom du spa
     */
    public String getNom(){
	return nom;
    }

    /////////////// seters ///////////////
    /**
     * Modifie le nom du spa
     */
    public void setNom(String s){
	nom = s;
    }
    ///////////////////////// autres méthodes //////////////////////////

    /**
     * Méthode qui affiche la description et les prix des massages du spa Yuma Massage
     */
    public static void affichePrix(){
	String l0 = "**************** Bienvenue au Spa Yuma Massage ********************";
	String l1 = "MASSAGE RELAXANT: A la fois relaxant et profond, il vous plongera dans une totale détente musculaire, physique et psychique. \nPRIX: 50 euros";
	String l2 = "MASSAGE AUX PIERRES CHAUDES: Ce  massage,  par  la  douce  chaleur  des  pierres  volca-niques, harmonise les flux d’énergie et vous transporte dans une profonde relaxation.\nPRIX:70 euros";
	String l3 = "MASSAGE A L'ELIXIR DE BOUGIE: Laissez-vous envelopper par la douce chaleur d’une bougie  devenue  huile  de  massage  qui  libère  un  véri-table  élixir  aromatique  hydratant  pour  un  massage d’une infinie douceur sur l’ensemble du corps.\nPRIX: 80 euros ";
	System.out.println(l1+"\n"+l2+"\n"+l3);   

    }


    /**
     * Methode qui affiche les massages disponibles.
     */
    public static void afficheMenuSpa(){
	System.out.println("Quel massage souhaitez vous");
	System.out.println("1: Massage relaxant");
	System.out.println("2: Massage aux pierres chaudes");
	System.out.println("3: Massage a l'elixir de bougie");
    }

    /**
     * Affiche le prix du massage en fonction du massage choisi
     */
    public static void dernierAffichage(int i, Client c){
	int prix;
	System.out.println("Rendez vous dans la salle de massage");
	if(i == 1) prix = 50;
	if(i == 2) prix = 70;
	if(i == 3) prix = 80;
	System.out.println(""+prix+" euros sont ajoutes sur votre note.");
    }
}
