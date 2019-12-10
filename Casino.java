import java.util.Scanner ;

public class Casino{

  private Resultat r  ;

  public Casino(Resultat r){
    this.r = r ;
  }

  public void menuCasino(){
    Scanner sc = new Scanner(System.in) ;
    System.out.println("Bienvenue au casino") ;
    System.out.println("Voulez-vous jouer à la roulette ? [o/n] ") ;
    String s = sc.nextLine() ;

    System.out.println("Quelle somme voulez-vous jouer (euros) ?") ;
    int budget = sc.nextInt() ;
    sc.nextLine();

    Mise m = new Mise(budget) ;

    int misededepart = m.getValeur() ; // pour l'avoir dans imprimeTicket() ;

    int[] tab = new int[37];
    for(int i=0 ; i<=36 ;i++){
      tab[i] = i ;
    }
    Resultat r = new Resultat(tab,new Case()) ;
    Casino j = new Casino(r) ;
    int a = 1 ;
    while(s.equals("o") && a>-100000){
      a = j.jouerCasino(m,sc) ;
      if(a>-100000){
        System.out.println("Voulez-vous réessayer ? [o/n]") ;
        s = sc.nextLine() ;
        if(s.equals("n")){
          int mise = a ;
          System.out.println(mise) ;
          j.imprimeTicket(m,mise,misededepart) ;
        }
        else{
          s = "o" ;
        }
      }
    }
  }

