

public class Test{

  public static void main(String[] args){
    /*Mise budget = new Mise(1575) ;
    budget.conversion() ;
    budget.Miser() ;*/
    int[] tab = new int[37];
    int i ;
    for(i=0 ; i<=36 ;i++){
      tab[i] = i ;
    }
    Resultat r = new Resultat(tab,new Case());
    Jouer j = new Jouer(r) ;
    j.menuCasino() ;

  }

}
