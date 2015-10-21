
public enum Saison {
	Printemps(0),
	Ete(1),
	Automne(2),
	Hiver(3);
	
	private int valeur;
	
	private Saison(int valeur) {
		this.valeur = valeur;
	}
	
	public int getValeur() {
		return this.valeur;
	}
}
