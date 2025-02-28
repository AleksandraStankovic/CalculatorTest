package exceptions; 

public class NotSupportedOperationException extends Exception
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 2190038042825390298L;

	public NotSupportedOperationException() {
		super("Not a supported operation.");
	}
}
