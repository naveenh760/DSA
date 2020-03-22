package datastructures.arrays;

public class TwoPointer {

	public static boolean isPairSum(int arr[], int X) {
		int n = arr.length;
		boolean found = false;
		int l = 0;
		int r = n - 1;
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
	
}
