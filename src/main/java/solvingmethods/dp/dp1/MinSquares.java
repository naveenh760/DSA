package solvingmethods.dp.dp1;

import java.util.Arrays;

public class MinSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int countMinSquaresRec(int A) {
		if(A == 0) {
			return 0;
		}
		int min = A;
		for(int x = 1; x * x <= A; x++) {
			min = Math.min(countMinSquaresRec(A - x * x), min);
		}
		return min + 1;
	}
	
	
	
	public int countMinSquares(int A) {
		int[] lookup = new int[A + 1];
		Arrays.fill(lookup, -1);
		return countMinSquaresMem(A,lookup);
	}
	
	
	
	
	private int countMinSquaresMem(int A, int[] lookup) {
		if(lookup[A] == -1) {
			if(A == 0) {
				lookup[0] = 0;
			}
			else {
				int min = A;
				for(int x = 1; x * x <= A; x++) {
					min = Math.min(countMinSquaresMem(A - x * x, lookup), min);
				}
				lookup[A] = min + 1;
			}
			
		}
		return lookup[A];
	}


	public int countMinSquaresTab(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 0;
        for(int i = 1; i <= A; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        
        return dp[A];
    }

}
