package datastructures.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayOpsTest {

	@Test
	void testReverseArrayEven() {
		int[] input = {1,2,3,4};
		int[] expected = {4,3,2,1};	
		assertArrayEquals(expected, ArrayOps.reverseArray(input));
	}
	
	@Test
	void testReverseArrayOdd() {
		int[] input = {3,4,1};
		int[] expected = {1,4,3};
		assertArrayEquals(expected, ArrayOps.reverseArray(input));
	}

}
