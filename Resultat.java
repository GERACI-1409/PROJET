import java.util.Scanner ;
import java.util.*;

public class Resultat{


  private int[] numero ;
  private Case c ;

  public Resultat(int[] numero, Case c){
    this.numero = numero ; this.c = c ;
  }


  public Case resultatRoulette(){
    Case case1 = new Case() ;
    int resultat = numero[(int)(Math.random()*numero.length)] ;
    if(resultat<=10 && resultat!=0 && resultat%2==0){
      case1.setNombre(resultat) ;
      case1.setPair(true) ;
      case1.setCouleur("noir") ;
      case1.setManque(true) ;
      return case1 ;
    }
    else if(resultat<10 && resultat!=0 && resultat%2==1){
      case1.setNombre(resultat) ;
      case1.setPair(false) ;
      case1.setCouleur("rouge") ;
      case1.setManque(true) ;
      return case1 ;
    }
    else if(resultat>10 && resultat<=18 && resultat%2==0){
      case1.setNombre(resultat) ;
      case1.setPair(true) ;
      case1.setCouleur("rouge") ;
      case1.setManque(true) ;
      return case1 ;
    }
    else if(resultat>10 && resultat<18 && resultat%2==1){
      case1.setNombre(resultat) ;
      case1.setPair(false) ;
      case1.setCouleur("noir") ;
      case1.setManque(true) ;
      return case1 ;
    }
    else if(resultat>18 && resultat<=28 && resultat%2==1){
      case1.setNombre(resultat) ;
      case1.setPair(false) ;
      case1.setCouleur("rouge") ;
      case1.setManque(false) ;
      return case1 ;
    }
    else if(resultat>18 && resultat<=28 && resultat%2==0){
      case1.setNombre(resultat) ;
      case1.setPair(true) ;
      case1.setCouleur("noir") ;
      case1.setManque(false) ;
      return case1 ;
    }
    else if(resultat>=29 && resultat<=36 && resultat%2==0){
      case1.setNombre(resultat) ;
      case1.setPair(true) ;
      case1.setCouleur("rouge") ;
      case1.setManque(false) ;
      return case1 ;
    }
    else if(resultat>=29 && resultat<=36 && resultat%2==1){
      case1.setNombre(resultat) ;
      case1.setPair(false) ;
      case1.setCouleur("noir") ;
      case1.setManque(false) ;
      return case1 ;
    }
    else{
      case1.setNombre(resultat) ;
      case1.setPair(false) ;
      case1.setCouleur("verte") ;
      case1.setManque(false) ;
      return case1 ;
    }
  }

}
