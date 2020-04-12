package datastructures.algo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algo.sorting.InsertionSort;

class InsertionSortTest {

	@Test
	void testSort() {
		int input[] = {5,4,3,1,2};
		int expected[] = {1,2,3,4,5};
		InsertionSort obj = new InsertionSort();
		obj.sort(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}

}
