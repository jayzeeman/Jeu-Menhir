import java.util.Scanner;

public abstract class Clavier {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int readInt() {
		return scanner.nextInt();
	}
	
	public static String readString() {
		return scanner.next();
	}
	
	public static byte readByte() {
		return scanner.nextByte();
	}
	
	public static char readChar() {
		return scanner.next().charAt(0);
	}
	
	public static void close() {
		scanner.close();
	}
}
