package chambre;

public class CDouble extends Chambre{

 
    public static int max_nbChambres = 7;
    public static int prox;
    public CDouble(){
	super(200 + prox,137.60, 2, "double");
	prox+=1;
	nb_client = 2;
    }
}
