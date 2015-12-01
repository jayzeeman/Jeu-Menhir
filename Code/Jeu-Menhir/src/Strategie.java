
public interface Strategie {
	public CarteIngredient choisirIngredient(byte saison);
	public CarteAllie choisirAllie(byte saison);
	public byte choisirAction();
}
