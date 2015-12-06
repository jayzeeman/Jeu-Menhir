import java.util.Scanner;

public abstract class Clavier {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int readInt(int maximum) throws ChoiceOutsideExpectationsException {
		int retour = scanner.nextInt();
		if(retour >= maximum) {
			throw new ChoiceOutsideExpectationsException(retour);
		}
		return retour;
	}
	
	public static int readInt(int minimum, int maximum) throws ChoiceOutsideExpectationsException {
		int retour = scanner.nextInt();
		if(retour < minimum || retour > maximum) {
			throw new ChoiceOutsideExpectationsException(retour);
		}
		return retour;
	}
	
	public static String readString() {
		return scanner.next();
	}
	
	public static byte readByte(byte indiceMaximum) throws ChoiceOutsideExpectationsException {
		byte retour = scanner.nextByte();
		if(retour < 0 || retour > indiceMaximum) {
			throw new ChoiceOutsideExpectationsException(retour);
		}
		return retour;
	}
	
	public static char readChar(String choices) throws ChoiceOutsideExpectationsException {
		char retour = scanner.next().charAt(0);
		if(choices.indexOf(retour) != -1) {
			throw new ChoiceOutsideExpectationsException(retour);
		}
		return retour;
	}
	
	public static void close() {
		scanner.close();
	}
}
