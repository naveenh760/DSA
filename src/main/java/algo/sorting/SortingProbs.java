package algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortingProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minAbsDiff(int[] A) {
		int n = A.length;
		Arrays.sort(A);
		int minAbsDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			int absDiff = Math.abs(A[i] - A[i + 1]);
			minAbsDiff = Math.min(minAbsDiff, absDiff);
		}
		return minAbsDiff;
	}

	public int consecutiveElements(int[] A) {
		int n = A.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Set<Integer> hashset = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			hashset.add(A[i]);
		}
		for (int i = 0; i < n; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		for (int i = min; i <= max; i++) {
			if (!hashset.contains(i)) {
				return 0;
			}
		}
		return 1;
	}

	public int consecutiveElements1(int[] A) {
		int n = A.length;
		Arrays.sort(A);
		for (int i = 1; i < n; i++) {
			if (A[i] - A[i - 1] != 1) {
				return 0;
			}
		}
		return 1;
	}
	
	

}
