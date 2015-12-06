
public class ImpossibleOperationException extends Exception {
	public ImpossibleOperationException(Carte carte) {
		super(carte.getNom() + " n'est pas une carte jouable !");
	}
}
