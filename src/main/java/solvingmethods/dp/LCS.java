package solvingmethods.dp;

import java.util.Arrays;

public class LCS {

	private static int lcsRec(String s1, String s2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		} else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + lcsRec(s1, s2, m - 1, n - 1);
		} else {
			return Math.max(lcsRec(s1, s2, m, n - 1), lcsRec(s1, s2, m - 1, n));
		}

	}

	static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int lookup[][] = new int[m + 1][n + 1];
		for (int[] row : lookup) {
			Arrays.fill(row, -1);
		}
		return lcsMemo(s1, s2, m, n, lookup);
	}

	private static int lcsMemo(String s1, String s2, int m, int n, int[][] lookup) {
		if (lookup[m][n] == -1) {
			if (m == 0 || n == 0) {
				lookup[m][n] = 0;
			} else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				lookup[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, lookup);
			} else {
				lookup[m][n] = Math.max(lcsMemo(s1, s2, m, n - 1, lookup), lcsMemo(s1, s2, m - 1, n, lookup));
			}

		}
		return lookup[m][n];
	}
	
	
	private static int lcsTab(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int lookup[][] = new int[m + 1][n + 1];
		//Initialize first column to zero
		for(int i = 0; i <= m; i++) {
			lookup[i][0] = 0;
		}
		//Initialize first row to zero
		for(int j = 0; j <= n; j++) {
			lookup[0][j] = 0;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lookup[i][j] = 1 + lookup[i - 1][j - 1];
				}
				else {
					lookup[i][j] = Math.max(lookup[i-1][j], lookup[i][j-1]);
				}
			}
		}
		return lookup[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
