package solvingmethods.dp.dp1;

import java.util.Arrays;

public class MaxSumAdjacent2N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSum(int arr[][]) {
		int n = arr[0].length;
		return maxSumRec(n - 1, arr);
	}

	private int maxSumRec(int i, int[][] arr) {
		if (i == 0) {
			return Math.max(arr[0][0], arr[1][0]);
		}
		if (i == 1) {
			return Math.max(Math.max(maxSumRec(0, arr), arr[0][1]), arr[1][1]);
		}
		int max1 = Math.max(maxSumRec(i - 2, arr) + arr[0][i], maxSumRec(i - 2, arr) + arr[1][i]);
		return Math.max(maxSumRec(i - 1, arr), max1);
	}

	public int maxSumMemDriver(int arr[][]) {
		int n = arr[0].length;
		int[] lookup = new int[n];
		Arrays.fill(lookup, -1);
		return maxSumMem(n - 1, arr, lookup);
	}

	private int maxSumMem(int i, int[][] arr, int[] lookup) {
		if (lookup[i] == -1) {
			if (i == 0) {
				lookup[0] = Math.max(arr[0][0], arr[1][0]);
			} else if (i == 1) {
				lookup[1] = Math.max(Math.max(maxSumMem(0, arr, lookup), arr[0][1]), arr[1][1]);
			} else {
				int max1 = Math.max(maxSumMem(i - 2, arr, lookup) + arr[0][i],
						maxSumMem(i - 2, arr, lookup) + arr[1][i]);
				lookup[i] = Math.max(maxSumMem(i - 1, arr, lookup), max1);
			}
		}
		return lookup[i];
	}

	public int maxSumTab(int[][] A) {
		int n = A[0].length;
		int[] sum = new int[n];
		sum[0] = Math.max(A[0][0], A[1][0]);
		if (n == 1) {
			return sum[0];
		}
		sum[1] = Math.max(sum[0], Math.max(A[0][1], A[1][1]));
		for (int i = 2; i < n; i++) {
			sum[i] = Math.max(sum[i - 1], Math.max(sum[i - 2] + A[0][i], sum[i - 2] + A[1][i]));
		}
		return sum[n - 1];
	}

}
