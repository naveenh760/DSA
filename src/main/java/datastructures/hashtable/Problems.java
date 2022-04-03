package datastructures.hashtable;

import java.util.*;

public class Problems {

	public static void main(String[] args) {
		String A = "p";
		String B = "pabc";

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

		ArrayList<Integer> result1 = new ArrayList<>();
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

	public ArrayList<Integer> sortInOrder(ArrayList<Integer> A, ArrayList<Integer> B) {
		Map<Integer, Integer> mapFreq = new TreeMap<>();
		getFrequency(A,mapFreq);
		ArrayList<Integer> result = new ArrayList<>();
		for (int num : B) {
			addToResult(mapFreq, result, num);
			mapFreq.remove(num);
		}
		for(int num: mapFreq.keySet()){
			addToResult(mapFreq,result,num);
		}

		return result;
	}

	public void getFrequency(List<Integer> input, Map<Integer,Integer> freqMap){
		for (Integer num : input) {
			freqMap.merge(num, 1, Integer::sum);
		}
	}

	private void addToResult(Map<Integer, Integer> mapFreq, ArrayList<Integer> result1, int num) {
		if (mapFreq.containsKey(num)) {
			int freq = mapFreq.get(num);
			for (int i = 1; i <= freq; i++) {
				result1.add(num);
			}
		}
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



	public int minDistancePair(int[] A) {
		int n = A.length;
		int result = n;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++){
			if(map.containsKey(A[i])){
				result = Math.min(result, i - map.get(A[i]));
			}
			map.put(A[i], i);
		}
		return (result == n) ? - 1 : result;
	}
	
	

}
