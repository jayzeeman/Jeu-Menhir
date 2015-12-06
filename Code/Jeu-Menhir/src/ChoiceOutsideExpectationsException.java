
public class ChoiceOutsideExpectationsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ChoiceOutsideExpectationsException(byte choice) {
		super(choice + " n'est pas une option disponible !");
	}
	
	public ChoiceOutsideExpectationsException(int choice) {
		super(choice + " n'est pas une option disponible !");
	}
	
	public ChoiceOutsideExpectationsException(char choice) {
		super(choice + " n'est pas une option disponible !");
	}
}
