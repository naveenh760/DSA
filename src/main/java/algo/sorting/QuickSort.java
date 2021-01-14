package algo.sorting;

public class QuickSort {
	
	void quicksortL(int arr[], int low, int high) {
		if(low < high) {
			int pi = partitionLomuto(arr, low, high);
			quicksortL(arr, low, pi - 1);
			quicksortL(arr, pi+ 1, high);
		}
	}

	public int partitionLomuto(int[] arr, int low, int high) {
		int pivot = arr[high];
		int pIndex = low;
		
		for(int j= low; j < high; j++) {
			if(arr[j] <= pivot) {
				swap(arr, pIndex, j);
				pIndex++;
			}
		}
		
		swap(arr, pIndex, high);
		return pIndex;
	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void quicksortL(int arr[]) {
		quicksortL(arr, 0, arr.length - 1);
	}
	
	
	public int partitionNaive(int arr[], int low, int high) {
		int pivot = arr[high];
		int temp[] = new int[high - low + 1];
		int index = 0;
		for(int i = low ; i<= high; i++) {
			if(arr[i] <= pivot) {
				temp[index] = arr[i];
				index++;
			}
		}
		
		int pIndex = index - 1;
		for(int i= low; i <= high; i++) {
			if(arr[i] >pivot) {
				temp[index] = arr[i];
				index++;
			}
		}
		
		for(int i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}
		return pIndex; 
	}
	
	
	public int partitionHoare(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = low - 1;
		int j = high + 1;
		while(true) {
			do {
				i++;
			}while( arr[i] < pivot);
			
			do {
				j--;
			}while( arr[j] > pivot);
			
			if( i >= j) {
				return j;
			}
			
			swap(arr, i, j);
		}
	}
	
	void quicksortH(int arr[], int low, int high) {
		if(low < high) {
			int pi = partitionHoare(arr, low, high);
			quicksortH(arr, low, pi);
			quicksortH(arr, pi+ 1, high);
		}
	}

	public void quicksortH(int arr[]) {
		quicksortH(arr, 0, arr.length - 1);
	}
}
