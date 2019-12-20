import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import personne.*;
import chambre.*;
import reservation.*;
import pays.*;

public class Gestionv2{
    private ArrayList<Client> tabUtilisateurs;

    public Gestionv2(){
	tabUtilisateurs = new ArrayList<Client>();
    }

    public void chargerSauvegarde(String filename) throws FileNotFoundException, IOException{
	RandomAccessFile rf = new RandomAccessFile(filename, "rw");
	String line;
	File mon_fichier = new File(filename);
	Scanner scan = new Scanner(mon_fichier);
	String[] separation;
	Client c = null;

	int total = -1;
	int restant = -1;
	double supp = -1;
	LocalDateTime date_nai = null;
	
	String nom = null;
	String prenom = null;
	String email = null;
	String numero = null;
	Pays pays = null;
	String massage = null;
	String supplemen = null;
	String tot = null;
	String utilise = null;
	String sup = null;
	String naissance = null;
	String d1 = null;
	while((line = rf.readLine()) != null){
	    separation = scan.nextLine().split("#");
	    
	    if(separation[0].equals("u")){//OK
		nom = separation[1];
	    }
	    if(separation[0].equals("p")){//OK
		prenom = separation[1];
	    }
	    if(separation[0].equals("pa")){//OK
		pays = new Pays(separation[1]);
	    }
	    if(separation[0].equals("e")){//OK
		email = separation[1];
	    }
	    if(separation[0].equals("num")){//OK
		numero = separation[1];
	    }
	    if(separation[0].equals("tot")){
		tot = separation[1];
		total = Integer.parseInt(tot);//OK
	    }
	    if(separation[0].equals("sor")){//OK
		utilise = separation[1];
		restant = Integer.parseInt(utilise);
	    }
	    if(separation[0].equals("m")){
		massage = separation[1];
		int temp = Integer.parseInt(massage);
		int[] tableau = new int[3];
		tableau[0] = temp%10 ;
		temp/10;
		tableau[1] = temp%10;
		temp/10;
		tableau[2] = temp%10;
	    }
	    if(separation[0].equals("sup")){
		sup = separation[1];
		if(sup.split(".")){
		    String[] partie = sup.split(".");
		    supp = Integer.parseInt(partie[0]) + Integer.parseInt(partie[1])*(Math.pow(10,partie[1].length()));
		}else{
		    supp = (double) Integer.parseInt(sup); 

		}
	    }
	    if(separation[0].equals(" ")){
		d1 = separation[1];
		String a = d1.substring(0,4);
		String m = d1.substring(4,6);
		String j = d1.substring(6);
		date_nai = LocalDateTime.of(Integer.parseInt(a),Integer.parseInt(m) ,Integer.parseInt(j) , 0,0);
	    }

	    if(/*ECRIRE LE TEST*/){
		c = new Client(nom, prenom, /*naissance*/,email,numero);
		c.setSortis(total);
		c.setNbTicketRestau(restant);
	    }
	}
	      
	   

    }

    


    public void Sauvegarder(String filename) throws FileNotFoundException, IOException{
	RandomAccessFile rf =  new RandomAccessFile(filename, "rw");
	rf.seek(0);
	String data = "";
	for(Client c: tabUtilisateurs){
	    data += c.sauv();
	}
	data = data.substring(0, data.length() - 1);
	rf.write(data.getBytes());
	rf.close();

    }

    public void ajouterClient(Client c){
	tabUtilisateurs.add(c);
    }

}
