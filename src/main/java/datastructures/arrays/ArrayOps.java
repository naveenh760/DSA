package datastructures.arrays;

public class ArrayOps {

	
	public static int[] reverseArray(int[] array) {
		int n = array.length;
		for(int i = 0; i < n/2 ; i++) {
			int other = n - 1 - i;
			int temp = array[i];
			array[i] = array[other];
			array[other] = temp;
		}
		return array;
	}
}
