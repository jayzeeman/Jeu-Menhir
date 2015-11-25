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
		
		cartesAllie = new LinkedList<CarteAllie>();
		// générer cartes allié depuis le fichier de ressource "cartesAllie.txt"
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesAllie.txt");
		Scanner scanner = new Scanner(is);
		while(scanner.hasNextLine()) {
			String[] values = scanner.next().split(",");
			int[] force = {Integer.parseInt(values[1]),Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])};
			cartesAllie.add(new CarteAllie(values[0],force));
		}
		scanner.close();
	}

}
