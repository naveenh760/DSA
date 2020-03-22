package math.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DivisionTest {

	@ParameterizedTest
	@CsvSource({"1,1","14,2","132,3"})
	void testCountDigits(int input, int expected) {
		assertEquals(expected, Division.countDigits(input));
	}

	@ParameterizedTest
	@CsvSource({"1,1","14,2","132,3"})
	void testCountDigitsLog(int input, int expected) {
	  assertEquals(expected, Division.countDigitsLog(input));
	}

}
