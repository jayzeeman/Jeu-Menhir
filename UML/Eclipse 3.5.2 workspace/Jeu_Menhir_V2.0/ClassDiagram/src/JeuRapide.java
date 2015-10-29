	public class JeuRapide extends Jeu {
		private JeuRapide(){}
		
		public static Jeu Lancer() {
			if (jeu==null) {
				jeu=new JeuRapide();
			}
			return jeu;
		}
	}
