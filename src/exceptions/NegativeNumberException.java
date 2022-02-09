package exceptions;

public class NegativeNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeNumberException() {
		
	}
	
	public String getMessage() {
		return "ERROR: Negative number entered. A positive number must be entered.";
	}
}
