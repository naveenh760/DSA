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
		   ans.add(new ArrayList<String>(current));
		   return;
		}
		for(int j = start; j < n; j++) {
			if(isPalindrome(s, start, j)) {
				current.add(s.substring(start, j + 1));
				partition(j + 1, s, current, ans);
				current.remove(current.size() - 1);
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
