package math.basic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BasicProbsTest {

	@ParameterizedTest
	@CsvSource({"0,1","3,6"})
	void testFactorial(int input, int expected) {
		assertEquals(expected, BasicProbs.factorial(input));
	}
	
	@ParameterizedTest
	@CsvSource({"0,0", "1,1", "3,2"})
	void testNthFibo(int input, int expected) {
		assertEquals(expected, BasicProbs.nthFibo(input));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0,1,153, 370})
	void testIsArmStrong(int input) {
		assertTrue(BasicProbs.isArmStrong(input));
	}

	@ParameterizedTest
	@ValueSource(ints = {2, 10, 154})
	void testIsArmStrongFalse(int input) {
		assertFalse(BasicProbs.isArmStrong(input));
	}
	
	@ParameterizedTest
	@CsvSource({"16,5,1", "9,3,0"})
	void testMod(int a, int b ,int expected) {
		assertEquals(expected,BasicProbs.mod(a, b));
	}
	
	@ParameterizedTest
	@CsvSource({"10,5,2","11,5,2"})
	void testDivision(int a, int b, int expected) {
		assertEquals(expected, BasicProbs.divide(a, b));
	}
}
