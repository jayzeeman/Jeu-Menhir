public enum Season {
	Printemps(0),
	Ete(1),
	Automne(2),
	Hiver(3);
	
	private int valeur;
	
	private Season(int valeur) {
		this.valeur=valeur;
	}
	public int getValeur() {
		return this.valeur;	
	}
}
