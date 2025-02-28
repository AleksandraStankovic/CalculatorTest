package calculator;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;



class CalculatorAdvancedTest {

	public CalculatorAdvanced  calcAdv = new CalculatorAdvanced();
	

	@BeforeEach
	void setUp() throws Exception {
		calcAdv.setCurrentValue(0.0);
	}


	private static Stream<Arguments> orderParams()
	{
		return Stream.of(
				Arguments.of(1234,4),
				Arguments.of(1,1));
	}
	
	@ParameterizedTest
	@MethodSource("orderParams")
	void testOrder(int number, int numOfDigits)
	{
		assertThat(calcAdv.order(number), is(numOfDigits));
	}



	private static Stream<Arguments> hasCharacteristicsArmstrongParams()
	{
		return Stream.of(
				Arguments.of(1634.0, true),
				Arguments.of(1253.0, false));
				
				
	}
	
	
	@ParameterizedTest
	@MethodSource("hasCharacteristicsArmstrongParams")
	void testHasCharacteristicsArmstrong(Double number, Boolean result)
	{
		calcAdv.setCurrentValue(number);
		
		try
		{
			assertThat(calcAdv.hasCharacteristics('A'), is(result));
			
		}
		catch (Exception exception)
		{
			fail("Exception occured.");
			exception.printStackTrace();
		}
		
		
	}
	

	
	
	private static Stream<Arguments> hasCharacteristicPerfectParams() {
		return Stream.of(
				Arguments.of(1.0, false),
				Arguments.of(5.0, false),
				Arguments.of(6.0, true),
				Arguments.of(7.0, false),
				Arguments.of(28.0, true)
		);
	}
	
	@ParameterizedTest
	@MethodSource("hasCharacteristicPerfectParams")
	void testHasCharacteristicPerfect(Double number, Boolean isPerfect) {
		calcAdv.setCurrentValue(number);
		try {
			assertThat(calcAdv.hasCharacteristics('P'), is(isPerfect));
		} catch (Exception ex) {
			fail("Exception occurred.");
			ex.printStackTrace();
		}
	}
	

	private static Stream<Arguments> calculateAdvancedPowerParams()
	{
		return Stream.of(
				
				
				Arguments.of(0.0, '0', 1.0),
				Arguments.of(17.0, '0', 1.0),
				Arguments.of(3.0, '9', 19683.0),
				Arguments.of(1.0, '3', 1.0),
				Arguments.of(-1.0, '3', -1.0),
				Arguments.of(-3.0, '2', 9.0));
	}
	
	
	@ParameterizedTest
	@MethodSource("calculateAdvancedPowerParams")
	void testCalculatorAdvancedPower(Double initialValue, char power, Double result)
	{
		calcAdv.setCurrentValue(initialValue);
		try
		{
			calcAdv.calculateAdvanced(power);
		}catch(Exception exception)
		{
			fail("Exception occured. "); 
			exception.printStackTrace();
		} 
		assertThat(calcAdv.getCurrentValue(), is(result));
	}


private static Stream<Arguments> calculateAdvancedFactorielParams()
{
	return Stream.of(
			Arguments.of('!', 5.0, 120.0), 
			Arguments.of('!', 1.0, 1.0),
			Arguments.of('!', 10.0, 3628800.0),
			Arguments.of('!', 0.0, 1.0)
			
			);
}


@ParameterizedTest
@MethodSource("calculateAdvancedFactorielParams")
void testCalculateAdvancedFactoriel(char option, Double initialValue, Double result)
{
	calcAdv.setCurrentValue(initialValue);
	try
	{
		calcAdv.calculateAdvanced(option);
	}catch(Exception exception)
	{
		fail("Exception occured. "); 
		exception.printStackTrace();
	}
	assertThat(calcAdv.getCurrentValue(), is(result));
}

private static Stream<Arguments> calculateAdvancedNotSupportedOperationExceptionsParams()
{
	return Stream.of(
			Arguments.of('/'),
			Arguments.of('+')
			
			);
}

@ParameterizedTest
@MethodSource("calculateAdvancedNotSupportedOperationExceptionsParams")
void testCalculateAdvancedNotSupportedOperationExceptionsParams(char operation)
{
	assertThrows(
			NotSupportedOperationException.class, 
			() -> calcAdv.calculateAdvanced(operation));
}




private static Stream<Arguments> calculateAdvancedNumberNotInAreaExceptionParams()
{
	return Stream.of(
			Arguments.of(-12.0),
			Arguments.of(12.0)
			
			);
}

@ParameterizedTest
@MethodSource("calculateAdvancedNumberNotInAreaExceptionParams")
void testCalculateAdvancedNumberNotInAreaExceptionParams( Double number)
{
	calcAdv.setCurrentValue(number);
	
	assertThrows(
			NumberNotInAreaException.class, 
			() -> calcAdv.calculateAdvanced('!'));
}




private static Stream<Arguments> hasCharacterisricsNotSupportedOperationExceptionsParams()
{
	return Stream.of(
			Arguments.of('-'),
			Arguments.of('?')
			
			);
}

@ParameterizedTest
@MethodSource("hasCharacterisricsNotSupportedOperationExceptionsParams")
void testHasCharacterisricsNotSupportedOperationExceptionsParams(char operation)
{
	calcAdv.setCurrentValue(8.0);
	assertThrows(
			NotSupportedOperationException.class, 
			() -> calcAdv.hasCharacteristics(operation));
}

private static Stream<Arguments> hasCharacterisricsNumberNotInAreaExceptionsParams()
{
	return Stream.of(
			Arguments.of(-5.0),
			Arguments.of(0.0),
			Arguments.of(0.7)
			
			);
}

@ParameterizedTest
@MethodSource("hasCharacterisricsNumberNotInAreaExceptionsParams")
void testHasCharacterisricsNumberNotInAreaExceptionsParams(Double value)
{
	calcAdv.setCurrentValue(value);
	assertThrows(
			NumberNotInAreaException.class, 
			() -> calcAdv.hasCharacteristics('A'));
}


}

