package datastructures.arrays.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void testSort() {
		int input[] = {5,4,3,1,2};
		int expected[] = {1,2,3,4,5};
		MergeSort obj = new MergeSort();
		obj.sort(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}

}
