package adventure;

public class InvalidMoveException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidMoveException() {
		System.out.println("I can't go that way!");
	}
}