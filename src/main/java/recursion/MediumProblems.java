package recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class MediumProblems {

	public static void main(String[] args) {
		powerSet("SAI");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= 3; i++) {
			arr.add(i);
		}
		powerSet(arr);
		System.out.println(sixlet(arr, 2));
		System.out.println(letterCombinations("23"));

	}

	public static void powerSet(String input, int index, String current) {
		if (index == input.length()) {
			System.out.print(current + " ");
			return;
		}

		powerSet(input, index + 1, current + input.charAt(index));
		powerSet(input, index + 1, current);
	}

	public static void powerSet(String input) {
		powerSet(input, 0, "");
	}

	public static void powerSet(ArrayList<Integer> arr, int index, ArrayList<Integer> current) {
		if (index == arr.size()) {
			System.out.println(current + " ");
			return;
		}
		ArrayList<Integer> curExclude = new ArrayList<Integer>(current);
		powerSet(arr, index + 1, curExclude);
		current.add(arr.get(index));
		ArrayList<Integer> curInclude = new ArrayList<Integer>(current);
		powerSet(arr, index + 1, curInclude);

	}

	public static void powerSet(ArrayList<Integer> arr) {
		powerSet(arr, 0, new ArrayList<Integer>());
	}

	public static int sixlet(ArrayList<Integer> arr, int B, int index, int sum, int count, int ans) {
		if (sum > 1000) {
			return ans;
		}
		if (count == B) {
			ans++;
			return ans;
		}
		if (index == arr.size()) {
			return ans;
		}

		return sixlet(arr, B, index + 1, sum + arr.get(index), count + 1, ans)
				+ sixlet(arr, B, index + 1, sum, count, ans);
	}

	public static int sixlet(ArrayList<Integer> arr, int B) {
		return sixlet(arr, B, 0, 0, 0, 0);
	}
	
	
	public static ArrayList<String> letterCombinations(String A) {
		int index = 0;
		HashMap<Character,String> map = new HashMap<Character, String>();
		map.put('2',"abc");
		map.put('3',"def");
		ArrayList<String> ans = letterCombinations(index, A, map);
		return ans;
    }

	private static ArrayList<String> letterCombinations(int index, String A, HashMap<Character, String> map) {
		
		int n = A.length();
		Character curChar = A.charAt(index);
		String letters = map.get(curChar);
		ArrayList<String> ans = new ArrayList<String>();
		if(index == n - 1) {
			for(int i = 0; i < letters.length(); i++) {
				char ch = letters.charAt(i);
				ans.add(String.valueOf(ch));
			}
			return ans;
		}
		
		ArrayList<String> arr = letterCombinations(index + 1, A.substring(index + 1), map);
		for(int i = 0 ; i < letters.length(); i++) {
			char ch = letters.charAt(i);
			for(String s: arr) {
				String newS = String.valueOf(ch).concat(s);
				ans.add(newS);
			}
		}
		
		return ans;
	}

}
