

public class Case{

  private int nombre ;
  private String couleur ;
  private Boolean pair ;
  private Boolean manque ; //numéro de 1 à 18 ;

  /***Constructeur par défaut***/
  public Case(){
    this(0,"vert",false,false) ;
  }

  /***Constructeur***/
  public Case(int nombre, String couleur, Boolean pair, Boolean manque){
    this.nombre = nombre ; this.couleur = couleur ; this.pair = pair ; this.manque = manque ;
  }

  public int getNombre(){
    return nombre ;
  }

  public String getCouleur(){
    return couleur ;
  }

  public Boolean getPair(){
    return pair ; //false --> numéro impaire
  }

  public Boolean getManque(){
    return manque ; //false --> numéro 19 à 36
  }

  public void setNombre(int nbr){
    nombre = nbr ;
  }

  public void setCouleur(String couleurRemplacement){
    couleur = couleurRemplacement ;
  }

  public void setPair(Boolean pairRemplacement){
    pair = pairRemplacement ;
  }

  public void setManque(Boolean manqueRemplacement){
    manque = manqueRemplacement ;
  }

  public String toString(){
    return "Le numéro est le "+nombre+" de couleur "+couleur ;
  }
}
