import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;


public class JeuComplet extends Jeu {
	private byte numManche;
	
	public JeuComplet(byte nombreJoueurs) {
		super(nombreJoueurs);
		numManche = 0;
		for(byte i=0;i<nombreJoueurs;i++) {
			this.lancerTour();
		}
	} 

	protected void genererCartes() {
		super.genererCartes();
		
		// générer cartes allié depuis le fichier de ressource "cartesAllie.txt"
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesAllie.txt");
		Scanner scanner = new Scanner(is);
		while(scanner.hasNextLine()) {
			String[] values = scanner.next().split(",");
			
			cartes.add(new CarteAllie(values[0],values[1],values[2],values[3],values[4]));
		}
	}

}
