package solvingmethods.dp;

import java.util.Arrays;

public class CoinChange {
	
	
	public static int getCountRec(int coins[], int n, int sum) {
		if(sum == 0) {
			return 1;
		}
		if( n == 0) {
			return 0;
		}
		
		int res = getCountRec(coins, n -1, sum);
		if(coins[n - 1] <= sum) {
			res = res + getCountRec(coins, n, sum - coins[n - 1]);
		}
		return res;
	}
	

	public static int getCountTab(int coins[], int n, int sum) {
		int[][] lookup = new int[sum + 1][n +1];
		for(int i=1 ; i <= sum; i++) {
			lookup[i][0] = 0;
		}
		for(int j = 1; j <= n; j++) {
			lookup[0][j] = 1;
		}
		
		for(int i = 1; i <= sum; i++) {
			for(int j = 1; j <= n; j++) {
				lookup[i][j] = lookup[i][j -1];
				if(coins[j -1] <= i) {
					lookup[i][j] += lookup[i - coins[j- 1]][j];
				}
			}
		}
		return lookup[sum][n];
	}
	
	public static int getCount(int coins[], int sum) {
		int n = coins.length;
		int lookup[][] = new int[sum + 1][n + 1];
		for (int[] row : lookup) {
			Arrays.fill(row, -1);
		}
		return getCountMemo(coins,n,sum,lookup);
	}


	private static int getCountMemo(int[] coins, int n, int sum, int[][] lookup) {
		if(lookup[sum][n] == -1) {
			if(sum == 0) {
				lookup[sum][n] = 1;
			}
			else if( n == 0) {
				lookup[sum][n] = 0;
			}
			else {
				int res = getCountMemo(coins, n -1, sum, lookup);
				if(coins[n - 1] <= sum) {
					res = res + getCountMemo(coins, n, sum - coins[n - 1], lookup);
				}
				lookup[sum][n] = res;
			}	
		}
		
		return lookup[sum][n];
	}
}
