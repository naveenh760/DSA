package datastructures.arrays.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void test() {
		int input[] = {5,4,3,1,2};
		int expected[] = {1,2,3,4,5};
		BubbleSort obj = new BubbleSort();
		obj.sort(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}

}
