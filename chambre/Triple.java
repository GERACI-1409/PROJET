package chambre;

public class Triple extends Chambre{
    
    public static int nb_client = 3;
    public static int max_nbChambres = 5;
    public static int prox;
    public Triple(){
	super(300+prox,163.40, 3, "triple");
	prox += 1;
    }

}
