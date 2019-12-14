import chambre.*;

public class Test2{
    public static void main(String[] args){
	Hotel h = new Hotel(5,3,1,1, "BBH");
	// Simple[] etage1= h.getEtageSimple();
	
	// for(Simple s: etage1){
	//     System.out.println(s.getNumero());
	// }

	// CDouble[] etage2 = h.getEtageDouble();

	// for(CDouble s: etage2){
	//     System.out.println(s.getNumero());
	// }
	    
      	h.run();
    }
}
