package calculator;
import exceptions.NotSupportedOperationException;
import exceptions.DivisionByZeroException;

/**
 * @author Aleksandra Stankoviç
 *
 */
public class Calculator {
	
	private Double currentValue; 
	
	public Calculator() {
		currentValue=0.0;
	}
	
	public Double getCurrentValue()
	{
		return currentValue; 
	}
	
	public void setCurrentValue(Double value)
	{
		currentValue=value; 
	}
	
	/**
	 * This is the method that applies mathematical operation based on parametar operator. 
	 * First operand is currentValue and the second is value.
	 * Based on the value of operator, operations that will be performed are: 
	 * operator = "+" - addition
	 * operator = "-" - substraction
	 * operator = "*" - multipication
	 * operator = "/" - division
	 * Result is placed in currentValue. 
	 * @param value 
	 * @param operator Defines what operation should be performed on value and currentValue. Allowed values are: "+", "-", "*", "/".  
	 * @throws NotSupportedOperationException 
	 */
	public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException
	{
		switch(operator)
		{
			case '+': 
				currentValue+=value; 
				break; 
			case '-': 
				currentValue-=value; 
				break; 
			case '*':
				currentValue*=value; 
				break; 
			case '/':
				if (value == 0)
				{
					throw new DivisionByZeroException();
				}
				currentValue/=value; 
				break;
				default: 
					throw new NotSupportedOperationException();
		}
	}
	

}
