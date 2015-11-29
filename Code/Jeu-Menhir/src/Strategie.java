
public interface Strategie {
	public CarteIngredient choisirIngredient(byte saison);
	public CarteAllie choisirAllie(byte saison);
	public CarteIngredient getBestCarteFor(byte saison);
	public byte choisirAction();
}
