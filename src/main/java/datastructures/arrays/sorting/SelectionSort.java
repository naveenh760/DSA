package datastructures.arrays.sorting;

public class SelectionSort {
	
	public void sort(int arr[]) {
		int n = arr.length;
		int min_idx;
		for(int i = 0; i < n - 1; i++) {
			min_idx = i;
			for(int j = i+1; j < n; j++) {
				if(arr[j] <= arr[min_idx]) {
					min_idx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;		
		}
		
		
		
	}

}
