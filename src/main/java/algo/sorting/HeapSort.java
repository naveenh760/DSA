package algo.sorting;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void heapSort(int arr[]) {
		int n = arr.length;
		buildHeap(arr);
		for (int j = n - 1; j >= 1; j--) {
			swap(arr, 0, j);
			heapify(arr, j, 0);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	int left(int i) {
		return 2 * i + 1;
	}

	int right(int i) {
		return 2 * i + 2;
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	void buildHeap(int arr[]) {
		int n = arr.length;
		for (int i = (n - 2) / 2; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	// To Max heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i) {
		// Assumption: Left and right of i is maxheapified
		int lt = left(i);
		int rt = right(i);
		int largest = i;
		if (lt < n && arr[lt] > arr[i]) {
			largest = lt;
		}
		if (rt < n && arr[rt] > arr[largest]) {
			largest = rt;
		}

		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr,n,largest);
		}
	}

}
