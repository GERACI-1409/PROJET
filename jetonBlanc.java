

public class jetonBlanc extends Jeton{
  private final int valeur = 1 ;

  public jetonBlanc(int valeur, String couleur){
    super(valeur,"blanc") ;
  }

  public int getValeurBlanc(){
    return valeur ;
  }
}
