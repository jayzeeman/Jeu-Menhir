import java.util.Iterator;
import java.util.Scanner;

public class JoueurReel extends Joueur {
	private String nom;

	public JoueurReel(String nom) {
		super();
		this.nom = nom;
	}
	
	public CarteIngredient jouerIngredient() {
		int compteur = 0;
		System.out.println("Jouer quelle carte ?");
		for(Iterator it = cartesIngredient.iterator();it.hasNext();) {
			Carte carte = (Carte)it.next();
			System.out.println(compteur + carte.toString());
		}
		Scanner scanner = new Scanner(System.in);
		CarteIngredient carteChoisie = cartesIngredient.get(scanner.nextInt());
		scanner.close();
		return carteChoisie;
	}
}
