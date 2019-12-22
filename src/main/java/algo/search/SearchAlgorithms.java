package algo.search;

public class SearchAlgorithms {

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
			int mid = (beg + end) / 2;
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
}
