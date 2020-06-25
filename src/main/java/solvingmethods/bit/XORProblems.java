package solvingmethods.bit;

public class XORProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findOddNumber(int arr[]) {
		int res = 0;
		for(int element : arr) {
			res = res ^ element;
		}
		return res;
	}
	
	public int findMissing(int arr[]) {
		int n = arr.length;
		int res = 0;
		for(int element: arr) {
			res = res ^ element;
		}
		for(int i = 1; i <= n; i++) {
			res = res ^ i;
		}
		return res;
	}

}
