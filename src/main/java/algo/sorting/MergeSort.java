package algo.sorting;

public class MergeSort {

 void mergesort(int arr[], int start, int end) {
	 if(start < end) {
		 int mid = (start + end) / 2;
		 mergesort(arr, start , mid);
		 mergesort(arr, mid + 1, end);
		 merge(arr, start, mid, end);
	 }
 }

private void merge(int[] arr, int start, int mid, int end) {
	int temp[] = new int[end - start + 1];
	int i= start, j = mid + 1, k = 0;
	
	while(i <= mid && j <= end) {
		if(arr[i] <= arr[j]) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		else {
			temp[k] = arr[j];
			j++;
			k++;
		}
	}
	
	while(i <= mid) {
		temp[k] = arr[i];
		i++;
		k++;
	}
	while(j <= end) {
		temp[k] = arr[j];
		k++;
		j++;
	}
	for(i = start; i<=end; i++) {
		arr[i] = temp[i -start];
	}
	
}

public void sort(int arr[]) {
	mergesort(arr, 0, arr.length - 1);
}
 
 
}
