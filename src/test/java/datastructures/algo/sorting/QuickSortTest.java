package datastructures.algo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algo.sorting.QuickSort;

class QuickSortTest {

	@Test
	void testquickSortL() {
		int input[] = {5,4,3,1,2};
		int expected[] = {1,2,3,4,5};
		QuickSort obj = new QuickSort();
		obj.quicksortL(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testquickSortH() {
		int input[] = {5,4,3,1,2};
		int expected[] = {1,2,3,4,5};
		QuickSort obj = new QuickSort();
		obj.quicksortH(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}

}