  public int jouerCasino(Mise m,Scanner sc){
    m.conversionValeur();
    int[] tab1 = m.Miser() ;
    int[] tabzero = new int[4] ;
    if(tab1[0]==tabzero[0] && tab1[1]==tabzero[1] && tab1[2]==tabzero[2] && tab1[3]==tabzero[3]){
      System.out.println("Vous avez plus de jetons ") ;
      return -1000000 ;
    }
    else{
    int[] tab = new int[4] ;
    System.out.println("Faîtes vos jeux : ") ;
    String str = sc.nextLine() ;
    System.out.println("\nLes jeux sont faits\n") ;
    Case c = r.resultatRoulette();
    if(str.equals("pair") || str.equals("Pair")){
      System.out.println(c) ;
      if(c.getPair()){
        tab[0] = tab1[0]*2 ;
        tab[1] = tab1[1]*2 ;
        tab[2] = tab1[2]*2 ;
        tab[3] = tab1[3]*2 ;
        System.out.println("Vous avez gagné ");


        int ajoutOrange = tab[0]+(m.getJetOrange()-tab1[0]);
        int ajoutVert = tab[1]+(m.getJetVert()-tab1[1]);
        int ajoutRouge = tab[2]+(m.getJetRouge()-tab1[2]);
        int ajoutBlanc = tab[3]+(m.getJetBlanc()-tab1[3]);

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int gain = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(gain) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
      else{

        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        System.out.println("Vous avez perdu votre mise") ;

        int ajoutOrange = m.getJetOrange() - tab1[0] ;
        int ajoutVert =  m.getJetVert() - tab1[1] ;
        int ajoutRouge =  m.getJetRouge() - tab1[2] ;
        int ajoutBlanc =  m.getJetBlanc() - tab1[3] ;

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int perte = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(perte) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
    }
    else if(str.equals("rouge") || str.equals("Rouge")){
      System.out.println(c) ;
      if(c.getCouleur().equals("rouge") || c.getCouleur().equals("Rouge")){
        tab[0] = tab1[0]*2 ;
        tab[1] = tab1[1]*2 ;
        tab[2] = tab1[2]*2 ;
        tab[3] = tab1[3]*2 ;

        System.out.println("Vous avez gagné ");

        int ajoutOrange = tab[0]+(m.getJetOrange()-tab1[0]);
        int ajoutVert = tab[1]+(m.getJetVert()-tab1[1]);
        int ajoutRouge = tab[2]+(m.getJetRouge()-tab1[2]);
        int ajoutBlanc = tab[3]+(m.getJetBlanc()-tab1[3]);

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int gain = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(gain) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
      else{
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        System.out.println("Vous avez perdu votre mise") ;

        int ajoutOrange = m.getJetOrange() - tab1[0] ;
        int ajoutVert =  m.getJetVert() - tab1[1] ;
        int ajoutRouge =  m.getJetRouge() - tab1[2] ;
        int ajoutBlanc =  m.getJetBlanc() - tab1[3] ;

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int perte = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(perte) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
    }
    else if(str.equals("noir") || str.equals("Noir")){
      System.out.println(c) ;
      if(c.getCouleur().equals("noir") || c.getCouleur().equals("Noir")){
        tab[0] = tab1[0]*2 ;
        tab[1] = tab1[1]*2 ;
        tab[2] = tab1[2]*2 ;
        tab[3] = tab1[3]*2 ;

        System.out.println("Vous avez gagné ");

        int ajoutOrange = tab[0]+(m.getJetOrange()-tab1[0]);
        int ajoutVert = tab[1]+(m.getJetVert()-tab1[1]);
        int ajoutRouge = tab[2]+(m.getJetRouge()-tab1[2]);
        int ajoutBlanc = tab[3]+(m.getJetBlanc()-tab1[3]);

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int gain = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(gain) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
      else{
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        System.out.println("Vous avez perdu votre mise") ;

        int ajoutOrange = m.getJetOrange() - tab1[0] ;
        int ajoutVert =  m.getJetVert() - tab1[1] ;
        int ajoutRouge =  m.getJetRouge() - tab1[2] ;
        int ajoutBlanc =  m.getJetBlanc() - tab1[3] ;

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int perte = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(perte) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
    }
    else if(str.equals("manque") || str.equals("Manque")){
      System.out.println(c) ;
      if(c.getManque()){
        tab[0] = tab1[0]*2 ;
        tab[1] = tab1[1]*2 ;
        tab[2] = tab1[2]*2 ;
        tab[3] = tab1[3]*2 ;

        System.out.println("Vous avez gagné ");

        int ajoutOrange = tab[0]+(m.getJetOrange()-tab1[0]);
        int ajoutVert = tab[1]+(m.getJetVert()-tab1[1]);
        int ajoutRouge = tab[2]+(m.getJetRouge()-tab1[2]);
        int ajoutBlanc = tab[3]+(m.getJetBlanc()-tab1[3]);

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int gain = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(gain) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
      else{
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        System.out.println("Vous avez perdu votre mise") ;

        int ajoutOrange = m.getJetOrange() - tab1[0] ;
        int ajoutVert =  m.getJetVert() - tab1[1] ;
        int ajoutRouge =  m.getJetRouge() - tab1[2] ;
        int ajoutBlanc =  m.getJetBlanc() - tab1[3] ;

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int perte = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(perte) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
    }
    else if(str.equals("passe") || str.equals("Passe")){
      System.out.println(c) ;
      if(c.getManque()){
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        System.out.println("Vous avez perdu votre mise") ;

        int ajoutOrange = m.getJetOrange() - tab1[0] ;
        int ajoutVert =  m.getJetVert() - tab1[1] ;
        int ajoutRouge =  m.getJetRouge() - tab1[2] ;
        int ajoutBlanc =  m.getJetBlanc() - tab1[3] ;

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int perte = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(perte) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
      else{
        tab[0] = tab1[0]*2 ;
        tab[1] = tab1[1]*2 ;
        tab[2] = tab1[2]*2 ;
        tab[3] = tab1[3]*2 ;
        System.out.println("Vous avez gagné ");

        int ajoutOrange = tab[0]+(m.getJetOrange()-tab1[0]);
        int ajoutVert = tab[0]+(m.getJetVert()-tab1[1]);
        int ajoutRouge = tab[0]+(m.getJetRouge()-tab1[2]);
        int ajoutBlanc = tab[0]+(m.getJetBlanc()-tab1[3]);

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int gain = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(gain) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
    }
    else{
      System.out.println(r.resultatRoulette()) ;
      if(c.getPair()){
        tab[0] = 0;
        tab[1] = 0;
        tab[2] = 0;
        tab[3] = 0;
        System.out.println("Vous avez perdu votre mise") ;

        int ajoutOrange = m.getJetOrange() - tab1[0] ;
        int ajoutVert =  m.getJetVert() - tab1[1] ;
        int ajoutRouge =  m.getJetRouge() - tab1[2] ;
        int ajoutBlanc =  m.getJetBlanc() - tab1[3] ;

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int perte = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(perte) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;

      }
      else{
        tab[0] = tab1[0]*2 ;
        tab[1] = tab1[1]*2 ;
        tab[2] = tab1[2]*2 ;
        tab[3] = tab1[3]*2 ;
        System.out.println("Vous avez gagné ");

        int ajoutOrange = tab[0]+(m.getJetOrange()-tab1[0]);
        int ajoutVert = tab[1]+(m.getJetVert()-tab1[1]);
        int ajoutRouge = tab[2]+(m.getJetRouge()-tab1[2]);
        int ajoutBlanc = tab[3]+(m.getJetBlanc()-tab1[3]);

        m.setOrange(ajoutOrange) ;
        m.setRouge(ajoutRouge) ;
        m.setVert(ajoutVert) ;
        m.setBlanc(ajoutBlanc) ;
        int gain = m.conversionJeton(ajoutOrange,ajoutVert,ajoutRouge,ajoutBlanc) ;
        m = new Mise(gain) ;

        System.out.println("Vous avez "+ajoutOrange+" jeton(s) orange(s) "+ajoutVert+" jeton(s) verts "+ajoutRouge+" jeton(s) rouge(s) "+ajoutBlanc+" jeton(s) blancs") ;
      }
    }
    return m.getValeur() ;
  }
}

  public void imprimeTicket(Mise m,int mise,int misededepart){
    //int nbJeton = m.conversionJeton() ;
    int difference = mise-misededepart ;
    System.out.println("Casino - La roulette") ;
    System.out.println("Mise de départ : "+misededepart+" €") ;
    System.out.println("Gain ou déficit : "+difference+"€") ;
  }
}
