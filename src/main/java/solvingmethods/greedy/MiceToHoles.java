package solvingmethods.greedy;

import java.util.Arrays;

public class MiceToHoles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mice(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int n = A.length;
		int diff = -1;
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			diff = Math.abs(A[i] - B[i]);
			maxDiff = Math.max(maxDiff, diff);
		}
		return maxDiff;
	}

}
