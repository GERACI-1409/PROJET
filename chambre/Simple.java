package chambre;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Simple extends Chambre{

    public static int nb_client = 1;
    public static int max_nbChambres = 10;
    public static int prox;

    

    public Simple(){
	super(100 + prox,124.70,1,"simple");
	prox+=1;
	
    }


    public String toString(){
	return "num:"+ numero;
    }


    

}
