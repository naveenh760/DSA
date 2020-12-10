package datastructures.hashtable;

import java.util.HashMap;
import java.util.Map;

public class StringProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

}
