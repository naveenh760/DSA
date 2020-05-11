package solvingmethods.dp;

import java.util.Arrays;

public class Combination {

	int MAXN = 1000;
	int[] dp= new int[MAXN];
	
	public Combination() {
		Arrays.fill(dp, -1);
	}
	
	public void reset() {
		Arrays.fill(dp, -1);
	}
	public static void main(String[] args) {
		Combination cb = new Combination();
	    System.out.println(cb.combiRec(4));
	    System.out.println(cb.combiMemo(6));
	    
	    cb.reset();
	    System.out.println(cb.combiTab(6));


	}
		
	/*Given 3 numbers {1, 3, 5}, we need to tell
	the total number of ways we can form a number 'N' 
	using the sum of the given three numbers.  */
	// state(n) = state(n-1) + state(n-3) + state(n-5)
	
	public int combiRec(int n) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		
		return combiRec(n - 1) + combiRec(n - 3) + combiRec(n - 5);
		
	}
	
	public int combiMemo(int n) {
		if(n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		if(dp[n] != -1) {
			return dp[n];
		}
		
		return dp[n] = combiMemo(n - 1) + combiMemo(n - 3) + combiMemo( n - 5);
	}
	
	
	public int combiTab(int n) {
		dp[0] = 1;
		for(int i = 1; i <= n ; i++) {
			int dp_n_1, dp_n_3, dp_n_5;
			if( i - 1 < 0) {
				dp_n_1 = 0;
			}
			else {
				dp_n_1 = dp[i -1];
			}
			
			if( i - 3 < 0) {
				dp_n_3 = 0;
			}
			else {
				dp_n_3 = dp[i - 3];
			}
			
			
			if( i - 5 < 0) {
				dp_n_5 = 0;
			}
			else {
				dp_n_5 = dp[i -5];
			}
			
			dp[i] = dp_n_1 + dp_n_3 + dp_n_5;
		}
		return dp[n];
	}
	
	
	
	

}
