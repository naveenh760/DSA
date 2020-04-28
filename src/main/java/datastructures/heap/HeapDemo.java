package datastructures.heap;

import java.util.Arrays;

public class HeapDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		swap(arr,0,3);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
