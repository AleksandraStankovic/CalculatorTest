package calculator;

import static org.junit.jupiter.api.Assertions.*;


import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;



import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

class CalculatorTest {

	private Calculator calculator = new Calculator();
	
	@BeforeEach
	void setUp() throws Exception {
		calculator.setCurrentValue(0.0);
	}
	
	
	@Test
	void testCalculator()
	{
		Calculator calculator1= new Calculator();
		assertThat(calculator1.getCurrentValue(), is(0.0));
	}
	
	
	
	private static Stream<Arguments> setCurrentValueParams ()
	{
		return Stream.of(
				Arguments.of(null, null),
				Arguments.of(5.0, 5.0), 
				Arguments.of(-3.0, -3.0));		
				
	}
	
	@ParameterizedTest
	@MethodSource("setCurrentValueParams")
	void testSetCurrentValue(Double valueToSet, Double expectedValue)
	{
		calculator.setCurrentValue(valueToSet);
		assertThat(calculator.getCurrentValue(), is(expectedValue));
		
	}
	
	
	private static Stream<Arguments> calculateParams()
	{
		return Stream.of(
				Arguments.of(7.0, 4.1, '+', 11.1),
				Arguments.of(7.0, 0.0, '+', 7.0),
				Arguments.of(7.0, 0.0, '-', 7.0),
				Arguments.of(7.0, 2.0, '-', 5.0),
				Arguments.of(7.0, 8.0, '-', -1.0),
				Arguments.of(7.0, 8.0, '*', 56.0),
				Arguments.of(7.0, 0.0, '*', 0.0),
				Arguments.of(7.0, 1.0, '*', 7.0),
				Arguments.of(70.0, 10.0, '/', 7.0),
				Arguments.of(10.0, 2.5, '/', 4.0),
				Arguments.of(7.0, 10.0, '/', 0.7));
				
				
		
	}
	
	@ParameterizedTest
	@MethodSource("calculateParams")
	void testCalculate (Double currentValue, Double value, char operator, Double expectedValue)
	{
		calculator.setCurrentValue(currentValue);
		
		try {
			calculator.calculate(value, operator);
		} catch (Exception exeption) {
			fail("Exception occurred.");
			exeption.printStackTrace();
		}
		
		assertThat(calculator.getCurrentValue(),is(expectedValue));
	}
	
	
	@Test
	void testDivisionByZeroException()
	{
		assertThrows(
				
				DivisionByZeroException.class, () -> calculator.calculate(0.0, '/'));
				
	}
	
	
	
	private static Stream<Arguments> notSupportedOperationParams()
	{
		return Stream.of(
				Arguments.of('%'),
				Arguments.of('a'));
	}
	
	@ParameterizedTest
	@MethodSource ("notSupportedOperationParams")
	void testNotSupportedOperationException (char operator)
	{
		assertThrows(
				NotSupportedOperationException.class, () -> calculator.calculate(4.0, operator)
				);
		
	}
	
	
	

}
