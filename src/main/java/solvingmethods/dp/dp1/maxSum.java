package solvingmethods.dp.dp1;

public class maxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSumTab(int[] A, int B, int C, int D) {
		int n = A.length;
		int[][] lookup = new int[n][3];
		lookup[0][0] = B * A[0];
		lookup[0][1] = lookup[0][0] + C*A[0];
		lookup[0][2] = lookup[0][1] + D*A[0];
		
		for(int i = 1; i < n; i++) {
			lookup[i][0] = Math.max(lookup[i -1][0], B * A[i]);
			lookup[i][1] = Math.max(lookup[i - 1][1], lookup[i][0] + C * A[i]);
			lookup[i][2] = Math.max(lookup[i - 1][2], lookup[i][1] + D * A[i]);
		}
		return lookup[ n - 1][2];
	}

}
