package datastructures.heap;

public class MinHeap {
	int arr[];
	int capacity;
	int size;
	
	public MinHeap(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		size = 0;
	}

	int left(int i) {
		return 2*i + 1;
	}
	
	int right(int i) {
		return 2*i + 2;
	}
	
	int parent(int i) {
		return (i - 1)/2;
	}
	
	public void insert(int x) {
		if(size == capacity) {
			return;
		}
		size++;
		arr[size - 1] = x;
		
		for(int i= size - 1; i != 0 && arr[parent(i)] > arr[i];) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	
	public void minHeapify(int i) {
		//Assumption: Left and right of i is minheapified
		int lt = left(i); 
		int rt = right(i);
		int smallest = i;
		if(lt < size && arr[lt] < arr[i]) {
			smallest = lt;
		}
		if(rt < size && arr[rt] < arr[smallest]) {
			smallest = rt;
		}
		
		if(smallest != i) {
			swap(arr,i,smallest);
			minHeapify(smallest);
		}
	}
	
	public int peek() {
		if(size == 0) {
			return Integer.MAX_VALUE;
		}
		else {
			return arr[0];
		}
	}
	
	public int extractMin() {
		if(size == 0) {
			return Integer.MAX_VALUE;
		}
		else if(size == 1) {
			size--;
			return arr[0];
		}
		
		swap(arr, 0, size - 1);
		size--;
		minHeapify(0);
		return arr[size];	
	}
	
	
	void decreaseKey(int i, int x) {
		arr[i] = x;
		while(i != 0 && arr[parent(i)] > arr[i]) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	
	void deleteKey(int i) {
		if(i >= size) {
			return;
		}
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	void buildHeap() {
		for(int i = (size - 2) / 2; i >= 0; i--) {
			minHeapify(i);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
