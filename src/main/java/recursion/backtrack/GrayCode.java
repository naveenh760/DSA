package recursion.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class GrayCode {

	public static void main(String[] args) {
		System.out.println(greyCode(2));

	}
	
	public static ArrayList<Integer> greyCode(int a) {
		char[] chars = new char[a];
		Arrays.fill(chars, '0');
		String first = new String(chars);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Set<String> strings = new LinkedHashSet<String>();
		greyCode(strings,first);
		for(String str: strings) {
			ans.add(Integer.parseInt(str, 2));
		}
		return ans;
	}

	private static void greyCode(Set<String> strings, String current) {
		strings.add(current);
		int n = current.length();
		for(int i = n - 1; i >= 0; i--) {
			if(isFeasible(current,i,strings)) {
				String next = modify(current, i);
				greyCode(strings, next);
			}
		}
	}

	private static String modify(String current, int i) {
		StringBuilder sb = new StringBuilder(current);
		if(sb.charAt(i) == '0') {
			sb.replace(i, i + 1, "1");
		}
		else {
			sb.replace(i, i + 1, "0");
		}
		return sb.toString();
	}

	private static boolean isFeasible(String current, int i, Set<String> strings) {
		if(strings.contains(modify(current, i))){
			return false;
		}
		return true;
	}

}
