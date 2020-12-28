package recursion.backtrack;

import java.util.ArrayList;

public class PalindromePartition {

	public static void main(String[] args) {
		String s = "aab";
		ArrayList<ArrayList<String>> ans = partition(s);
		System.out.println(ans);
	}
	
	public static ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		ArrayList<String> current = new ArrayList<String>();
		partition(0,a,current, ans);
		return ans;
	}
	
	static void partition(int start, String s, ArrayList<String> current, ArrayList<ArrayList<String>> ans) {
		int n = s.length();
		if(start == n) {
		   ans.add(current);
		   return;
		}
		for(int j = start; j < n; j++) {
			if(isPalindrome(s, start, j)) {
				ArrayList<String> current1 = new ArrayList<String>(current);
				current1.add(s.substring(start, j + 1));
				partition(j + 1, s, current1, ans);
			}
		}
		
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
