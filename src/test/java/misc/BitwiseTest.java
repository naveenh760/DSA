package misc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import techniques.Bitwise;

class BitwiseTest {

	@ParameterizedTest()
	@CsvSource({"2,2", "4,3", "7, 1", "7, 2", "7,3"})
	void testIsKthSet(int n, int k) {
		assertTrue(Bitwise.isKthSet(n, k));
	}
	
	@ParameterizedTest
	@CsvSource({"2,1,3", "8,4,8", "7,4,15"})
	void testSetKthBit(int n, int k, int expected) {
		assertEquals(expected, Bitwise.setKthBit(n, k));
	}
	
	@ParameterizedTest
	@CsvSource({"8,4,0", "7,3,3"})
	void testClearKthBit(int n, int k, int expected) {
		assertEquals(expected, Bitwise.clearKthBit(n, k));
	}
	
	@ParameterizedTest
	@CsvSource({"8,4,0","0,4,8"})
	void testToggleKthBit(int n , int k, int expected) {
		assertEquals(expected, Bitwise.toggleKthBit(n, k));
	}
	
	@ParameterizedTest
	@CsvSource({"8,0"})
	void testClearRighmostSetBit(int n, int expected) {
		assertEquals(expected, Bitwise.clearRighmostSetBit(n));
	}
}
