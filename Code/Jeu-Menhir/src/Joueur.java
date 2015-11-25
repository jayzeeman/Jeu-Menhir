import java.util.LinkedList;

public abstract class Joueur {
	protected LinkedList<CarteIngredient> cartesIngredient;
	protected CarteAllie carteAllie;
	
	protected Joueur() {
		cartesIngredient = new LinkedList<CarteIngredient>();
		carteAllie = null;
	}
	
	public LinkedList<CarteIngredient> getCartesIngredient() {
		return cartesIngredient;
	}
	
	public CarteAllie getCarteAllie() {
		return carteAllie;
	}

	public abstract CarteIngredient jouerIngredient();
}
