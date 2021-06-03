package solvingmethods.dp.dp2;

public class UniquePaths {
	
	
	public int uniquePaths(int[][] A) {
		 int i = A.length - 1;
	        int j = A[0].length - 1;
	        return uniquePathsRec(A,i,j);
	}
	
	
	public int uniquePathsRec(int[][] A, int i, int j) {
		if(A[i][j] == 1) {
			return 0;
		}
		if(i == 0 && j == 0) {
			if(A[i][j] != 1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			int top = 0, left = 0;
			if(i != 0 && A[i - 1][j] != 1) {
				top = uniquePathsRec(A, i - 1, j);
			}
			if(j != 0 && A[i][j - 1] != 1) {
				left = uniquePathsRec(A, i, j - 1);
			}
			return top + left;
		}
	}
	
	
	public int uniquePathsTab(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		if(A[m - 1][n - 1] == 1) {
			return 0;
		}
		int[][] lookup = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 && j == 0 && A[i][j] != 1) {
					lookup[i][j] = 1;
					continue;
				}
				int top = 0, left = 0;
				if(i != 0 && A[i - 1][j] != 1) {
					top = lookup[i-1][j];
				}
				if(j != 0 && A[i][j -1] != 1) {
					left = lookup[i][j - 1];
				}
				lookup[i][j] = top + left;
			}
		}
		
		return lookup[m - 1][n - 1];
	}
	

}
