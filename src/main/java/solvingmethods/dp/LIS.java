package solvingmethods.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long longestIncSubsequence(int arr[]) {
		int n = arr.length;
		long lcs[] = new long[n];
		lcs[0] = 1;
		for(int i = 1; i < n;i++) {
			lcs[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					lcs[i] = Math.max(lcs[i], lcs[j] + 1);
				}
			}
		}
       return Arrays.stream(lcs).max().getAsLong();
	}
	
	
	long longestIncSubsequenceBS(int arr[]) {
		int n = arr.length;
		ArrayList<Integer> tail = new ArrayList<Integer>();
		tail.add(arr[0]);
		for(int i = 1; i < n; i++) {
			if(arr[i] > tail.get(tail.size() -1)) {
				tail.add(arr[i]);
			}
			else {
				int index = ceilIdx(tail, 0, tail.size() -1, arr[i]);
				tail.remove(index);
				tail.add(index, arr[i]);
			}
		}
		return tail.size();
	}

	private int ceilIdx(ArrayList<Integer> tail, int l, int r, int x) {
		while(l < r) {
			int m = l + (r -l)/2;
			if(x <= tail.get(m)) {
				r = m;
			}
			else {
				l = m + 1;
			}
		}
		return r;
	}

}
