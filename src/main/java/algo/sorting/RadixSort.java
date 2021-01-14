package algo.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	void radixSort(int arr[]) {
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, arr[i]);
		}
		for(int pos = 1; max / pos > 0; pos = pos * 10) {
			countingSort(arr,pos);
		}
	}

	private void countingSort(int[] arr, int pos) {
		int n = arr.length;
		int[] count= new int[10];
		Arrays.fill(count, 0);
		for(int i = 0; i < n; i++) {
			count[(arr[i] / pos) % 10]++;
		}
		for(int i = 1; i < 10; i++) {
			count[i] = count[i - 1] + count[i];
		}
		
		int[] output = new int[n];
		for(int i = n - 1; i >= 0; i--) {
			int currentDigit = (arr[i] / pos) % 10;
			output[count[currentDigit] - 1] = arr[i];
			count[currentDigit]--;
		}
		for(int i = 0; i < n; i++) {
			arr[i] = output[i];
		}

		
	}
	
	
	

}
