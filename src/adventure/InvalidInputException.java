package adventure;

public class InvalidInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		System.out.println("I can't do that! (Enter 'H' for commands list)");
	}
}