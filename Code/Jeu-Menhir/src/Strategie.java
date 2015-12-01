
public interface Strategie {
	public CarteIngredient choisirIngredient(byte saison, byte action);
	public CarteAllie choisirAllie(byte saison);
	public byte choisirAction();
	public byte choisirDebut();
}
