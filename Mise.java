
import java.util.Scanner ;

public class Mise{

  private int valeur ;
  /**Nombre de jetons**/
  private int nbVert ;
  private int nbOrange ;
  private int nbBlanc ;
  private int nbRouge ;

  public Mise(int valeur){
    this.valeur = valeur ;
  }

  public Mise(){
    this(0) ;
  }

  /***get***/
  public int getValeur(){
    return valeur ;
  }

  public int getJetOrange(){
    return nbOrange ;
  }
  public int getJetVert(){
    return nbVert ;
  }
  public int getJetRouge(){
    return nbRouge ;
  }
  public int getJetBlanc(){
    return nbBlanc ;
  }

  /**set**/
  public void setOrange(int supplement){
    nbOrange = supplement ;
  }
  public void setVert(int supplement){
    nbVert = supplement ;
  }
  public void setRouge(int supplement){
    nbRouge = supplement ;
  }
  public void setBlanc(int supplement){
    nbBlanc = supplement ;
  }

  public void ajouterValeur(int supplement){
    valeur = valeur + supplement ;
  }
  public void ajouterOrange(int supplement){
    nbOrange = nbOrange + supplement ;
  }
  public void ajouterVert(int supplement){
    nbVert = nbVert + supplement ;
  }
  public void ajouterRouge(int supplement){
    nbRouge = nbRouge + supplement ;
  }
  public void ajouterBlanc(int supplement){
    nbBlanc = nbBlanc + supplement ;
  }


  public void conversionValeur(){
    while(valeur>=1000){
      nbOrange +=1 ;
      valeur -= 1000 ;
    }
    while(valeur>=100){
      nbVert += 1 ;
      valeur -= 100 ;
    }
    while(valeur>=10){
      nbRouge += 1 ;
      valeur -= 10;
    }
    while(valeur>0){
      nbBlanc +=1 ;
      valeur -= 1 ;
    }
  }

  public int conversionJeton(int nbOrange,int nbVert,int nbRouge,int nbBlanc){
    int valeur = 0 ;
    while(nbOrange>0){
      valeur += 1000 ;
      nbOrange -=1 ;
    }
    while(nbOrange>0){
      valeur += 100 ;
      nbVert -=1 ;
    }
    while(nbRouge>0){
      valeur += 10 ;
      nbRouge -=1 ;
    }
    while(nbBlanc>0){
      valeur += 1 ;
      nbBlanc -=1 ;
    }
    return valeur ;
  }

  public int[] Miser(){
    int[] tab  = new int[4] ;
    Scanner sc = new Scanner(System.in) ;
    System.out.println("Vous avez "+nbOrange+" jeton(s) orange(s) "+nbVert+" jeton(s) verts "+nbRouge+" jetons(s) rouge(s) "+nbBlanc+" jeton(s) blanc(s)\n");
    System.out.println("Vous misez combien de jetons oranges/verts/rouges/blancs ? : ");
    System.out.print("Jeton(s) orange(s) : ") ;
    int Orange = sc.nextInt() ;

    System.out.print("Jeton(s) verts(s) : ") ;
    int Vert = sc.nextInt() ;

    System.out.print("Jeton(s) rouge(s) : ") ;
    int Rouge = sc.nextInt() ;

    System.out.print("Jeton(s) blanc(s) : ") ;
    int Blanc = sc.nextInt() ;

    if(Orange>nbOrange || Vert>nbVert || Rouge>nbRouge || Blanc>nbBlanc){
      System.out.println("Vous n'avez pas assez de jetons, on vous met le maximum que vous pouvez miser ! :)") ;
      tab[0] = nbOrange ;
      tab[1] = nbVert ;
      tab[2] = nbRouge ;
      tab[3] = nbBlanc ;
      return tab ;
    }
    else{

      tab[0] = Orange ;
      tab[1] = Vert ;
      tab[2] = Rouge ;
      tab[3] = Blanc ;

      int diffO = nbOrange-tab[0] ;
      int diffV = nbVert-tab[1] ;
      int diffR = nbRouge-tab[2] ;
      int diffB = nbBlanc-tab[3] ;
      System.out.println("Il vous reste "+diffO+" jeton(s) orange(s) "+diffV+" jeton(s) vert(s) "+diffR+" jeton(s) rouge(s) "+diffB+" jeton(s) Blanc(s) ") ;

      return tab ;
    }
  }


  public String toString(){
    return nbOrange+" jeton(s) orange(s), "+nbVert+" jeton(s) orange(s), "+nbRouge+" jeton(s) rouge(s), "+nbBlanc+" jeton(s) blanc(s)";
  }
}
