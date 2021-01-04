package recursion.backtrack;

import java.util.ArrayList;

public class Paranthesis {

	public static void main(String[] args) {
		System.out.println(generateParanthesis(3));

	}
	
	public static ArrayList<String> generateParanthesis(int A) {
		ArrayList<String> ans = new ArrayList<String>();
		generateParanthesis(A, "", 0, 0, ans);
		return ans;
	}
	
	public static void generateParanthesis(int A, String current, int cntLeft, int cntRight, ArrayList<String> ans) {
		if(cntLeft < A) {
			generateParanthesis(A, current + "(", cntLeft + 1, cntRight, ans);
		}
		if(cntRight < cntLeft) {
			generateParanthesis(A, current + ")", cntLeft, cntRight + 1, ans);
		}
		if(cntLeft == A && (cntLeft == cntRight)) {
			ans.add(current);
		}
	}
	
}
