public class Restaurant{
    private Carte c;
    private String m1;
    private String m2;

    public Restaurant(){
	c = new Carte();
	m1 = "Mojito (plat + boisson) 6€";
	m2 = "Daiquiri (plat + accompagnement + boisson) 8€";	    
    }

    public Carte getCarte(){
	return c;
    }

    public void afficheChoix(){
	System.out.println("Voulez-vous commander ?");
	System.out.println("1: A la carte\n2: "+m1+"\n3 : "+m2);
    }







}
