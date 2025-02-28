package exceptions;

public class NumberNotInAreaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4851424922779119810L;

	public NumberNotInAreaException ()
	{
		super("Current value is not in range [0, 10]. ");
	}
	

}
