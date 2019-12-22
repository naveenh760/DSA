package math.factoring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FactorsTest {

	@ParameterizedTest
	@ValueSource( ints = {2, 3, 5, 11})
	void testIsPrime(int input) {
		assertTrue(Factors.isPrime(input));
	}
	
	@ParameterizedTest
	@ValueSource( ints = {4, 8, 100, 1})
	void testIsPrimeFalse(int input) {
		assertFalse(Factors.isPrime(input));
	}

}
