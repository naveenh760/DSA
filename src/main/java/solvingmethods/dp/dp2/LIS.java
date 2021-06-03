package solvingmethods.dp.dp2;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
      int[] arr= {5,6,3,7,9};
      int[] lis = longestIncSubsequence(arr);
      for(int num: lis) {
    	  System.out.println(num);
      }

	}

	int longestIncSubsequenceLen(int arr[]) {
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
	
	
	static int[] longestIncSubsequence(int arr[]) {
		int n = arr.length;
		int llis[] = new int[n];
		int prev[] = new int[n];
		for(int i = 0; i < n; i++) {
			prev[i] = i;
		}
		llis[0] = 1;
		for(int i = 1; i < n;i++) {
			llis[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					if(llis[j] + 1 > llis[i]) {
						llis[i] = llis[j] + 1;
						prev[i] = j;
					}
				}
			}
		}
       int maxPos = -1;
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++) {
    	   if(llis[i] > max) {
    		   max = llis[i];
    		   maxPos = i;
    	   }
       }
       
       int lis[] = new int[max];
       int curPos = maxPos;
       for(int i = max - 1; i >= 0; i--) {
    	   lis[i] = arr[curPos];
    	   curPos = prev[curPos];
       }
       return lis;
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
