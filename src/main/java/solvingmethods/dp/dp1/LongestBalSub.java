package solvingmethods.dp.dp1;

public class LongestBalSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int LongestBalSubRec(String str, int i, int leftS, int leftN, int leftF) {
		if(i == 0) {
			return 0;
		}
		if(str.charAt(i- 1) == ']') {
			if(leftS > 0) {
				leftS--;
				return LongestBalSubRec(str, i - 1, leftS, leftN, leftF) + 2;
			}
			else {
				return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
			}
			
		}
		else if(str.charAt(i - 1) == ')') {
			if(leftN > 0) {
				leftN--;
				return LongestBalSubRec(str, i - 1, leftS, leftN, leftF) + 2;
			}
			else {
				return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
			}
		}
		else if(str.charAt(i - 1) == '}') {
			if(leftF > 0) {
				leftF--;
				return LongestBalSubRec(str, i - 1, leftS, leftN, leftF) + 2;
			}
			else {
				return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
			}
		}
		else if(str.charAt(i - 1) == '[') {
			leftS++;
			return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
		}
		else if(str.charAt(i - 1) == '(') {
			leftN++;
			return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
		}
		else if(str.charAt(i - 1) == '{') {
			leftF++;
			return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
		}
		else {
			return LongestBalSubRec(str, i - 1, leftS, leftN, leftF);
		}
	}
	
	
	public int longestBalSubTab(String str) {
		int n = str.length();
		int leftS = 0;
		int leftN = 0;
		int leftF = 0;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			if(str.charAt(i- 1) == ']') {
				if(leftS > 0) {
					leftS--;
					dp[i] = dp[i - 1] + 2;
				}
				else {
					dp[i] = dp[i - 1];
				}
				
			}
			else if(str.charAt(i - 1) == ')') {
				if(leftN > 0) {
					leftN--;
					dp[i] = dp[i - 1] + 2;
				}
				else {
					dp[i] = dp[i - 1];
				}
			}
			else if(str.charAt(i - 1) == '}') {
				if(leftF > 0) {
					leftF--;
					dp[i] = dp[i - 1] + 2;
				}
				else {
					dp[i] = dp[i - 1];
				}
			}
			else if(str.charAt(i - 1) == '[') {
				leftS++;
				dp[i] = dp[i - 1];
			}
			else if(str.charAt(i - 1) == '(') {
				leftN++;
				dp[i] = dp[i - 1];
			}
			else if(str.charAt(i - 1) == '{') {
				leftF++;
				dp[i] = dp[i - 1];
			}
		}
		return dp[n];
	}

}
