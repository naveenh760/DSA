package datastructures.arrays.sorting;

public class QuickSort {
	
	void quicksort(int arr[], int low, int high) {
		if(low < high) {
			int pi = partition(arr, low, high);
			quicksort(arr, low, pi - 1);
			quicksort(arr, pi+ 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int pIndex = low;
		
		for(int j= low; j < high; j++) {
			if(arr[j] <= pivot) {
				int temp = arr[pIndex];
				arr[pIndex] = arr[j];
				arr[j] = temp;
				pIndex++;
			}
		}
		
		int temp = arr[pIndex];
		arr[pIndex] = arr[high];
		arr[high] = temp;
		
		return pIndex;
	}
	
	void sort(int arr[]) {
		quicksort(arr, 0, arr.length - 1);
	}

}
