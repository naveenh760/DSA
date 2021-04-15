package datastructures.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KadaneTest {

	@Test
	void testMaxSubArraySumK() {
		int arr[] = {5,-1,3,-5,2};
		int expected = 7;
		assertEquals(expected, Kadane.maxSubArraySumK(arr));
		
	}

	@Test
	void testMaxSubArraySumK1() {
		int arr[] = {5,-1,3,-5,2};
		int expected = 7;
		assertEquals(expected, Kadane.maxSubArraySumK(arr));
	}

}
