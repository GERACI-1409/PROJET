import java.util.ArrayList;

public class Carte{
    private ArrayList<String> accompagnement;
    private ArrayList<String> plat;
    private ArrayList<String> dessert;
    private ArrayList<String> boisson;

    public Carte(){
	accompagnement = new ArrayList<String>();
	plat = new ArrayList<String>();
	dessert = new ArrayList<String>();
	boisson = new ArrayList<String>();
	accompagnement.add("Frites");
	accompagnement.add("Ratatouille");
	accompagnement.add("Riz");
	accompagnement.add("Pâtes");
	accompagnement.add("Purée de pomme de terre");

	plat.add("Bavette");
	plat.add("Carpaccio de boeuf à la vietnamienne");
	plat.add("Lasagnes");
	plat.add("Dinde au vin jaune");
	plat.add("Pizza");


	dessert.add("Soupe de mangue fraiche");
	dessert.add("Loukoum à la rose");
	dessert.add("Churros");
	dessert.add("Smoothies (ananas, mangue, fraise)");

	boisson.add("Soda");
	boisson.add("Eau gazeuse");
	boisson.add("Eau minérale");
	boisson.add("Noix de coco fraîche");

    }


    public String toString(){
	String s = "";

	String contour = "****************************************";
	String plats = "Plats (5€ à la carte):";
	for(int i = 0; i < plat.size(); i++){
	    plats += "\n"+i+": "+plat.get(i);
	}

	String acc = "Accompagnements (2€ à la carte):";
	for(int i = 0; i < accompagnement.size(); i++){
	    acc += "\n"+i+": " + accompagnement.get(i);
	}

	String boi = "Boissons (2€ à la carte):";
	for(int i = 0; i < boisson.size(); i++){
	    boi += "\n"+i+": " + boisson.get(i);
	}
	

    
	String des = "Dessert (3.50€ à la carte):";
	for(int i = 0; i < dessert.size(); i++){
	    des += "\n"+i+": " + dessert.get(i);
	}


	return contour + plats + "\n\n"+ acc + "\n\n" + des+"\n\n"+boi + "\n"+contour;
    }



    public void affichePlat(){

	String plats = "Plats (5€ à la carte):";
	for(int i = 0; i < plat.size(); i++){
	    plats += "\n"+i+": "+plat.get(i);
	}

	System.out.println(plats);

    }

    public void afficheDessert(){
	String des = "Dessert (3.50€ à la carte):";
	for(int i = 0; i < dessert.size(); i++){
	    des += "\n"+i+": " + dessert.get(i);
	}
	System.out.println(des);
	
    }
    
    public void afficheAccompagnement(){
	String acc = "Accompagnements (2€ à la carte):";
	for(int i = 0; i < accompagnement.size(); i++){
	    acc += "\n"+i+": " + accompagnement.get(i);
	}
	System.out.println(acc);
    }


    public void afficheBoisson(){
	String boi = "Boissons (2€ à la carte):";
	for(int i = 0; i < boisson.size(); i++){
	    boi +="\n"+i+": "+boisson.get(i);
	}
	System.out.println(boi);
    }
    
}
