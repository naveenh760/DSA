package solvingmethods.dp.dp1;

import java.util.Arrays;

public class ClimbStairs {

	public static void main(String[] args) {


	}
	
	// f(n) = f(n-1) + f(n-2)  f(1) = 1, f(2) = 2
	public int climbStairsRec(int A) {
		if(A <= 2) {
			return A;
		}
		return climbStairsRec(A - 1) + climbStairsRec(A - 2);
	}
	
	public int climbStairs(int A) {
		int[] lookup = new int[A + 1];
		Arrays.fill(lookup, -1);
		return climbStairsMem(A,lookup);
	}
	
	private int climbStairsMem(int A, int[] lookup) {
		if(lookup[A] == -1) {
			if(A <= 2) {
				lookup[A] = A;
			}
			else {
				lookup[A] = climbStairsMem(A-1, lookup) + climbStairsMem(A-2, lookup);
			}
			
		}
		return lookup[A];
	}

	public int climbStairsTab(int A) {
        if(A <= 2){
            return A;
        }
        int n = A;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[A];
    }

}
