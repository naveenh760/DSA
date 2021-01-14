package algo.sorting.problems.comparators;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		int[] arr1 = {2,3,9,0};
		largestNumber(arr1);	
	}
		
	public static String largestNumber(int[] A) {
		int n = A.length;
		String[] strings = new String[n];
		for(int i = 0; i < n; i++) {
			strings[i] = Integer.toString(A[i]);
		}
		
		Arrays.sort(strings, new StringComparator());
		int i;
		for(i = 0; i < n; i++) {
			if(!strings[i].equals("0")) {
				break;
			}		
		}
		if(i == n) {
			i--;
		}
		StringBuilder sb = new StringBuilder();
		for(int j = i; j < n; j++) {
			sb.append(A[j]);
		}
		return sb.toString();
		
	}
}


class StringComparator implements Comparator<String>{

	@Override
	public int compare(String x, String y) {
		String xy = x.concat(y);
		String yx = y.concat(x);
		return yx.compareTo(xy);
	}
	
}
