package es.upm.grise.profundizacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	private void initialization() {
		calculator = new Calculator();
		calculator.numbers = new Vector<> ();
		double[] calculatorValues = {7,9,0,1,6,5,4,5,2,5};
		for (int i = 0; i<calculatorValues.length; i++) {
			calculator.add(calculatorValues[i]);
		}
	}

	@Test
	@DisplayName("Testing add method: Multiple additions")
	public void addMultipleValues() {
		int originalSize = calculator.numbers.size();
		calculator.add(52.4);
		calculator.add(57.9);
		calculator.add(91.25);
		int newSize = originalSize + 3;
		//assertEquals(newSize, calculator.numbers.size());
		assertEquals(newSize, calculator.numbers.size(), () -> "The size of the vector: " + calculator.numbers.size() + " is not the same as the expected size: " + newSize );
	}

	@Test
	@DisplayName("Testing remove method: Removing only the last index of a value")
	public void removeLastIndexOfValue () {
		double value = 5;
		int lastIndex = calculator.numbers.lastIndexOf(value);
		calculator.remove(value);
		assertTrue(calculator.numbers.contains(value), () -> "There are still one more index of the value removed");
		assertNotEquals(lastIndex, calculator.numbers.lastIndexOf(value), () -> "That existing index is different from the original last index that has been removed");
	}

	@Test
	@DisplayName("Testing max method: Existing max value")
	public void alreadyExistingMaxValue () {
		double max = 9;
		assertEquals(max, calculator.max(), () -> "The value is the max from all the collection");
	}

	@Test
	@DisplayName("Testing min method: Existing min value")
	public void alreadyExistingMinValue () {
		double min = 0;
		assertEquals(min, calculator.min(), () -> "The value is the min from all the collection");
	}

	@Test
	@DisplayName("Testing average method: Calculating the average")
	public void calculatingAverage () {
		double average = 4.4;
		assertEquals(calculator.average(), average, () -> "The average calculated by the method is correct with the collection of numbers given");
	}

	@Test
	@DisplayName("Testing stddev method: Calculating the standard average")
	public void calculatingStandardAverage () {
		double stddev = 7.6000000000000005;
		assertEquals(stddev, calculator.stddev(), () -> "The standard average calculated by the method is correct with the collection of numbers given");
	}

}
