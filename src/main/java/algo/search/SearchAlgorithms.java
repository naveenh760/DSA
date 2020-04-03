package algo.search;

public class SearchAlgorithms {
	
	public static void main(String[] args) {
		int arr[] = {3,4,5,6,1,2};
		int arr1[] = {1,2,3,4};
		System.out.println(searchRotatedSorted(arr, 4));
	}

	public static int linearSearch(int[] array, int element) {
		for(int i=0 ; i < array.length; i++) {
			if(array[i] == element) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static int binarySearch(int[] array, int element) {
		int beg = 0;
		int end = array.length - 1;
		while(beg <= end) {
			int mid = beg + (end- beg) / 2;     // same as (beg + end) /2 - used to avoid overflow
			if( element > array[mid]) {
				beg = mid + 1;
			}
			else if(element < array[mid]) {
				end = mid - 1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}
	
	
	public static int binarySearchRec(int[] array, int element, int beg, int end) {
		if( beg > end) {
			return -1;
		}
		int mid = beg + (end - beg) / 2;
		if(array[mid] == element) {
			return mid;
		}
		else if( element > array[mid]) {
			return binarySearchRec(array, element, mid + 1, end);
		}
		else {
			return binarySearchRec(array, element, beg, mid - 1);
		}
	}
	
	public static int leftIndexBS(int[] array, int element) {
		int beg = 0;
		int end = array.length - 1;
		while(beg <= end) {
			int mid = beg + (end- beg) / 2;     // same as (beg + end) /2 - used to avoid overflow
			if(element == array[mid] && (mid == 0 || array[mid - 1] != element)) {
				return mid;
			}
			else if( element > array[mid]) {
				beg = mid + 1;
			}
			else if(element <= array[mid]) {
				end = mid - 1;
			}
			
		}
		
		return -1;
		
	}
	
	public static int rightIndexBS(int[] array, int element) {
		int n = array.length;
		int beg = 0;
		int end = array.length - 1;
		while(beg <= end) {
			int mid = beg + (end- beg) / 2;     // same as (beg + end) /2 - used to avoid overflow
			if(element == array[mid] && (mid == n - 1 || array[mid + 1] != element)) {
				return mid;
			}
			else if( element >= array[mid]) {
				beg = mid + 1;
			}
			else if(element < array[mid]) {
				end = mid - 1;
			}
			
		}
		
		return -1;	
	}
	
	public static int countOccurences(int[] array, int element) {
		int leftOccur = leftIndexBS(array, element);
		int rightOccur = rightIndexBS(array, element);
		
		if(leftOccur == -1) {
			return 0;
		}
		else {
			return rightOccur - leftOccur + 1;
		}
	}
	
	public static int findInInfArray(int arr[], int x) {
		if(arr[0] == x) {
			return 0;
		}
		int i = 1;
		while(arr[i] < x) {
			i = i * 2;
		}
		
		if(arr[i] == x) {
			return i;
		}
		else { // x < arr[i]
			return binarySearchRec(arr, x, i / 2, i);
		}
	}
	
	
	public static int findPivot(int arr[], int left, int right) {
		if( left > right) {
			return -1;
		}
		if(left == right) {
			return left;
		}
		int mid = left + (right - left)/2;
		if(arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if(arr[mid] < arr[left]) {
			return findPivot(arr, left, mid - 1);
		}
		else {
			return findPivot(arr, mid + 1, right);
		}
		
	}
	
	public static int findPivot(int arr[]) {
		return findPivot(arr, 0, arr.length - 1);
	}
	
	public static int searchRotatedSorted(int arr[], int element) {
		int n = arr.length;
		int pivotIndex = findPivot(arr);
		if(pivotIndex == -1) {
			return binarySearchRec(arr, element, 0, n - 1);
		}
		
		if(arr[pivotIndex] == element) {
			return pivotIndex;
		}
		if( element >= arr[0]) {
			return binarySearchRec(arr, element, 0, pivotIndex - 1);
		}
		return binarySearchRec(arr, element, pivotIndex + 1, n - 1);
	}
	
	public static int findMin(int arr[]) {
		int n = arr.length;
		int maxPos = findPivot(arr);
		if(maxPos == n - 1) {
			return arr[0];
		}
		else {
			return arr[maxPos + 1];
		}
	}
}
