import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Gestion{
    private ArrayList<Utilisateur> tabUtilisateurs;

    public Gestion(){
	tabUtilisateurs = new ArrayList<Utilisateur>();
    }
    
    public void chargerSauvegarde(String fileName) throws FileNotFoundException, IOException{
	RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
	String line;
	File myFile = new File(fileName);
	Scanner scan = new Scanner(myFile);
	String[] split;
	Utilisateur u = null;
	Maison m = null;
	Piece p = null;
	Objet o = null;

	//Read file
	while((line = rf.readLine()) != null) {
	    split = scan.nextLine().split("#");
	    System.out.println(split[0] + ", " + split[1]); 
	    if(split[0].equals("u")){
		System.out.println("New utilisateur");
		u = new Utilisateur(split[1]);
		ajouterUtilisateur(u);
	    }
	    if(split[0].equals("m")){
		System.out.println("New maison");
		m = new Maison(split[1]);
		u.ajouterMaison(m);
	    }
	    if(split[0].equals("p")){
		System.out.println("New piece");
		p = new Piece(split[1]);
		m.ajouterPiece(p);
	    }
	    
	}
	rf.close();
    }

    public void sauvegarder(String fileName) throws FileNotFoundException, IOException{
	RandomAccessFile rf = new RandomAccessFile(fileName, "rw");
	rf.seek(0);

	String data = "";
	for(Utilisateur u: tabUtilisateurs){
	    data += u.sauv();
	}
	data = data.substring(0, data.length() - 1);
	//System.out.println(data);

	rf.write(data.getBytes());
	rf.close();
    }
    
    public void ajouterUtilisateur(Utilisateur u){
	tabUtilisateurs.add(u);
    }

    public void ajouterUtilisateur(String nom){
	tabUtilisateurs.add(new Utilisateur(nom));
    }
    
    public void print(){
        System.out.println("Contenu de la sauvegarde :");
	for(Utilisateur u: tabUtilisateurs){
	    u.print();
	}
    }
}
