package algo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadixSortTest {

	@Test
	void testRadixSort() {
		int input[] = {5,1,3,1,5};
		int expected[] = {1,1,3,5,5};
		RadixSort obj = new RadixSort();
		obj.radixSort(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testRadixSort1() {
		int input[] = {51,11,30,12,5};
		int expected[] = {5,11,12,30,51};
		RadixSort obj = new RadixSort();
		obj.radixSort(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}
	

}
