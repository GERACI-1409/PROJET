package chambre;
public class Deluxe extends Chambre{

    public static int nb_client = 2;
    public static int max_nbChambres = 5;
    public static int prox;
    public Deluxe(){
	super(400+prox, 189.20, 2,"deluxe");
	prox+=1;
    }

    
}
