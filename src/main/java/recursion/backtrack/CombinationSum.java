package recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationSum {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(1,1,2,3));
	//	System.out.println(combinationSumCount(A, 7, 0, 0, 0));
	//	combinationSum(A, 7);
		combinationSumDup(A, 3);
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
			return;
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
	
	
	public static void combinationSumDup(ArrayList<Integer> arr, int B) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> freqArr = getFrequency(arr);
		combinationSumDup(freqArr, 0, new ArrayList<Integer>() , ans,0, B);
		System.out.println(ans);
		
	}

	static ArrayList<ArrayList<Integer>> getFrequency(ArrayList<Integer> arr) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int num: arr) {
			if(freqMap.containsKey(num)) {
				freqMap.put(num,freqMap.get(num) + 1);
			}
			else {
				freqMap.put(num, 1);
			}
		}
		Set<Integer> keys = freqMap.keySet();
		ArrayList<Integer> keysArr = new ArrayList<Integer>(keys);
		Collections.sort(keysArr);
		ArrayList<ArrayList<Integer>> freqArr = new ArrayList<ArrayList<Integer>>();
		for(int key: keysArr) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(key);
			temp.add(freqMap.get(key));
			freqArr.add(temp);
		}
		return freqArr;
	}

	private static void combinationSumDup(ArrayList<ArrayList<Integer>> freqArr, int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> ans, int sum, int B) {
		if(sum > B) {
			return;
		}
		if(sum == B) {
			ans.add(new ArrayList<Integer>(current));
			return;
		}
		if(index == freqArr.size()) {
			return;
		}
		int key = freqArr.get(index).get(0);
		int freq = freqArr.get(index).get(1);
		for(int i = 0; i <= freq; i++) {
			for(int j = 0; j < i; j++) {
				current.add(key);
				sum = sum + key;
			}
			combinationSumDup(freqArr,index + 1,current, ans,sum , B);
			for(int j = 0; j < i; j++) {
				int ind = current.size() - 1;
				int lastNum = current.get(ind);
				current.remove(ind);
				sum = sum - lastNum;
			}
		}
		
	}



}
