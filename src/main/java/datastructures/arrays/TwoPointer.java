package datastructures.arrays;

public class TwoPointer {

	public static boolean isPairSumSorted(int arr[], int X, int l , int r) {
		boolean found = false;
		while(l < r) {
			if(arr[l] + arr[r] == X) {
				found = true;
			}
			else if(arr[l] + arr[r] > X) {
				r--;
			}
			else {
				l++;
			}
		}
		return found;
	}
	
	public static boolean isPairSumSorted(int arr[], int x) {
		int n = arr.length;
		int l = 0, r = n - 1;
		return isPairSumSorted(arr, x, l, r);
	}
	
	public static boolean isTripletSumSorted(int arr[], int x) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(isPairSumSorted(arr, x - arr[i], i + 1, n - 1)) {
				return true;
			}
		}
		return false;
	}
	
}
