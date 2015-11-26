
public interface Strategie {
	public CarteIngredient jouerIngredient();
	public CarteAllie jouerAllie();
	private CarteIngredient getBestCarteFor(Carte carte);
}
