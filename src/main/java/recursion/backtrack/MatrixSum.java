package recursion.backtrack;

import java.util.ArrayList;

public class MatrixSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rowColSum(int A, int[][] B, int C) {
		if(rowColSum(A, B, C, 0, 0)) {
			return 1;
		}
		return 0;
    }
	
	public boolean rowColSum(int A, int[][] B, int C, int index, int opsCount) {
		int rows = B.length;
		int cols = B[0].length;
		int r = index / cols;
		int c = index % cols;
		if(index == rows * cols) {
			return false;
		}
		if(isFeasible(B,C)) {
			return true;
		}
		if(opsCount == A) {
			return false;
		}
		
		 B[r][c] *= (-1);
		 boolean ans1 = rowColSum(A, B, C, index + 1, opsCount + 1);
		 B[r][c] *= (-1);
		 
		 boolean ans2 = rowColSum(A, B, C, index + 1, opsCount);
		 
		 return ans1 || ans2;
		
    }

	private boolean isFeasible(int[][] B, int C) {
		int rows = B.length;
		int cols = B[0].length;
		for(int i = 0; i < rows; i++) {
			long maxSum = maxSubArraySum(B[i],C);
			if(maxSum > C) {
				return false;
			}
		}
		
		for(int j = 0; j < cols; j++) {
			int[] arr = new int[rows];
			for(int i = 0; i < rows; i++) {
				arr[i] = B[i][j];
			}
			long maxSum = maxSubArraySum(arr,C);
			if(maxSum > C) {
				return false;
			}
		}
		
		return true;
	}
	
	public static long maxSubArraySum(int arr[], int C) {
		int n = arr.length;
		long res = arr[0];
		long maxEnding = arr[0];
		for(int i = 1; i < n; i++) {
			maxEnding = Math.max(maxEnding + arr[i], arr[i]);
			res = Math.max(maxEnding, res);
			if(res > C) {
				break;
			}
		}
		return res;
	}

	

}
