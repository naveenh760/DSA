package algo.sorting.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class GameOfBottles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int gameOfBottles(ArrayList<Integer> A) {
		int ans = 0;
		Map<Integer, Integer> freqMap = getFrequencyMap(A);
		while (!freqMap.isEmpty()) {
			int minFreq = findMinFreq(freqMap);
			for (int num : freqMap.keySet()) {
				int curFreq = freqMap.get(num);
				freqMap.put(num, curFreq - minFreq);
			}
			freqMap.entrySet().removeIf(entry -> (0 == entry.getValue()));
			ans = ans + minFreq;
		}
		return ans;
	}
	
	public int gameOfBottles1(ArrayList<Integer> A) {
    	Map<Integer, Integer> freqMap = getFrequencyMap(A);
    	return findMaxFreq(freqMap);
    }
	
	public int gameOfBottles2(ArrayList<Integer> A) {
    	Collections.sort(A);
    	return findMaxFreq(A);
    }
	
	private int findMaxFreq(ArrayList<Integer> A) {
		int n = A.size();
		int curFreq = 1;
		int maxFreq = curFreq;
		for(int i = 1; i < n; i++) {
			if(A.get(i).intValue() == A.get(i - 1).intValue()) {
				curFreq++;
			}
			else {
				maxFreq = Math.max(maxFreq, curFreq);
				curFreq = 1;
			}
		}
		maxFreq = Math.max(maxFreq, curFreq);
		return maxFreq;
	}

	private int findMaxFreq(Map<Integer, Integer> freqMap) {
		int maxFreq = Integer.MIN_VALUE;
		for(int freq:freqMap.values()) {
			maxFreq = Math.max(maxFreq, freq);
		}
		return maxFreq;
	}
	

	private int findMinFreq(Map<Integer, Integer> freqMap) {
		int minFreq = Integer.MAX_VALUE;
		for (int freq : freqMap.values()) {
			minFreq = Math.min(minFreq, freq);
		}
		return minFreq;
	}

	private Map<Integer, Integer> getFrequencyMap(ArrayList<Integer> A) {
		Map<Integer, Integer> freqMap = new TreeMap<Integer, Integer>();
		for (int num : A) {
			if (freqMap.containsKey(num)) {
				freqMap.put(num, freqMap.get(num) + 1);
			} else {
				freqMap.put(num, 1);
			}
		}
		return freqMap;
	}

}
