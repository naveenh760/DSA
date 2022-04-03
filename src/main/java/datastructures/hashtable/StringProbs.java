package datastructures.hashtable;

import java.util.*;

public class StringProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "p";
		String B = "pqpsp";
		System.out.println(permutation(A,B));

	}
	
	
	public int solve(int A, String B) {
		int n = B.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < n; i++) {
			Character ch = B.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			}
			else {
				map.put(ch,1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			int value = entry.getValue();
			if(value % A != 0) {
				return -1;
			}
		}
		return 1;
    }

	public static int permutation(String A, String B) {
		int N = A.length();
		int M = B.length();
		int count = 0;
		Map<Character, Integer> freqMapA = new HashMap<>();
		for(int i = 0; i < N; i++) {
			char ch = A.charAt(i);
			freqMapA.merge(ch,1,Integer::sum);
		}

		Map<Character, Integer> freqMapBWin = new HashMap<>();
		for(int i = 0; i < N; i++) {
			char ch = B.charAt(i);
			freqMapBWin.merge(ch,1,Integer::sum);
		}
		if(freqMapA.equals(freqMapBWin)) {
			count++;
		}

		for(int j = N; j < M; j++) {
			char curChar = B.charAt(j);
			char prevWinChar = B.charAt(j - N);
			freqMapBWin.merge(curChar,1,Integer::sum);
			freqMapBWin.put(prevWinChar, freqMapBWin.get(prevWinChar) - 1);
			if(freqMapBWin.get(prevWinChar) == 0){
				freqMapBWin.remove(prevWinChar);
			}
			if(freqMapA.equals(freqMapBWin)) {
				count++;
			}
		}

		return count;
	}

	boolean compareFrequencyMaps(Map<Integer,Integer> map1, Map<Integer,Integer> map2){
		return false;
	}

	public int lengthOfLongestSubstring(String A) {
		int start = 0;
		int end = -1;
		int n = A.length();
		int maxLength = Integer.MIN_VALUE;
		HashMap<Character,Integer> indexMap = new HashMap<>();
		for(int i = 0; i < n; i++){
			char ch = A.charAt(i);
			if(indexMap.containsKey(ch)){
				start = Math.max(indexMap.get(ch) + 1,start);
			}
			indexMap.put(ch,i);
			end++;
			maxLength = Math.max(end -start + 1,maxLength);
		}
		return maxLength;
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		int n = A.size();
		A.replaceAll(str -> sortString(str));
		LinkedHashMap<String,ArrayList<Integer>> indexMap = new LinkedHashMap<>();
		for(int i = 0; i < n;i++){
			String str = A.get(i);
			if(indexMap.containsKey(str)){
				ArrayList<Integer> list = indexMap.get(str);
				list.add(i + 1);
			}
			else{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i + 1);
				indexMap.put(str,list);
			}
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>(indexMap.values());
		return ans;
	}

	public String sortString(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}






}
