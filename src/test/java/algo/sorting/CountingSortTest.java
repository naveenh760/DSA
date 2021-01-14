package algo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountingSortTest {

	@Test
	void testNaiveSort() {
		int input[] = {5,1,3,1,5};
		int expected[] = {1,1,3,5,5};
		CountingSort obj = new CountingSort();
		obj.naiveSort(input, 5);
		int actual[] = input;
		assertArrayEquals(expected, actual);

	}
	
	@Test
	void testCountingSort() {
		int input[] = {5,1,3,1,5};
		int expected[] = {1,1,3,5,5};
		CountingSort obj = new CountingSort();
		obj.countingSort(input, 5);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}

}
