package recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(2,3,6,7));
		System.out.println(combinationSumCount(A, 7, 0, 0, 0));
		combinationSum(A, 7);
	}
	
	public static void combinationSum(ArrayList<Integer> A, int B) {
		Collections.sort(A);
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		combinationSum(A, B, 0, 0, currentList, ans);
		System.out.println(ans);
	}
	
	public static int combinationSumCount(ArrayList<Integer> A, int B, int currentIndex, int sum, int count) {
		if(sum > B) {
			return count;
		}
		
		if(sum == B) {
			count++;
		}
		
		for(int i = currentIndex; i < A.size(); i++) {
			sum = sum + A.get(i);
			count = combinationSumCount(A, B, i, sum, count);
			sum = sum - A.get(i);
		}
		return count;
	}
	
	
	public static void combinationSum(ArrayList<Integer> A, int B, int currentIndex, int sum, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> ans) {
		if(sum > B) {
			return;
		}
		
		if(sum == B) {
			ans.add(new ArrayList<Integer>(currentList));
		}
		
		for(int i = currentIndex; i < A.size(); i++) {
			if(i > currentIndex && A.get(i) == A.get(i -1)) {
				continue;
			}
			sum = sum + A.get(i);
			currentList.add(A.get(i));
			combinationSum(A, B, i, sum, currentList, ans);
			sum = sum - A.get(i);
			currentList.remove(currentList.size() - 1);
		}

	}

}
