package solvingmethods.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int longestIncSubsequence(int arr[]) {
		int n = arr.length;
		int llis[] = new int[n];
		llis[0] = 1;
		for(int i = 1; i < n;i++) {
			llis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					llis[i] = Math.max(llis[i], llis[j] + 1);
				}
			}
		}
       return Arrays.stream(llis).max().getAsInt();
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
