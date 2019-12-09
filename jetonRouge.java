

public class jetonRouge extends Jeton{

  private final int valeur = 10 ;

  public jetonRouge(int valeur, String couleur){
    super(valeur,"rouge") ;
  }

  public int getValeurRouge(){
    return valeur ;
  }
}
