package algo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BucketSortTest {

	@Test
	void testBucketSortIntArray() {
		int input[] = {5,1,3,1,5};
		int expected[] = {1,1,3,5,5};
		BucketSort obj = new BucketSort();
		obj.bucketSort(input);
		int actual[] = input;
		assertArrayEquals(expected, actual);
	}

}
