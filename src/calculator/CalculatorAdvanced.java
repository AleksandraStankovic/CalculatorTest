package calculator;
import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

/**
 * @author Aleksandra Stankoviç
 *
 */
public class CalculatorAdvanced extends Calculator {
	
	
	/**
	 * 
	 */
	public CalculatorAdvanced()
	{
		super();
	}
	
	/**Based on the parameter param, certain operation is performed on currentValue. 
	 * @param action Defines what action is performed on currentValue. 
	 * @throws NumberNotInAreaException Throws exception if number is not between 0-9. 
	 * @throws NotSupportedOperationException Throws exception if invalid character is inputed. 
	 */
		public void calculateAdvanced (char action) throws NumberNotInAreaException, NotSupportedOperationException {
			
			if(action >= '0' && action <= '9')
			{
				setCurrentValue(pow(getCurrentValue(), (int)action - '0'));
				return;
			}
			else if (action == '!')
			{
				if(getCurrentValue() >= 0 && getCurrentValue() <= 10)
				
					setCurrentValue(Double.valueOf(factoriel(getCurrentValue().intValue())));
				
				else throw new NumberNotInAreaException();
				
			}
			else throw new NotSupportedOperationException();
			
			
		}
	
	
	/**
	 * Method checks if parameter value is perfect number or Armstrongs number. 
	 * @param value Defines number for which we check if it has ceratin characterisrics. 
	 * @return true if number is a perfect number or Armstrongs number. 
	 * @throws NotSupportedOperationException Throws exceotion if invalid sharacter is inuted. 
	 * @throws NumberNotInAreaException Throws exception if currentValue is negative. 
	 */
	public Boolean hasCharacteristics(char value) throws NotSupportedOperationException, NumberNotInAreaException{
		if(getCurrentValue().intValue()<1)
			throw new NumberNotInAreaException();
		 if(value=='A') {
			return (isArmstrongNumber(getCurrentValue().intValue()));
			
		}
		else if(value=='P')
		{
			
			return (isPerfect(getCurrentValue().intValue()));
			
		}
		else throw new NotSupportedOperationException();
	}
	
	
	 
	/**Method calculates power p of number n.
	 * @param n Number of which we calculate power.
	 * @param p On which power we calculate.
	 * @return Returns power p of n. 
	 */
	public Double pow (Double n, int p)
	{
		 if (p==0)
			return 1.0; 
		else if(p==1)
			return n; 
		else return n*pow(n, p-1);
	}
	
	
	/**Method determines if number is perfect. 
	 * @param number Number which we examine if its perfect number. 
	 * @return Returns true if number if perfect, false if it's not. 
	 */
	public boolean isPerfect(int number)
	{
		if(number==1)
			return false; 
		
		int sum=1;
		
		for(int i=2; i<number; i++)
		{
			if (number%i ==0){
				sum+=i;
			}
		}
	
	
	if(sum==number)
		return true; 
	else
		return false; 
}


	
	/**Method returns number of digits in number n. 
	 * @param x Number for which we determine how many digits it has. Has to be in interval 0-9. 
	 * @return Returns number of digits. 
	 */
	public int order(int x)
	    {
	        int n = 0;
	        while (x != 0) {
	            n++;
	            x = x / 10;
	        }
	        return n;
	    }
	
	/**Method determines if number is Armstrongs number.. 
	 * @param number Number which we examine if its Armstrongs number. 
	 * @return Returns true if number if Armstrongs, false if it's not. 
	 */
	public boolean isArmstrongNumber(int number)
	{
		int n = order(number);
		int temp = number; 
		int sum = 0; 
		
		while (temp!=0)
		{
			int r= temp%10;
			sum+= pow(Double.valueOf(r),n);
			temp = temp/10;
		}
		return (sum==number);
	}
	
	/**Method calculates facotriel of number n. 
	 * @param n Number for which we calculate factoriel. 
	 * @return Returns factoriel of n. 
	 */
	public int factoriel (int n)
	{
		if(n==0 || n==1)
			return 1; 
		else {
		int result=1; 
		for(int i=2; i<=n; i++)
			result*=i; 
		return result; 
	}
	}
	
	
	
}
