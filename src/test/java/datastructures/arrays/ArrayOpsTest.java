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
	
	@Test
	void testLeftRotation() {
		int[] input = {1,2,3,4,5};
		int[] expected = {5,1,2,3,4};
		ArrayOps.leftRotate(input, 4);
		assertArrayEquals(expected, input);
	}
	
	@Test
	void testLeftRotation1() {
		int[] input = {1,2,3,4,5};
		int[] expected = {5,1,2,3,4};
		ArrayOps.leftRotate1(input, 4);
		assertArrayEquals(expected, input);
	}
	
	@Test
	void testLeftRotation2() {
		int[] input = {1,2,3,4,5};
		int[] expected = {5,1,2,3,4};
		ArrayOps.leftRotate2(input, 4);
		assertArrayEquals(expected, input);
	}
	
	@Test
	void testRightRotation() {
		int[] input = {1,2,3,4,5};
		int[] expected = {4,5,1,2,3};
		ArrayOps.rightRotate(input, 2);
		assertArrayEquals(expected, input);
	}
	
	@Test
	void testRightRotation1() {
		int[] input = {1,2,3,4,5};
		int[] expected = {4,5,1,2,3};
		ArrayOps.rightRotate1(input, 2);
		assertArrayEquals(expected, input);
	}
	
	@Test
	void testRemoveDuplicatesSorted() {
		int[] input1 = {1,1,2,3,3};
		int[] input2 = {1,4,5};
		assertEquals(ArrayOps.removeDuplicatesSorted(input1), 3);
		assertEquals(ArrayOps.removeDuplicatesSorted(input2), 3);
	}

}
