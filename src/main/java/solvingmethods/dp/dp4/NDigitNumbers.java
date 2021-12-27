package solvingmethods.dp.dp4;

import java.util.Arrays;

public class NDigitNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int nDigitRec(int n, int sum) {
		if(sum < 0) {
			return 0;
		}
		if(n == 0 && sum == 0) {
			return 1;
		}
		if(n == 0 || sum == 0) {
			return 0;
		}
		int cnt = 0;
		for(int x = 0; x <= 9; x++) {
			cnt += nDigitRec(n - 1, sum - x);
		}
		return cnt;
	}
	
	
	public int nDigit(int n, int sum) {
		int[][] lookup = new int[ n + 1][sum + 1];
		for (int[] row : lookup) {
			Arrays.fill(row, -1);
		}
		return nDigitMem(n,sum, lookup);
	}
	
	private int nDigitMem(int n, int sum, int[][] lookup) {
		int mod = (int) Math.pow(10, 9) + 7;
		if(lookup[n][sum] == -1) {
			if(n == 0 && sum == 0) {
				lookup[n][sum] = 1;
			}
			else if(n == 0 || sum == 0) {
				lookup[n][sum] =  0;
			}
			else {
				int cnt = 0;
				for(int x = 0; x <= 9; x++) {
					if(sum - x >= 0) {
						cnt = ((cnt % mod) + nDigitMem(n - 1, sum - x, lookup) % mod ) % mod;
					}
				}
				lookup[n][sum] =  cnt;
			}
		}
		return lookup[n][sum];
	}


	public int nDigitNumTab(int n, int sum) {
		int mod = (int) Math.pow(10, 9) + 7;
		int rows = n + 1;
		int cols = sum + 1;
		int[][] lookup = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if( i == 0 && j == 0) {
					lookup[i][j] = 1;
				}
				else if(i == 0 || j == 0) {
					lookup[i][j] = 0;
				}
				else {
					int start = 0;
					for(int x = start; x <= 9; x++) {
						if(j - x >= 0) {
							lookup[i][j] = (lookup[i][j] % mod) +  (lookup[i - 1][j - x] % mod);
							lookup[i][j] = lookup[i][j] % mod;
						}
					}
				}
			}
		}
		return lookup[n][sum] % mod;
	}

}
