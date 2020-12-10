package datastructures.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problems {

	public static void main(String[] args) {
		String A = "p";
		String B = "pabc";
		System.out.println(solve(A,B));

	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		Set<Integer> setB = new HashSet<Integer>();
		for (int num : B) {
			setB.add(num); // O(|B| time, O(|B|) space
		}

		Map<Integer, Integer> mapFreq = new HashMap<Integer, Integer>();
		for (int num : A) { // O(|A| time, O(|A| space
			if (setB.contains(num)) {
				if (mapFreq.containsKey(num)) {
					mapFreq.put(num, mapFreq.get(num) + 1);
				} else {
					mapFreq.put(num, 1);
				}
			}

		}

		ArrayList<Integer> result1 = new ArrayList<Integer>();
		for (int num : B) { // O(|A| time, O(|A| space
			if (mapFreq.containsKey(num)) {
				int freq = mapFreq.get(num);
				for (int i = 1; i <= freq; i++) {
					result1.add(num);
				}
			}
		}

		ArrayList<Integer> result2 = new ArrayList<Integer>();
		for (int num : A) { // O(|A| time, O(|A| space
			if (!setB.contains(num)) {
				result2.add(num);
			}
		}
		Collections.sort(result2);
		result1.addAll(result2);

		return result1;
	}

	public int colorful(int A) {
		String str = Integer.toString(A);
		Set<Integer> set = new HashSet<Integer>();
		int n = str.length();
		for (int i = 0; i < n; i++) {
			int prod = 1;
			for (int j = i; j < n; j++) {
				prod = prod * (str.charAt(j) - '0');
				if (set.contains(prod)) {
					return 0;
				}
				set.add(prod);

			}
		}
		return 1;

	}

	public static int solve(String A, String B) {
		int N = A.length();
		int M = B.length();
		int count = 0;
		Map<Character, Integer> freqMapA = new HashMap<Character, Integer>();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			freqMapA.put(ch,0);
		}
		
		for(int i = 0; i < N; i++) {
			char ch = A.charAt(i);
			freqMapA.put(ch, freqMapA.get(ch) + 1);
		}
		
		
		
		Map<Character, Integer> freqMapBWin = new HashMap<Character, Integer>();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			freqMapBWin.put(ch,0);
		}
		
		for(int i = 0; i < N; i++) {
			char ch = B.charAt(i);
			freqMapBWin.put(ch, freqMapBWin.get(ch) + 1);
		}
		
		if(freqMapA.equals(freqMapBWin)) {
			count++;
		}
		
		for(int j = N; j < M; j++) {
			char curChar = B.charAt(j);
			char prevWinChar = B.charAt(j - N);
			freqMapBWin.put(curChar, freqMapBWin.get(curChar) + 1);
			freqMapBWin.put(prevWinChar, freqMapBWin.get(prevWinChar) - 1);
			if(freqMapA.equals(freqMapBWin)) {
				count++;
			}
		}
		
		return count;
	}
	
	

}
