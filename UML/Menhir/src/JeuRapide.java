public class JeuRapide extends Jeu {
	private JeuRapide() {}
	
	public static Jeu lancer() {
		if(jeu==null) {
			jeu = new JeuRapide();
		}
		return jeu;
	}
}
