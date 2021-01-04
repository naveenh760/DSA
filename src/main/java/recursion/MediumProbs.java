package recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class MediumProbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("231"));
		letterPhone("231");

	}
	
	public static ArrayList<String> letterCombinations(String A) {
		HashMap<Character, String> map = populateMap();
		ArrayList<String> ans = letterCombinations(A, map);
		return ans;
	}

	static HashMap<Character, String> populateMap() {
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('0',"0");
		map.put('1',"1");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		return map;
	}

	
	private static ArrayList<String> letterCombinations(String A, HashMap<Character, String> map) {

		int n = A.length();
		if(n == 0) {
			return null;
		}
		Character curChar = A.charAt(0);
		String letters = map.get(curChar);
		ArrayList<String> ans = new ArrayList<String>();
		
		if (n == 1) {
			for (int i = 0; i < letters.length(); i++) {
				char ch = letters.charAt(i);
				ans.add(String.valueOf(ch));
			}
			return ans;
		}

		ArrayList<String> arr = letterCombinations(A.substring(1), map);
		for (int i = 0; i < letters.length(); i++) {
			char ch = letters.charAt(i);
			for (String s : arr) {
				String newS = String.valueOf(ch).concat(s);
				ans.add(newS);
			}
		}

		return ans;
	}
	
	
	public static void letterPhone(String A) {
		HashMap<Character, String> map = populateMap();
		ArrayList<String> ans = new ArrayList<String>();
		letterPhone(A, "", map, 0,ans);
		System.out.println(ans);
	}
	
	
	public static void letterPhone(String A, String current, HashMap<Character, String> map, int index, ArrayList<String> ans) {
		if(index == A.length()) {
			ans.add(current);
			return;
		}
		char curChar = A.charAt(index);
		String curMapping = map.get(curChar);
		for(int i = 0; i < curMapping.length(); i++) {
			letterPhone(A, current + curMapping.charAt(i), map, index + 1, ans);
		}
	}


}
