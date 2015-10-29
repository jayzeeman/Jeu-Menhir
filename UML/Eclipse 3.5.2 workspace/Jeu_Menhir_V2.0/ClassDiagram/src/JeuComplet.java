
public class JeuComplet extends Jeu {
	private int numManche;
	private JeuComplet() {}
	
	public static Jeu lancer(){
		if(jeu==null){
			jeu=new JeuComplet();
		}
		return jeu;
	}
}
