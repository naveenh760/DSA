package algo.sorting;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	void naiveSort(int arr[] ,int range) {
		int n = arr.length;
		int[] count= new int[range + 1];
		Arrays.fill(count, 0);
		for(int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		int index = 0;
		for(int i = 0; i < range + 1; i++) {
			for(int j = 0; j < count[i]; j++) {
				arr[index] = i;
				index++;
			}
		}
	}
	
	void countingSort(int arr[], int range) {
		int n = arr.length;
		int[] count= new int[range + 1];
		Arrays.fill(count, 0);
		for(int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		for(int i = 1; i < range + 1; i++) {
			count[i] = count[i - 1] + count[i];
		}
		
		int[] output = new int[n];
		for(int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for(int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
	
	
	void countingSortDesc(int arr[], int range) {
		int n = arr.length;
		int[] count= new int[range + 1];
		int countArrLen = count.length;
		Arrays.fill(count, 0);
		for(int i = 0; i < n; i++) {
			count[arr[i]]++;
		}
		for(int i = countArrLen - 2; i >= 0; i--) {
			count[i] = count[i - 1] + count[i];
		}
		
		int[] output = new int[n];
		for(int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for(int i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}
	
}
