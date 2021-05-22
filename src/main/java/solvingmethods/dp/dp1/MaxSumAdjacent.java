package solvingmethods.dp.dp1;

import java.util.Arrays;

public class MaxSumAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int maxSum(int arr[]) {
		return maxSumRec(arr.length -1,arr);
	}


	private int maxSumRec(int i, int[] arr) {
		if(i == 0) {
			return arr[0];
		}
		if(i == 1) {
			return Math.max(arr[0], arr[1]);
		}
		return Math.max(maxSumRec(i - 1, arr), maxSumRec(i - 2, arr) + arr[i]);
	}
	
	public int maxSumMemDriver(int arr[]) {
		int n = arr.length;
		int[] lookup = new int[n];
		Arrays.fill(lookup, -1);
		return maxSumMem(n - 1, arr, lookup);
	}


	private int maxSumMem(int i, int[] arr, int[] lookup) {
		if(lookup[i] == -1) {
			if(i == 0) {
				lookup[0] = arr[0];
			}
			if(i == 1) {
				lookup[1] = Math.max(arr[0], arr[1]);
			}
			lookup[i] =  Math.max(maxSumMem(i - 1, arr, lookup), maxSumMem(i - 2, arr, lookup) + arr[i]);	
		}
		return lookup[i];
	}
	
	
	public int maxSumTab(int arr[]) {
		int n = arr.length;
		int[] sum = new int[n];
		sum[0] = arr[0];
		if(n == 1) {
			return sum[0];
		}
		sum[1] = Math.max(arr[0], arr[1]);
		for(int i = 2; i < n; i++) {
			sum[i] = Math.max(sum[i - 1], sum[i - 2] + arr[i]);
		}
		return sum[n - 1];
	}
	

}
