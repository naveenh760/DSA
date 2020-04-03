package algo.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchAlgorithmsTest {

	@Test
	void testLinearSearch() {
		int[] array = {3,6,1,2};
		int pos = SearchAlgorithms.linearSearch(array, 1);
		assertEquals(2, pos);
	}

	@Test
	void testBinarySearch() {
		int[] array = { 1, 2, 3, 6};
		int pos = SearchAlgorithms.binarySearch(array, 3);
		assertEquals(2, pos);
	}
	
	@Test
    void testBinarySearchNonexistent() {
		int[] array = { 1, 2, 3, 6};
		int pos = SearchAlgorithms.binarySearch(array, 5);
		assertEquals(-1, pos);
	}
	
	@Test
	void testCountOccurences() {
		int[] array = {1,2,2,2,3};
		assertEquals(3, SearchAlgorithms.countOccurences(array, 2));
		assertEquals(1, SearchAlgorithms.countOccurences(array, 3));
		assertEquals(0, SearchAlgorithms.countOccurences(array, 4));
	}
}
