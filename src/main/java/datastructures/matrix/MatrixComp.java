package datastructures.matrix;

public class MatrixComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sumOfSubMatrices(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int sum = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int freq = (i + 1)*(j + 1)*(R - i)*(C - j);
                sum+= (A[i][j]*freq);
            }
        }
        return sum;
    }
	
	
	public int[] subMatrixSum(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int mod = (int) (Math.pow(10,9)) + 7;
        int totalQueries = B.length;
		 int[] ans = new int[totalQueries];
		 long[][] prefixSum = rowPrefixSum(A);
		 for(int i = 0; i <totalQueries; i++) {
			 long sum = 0L;
			 for(int j = B[i] - 1; j <= D[i] - 1; j++) {
				 if(C[i] == 1) {
					 sum = (sum + prefixSum[j][E[i] - 1] + mod) % mod;
				 }
				 else {
					 sum = sum  + (prefixSum[j][E[i] - 1] - prefixSum[j][C[i] - 2] + mod) % mod;
				 }
			 }
			 
			 ans[i] = (int) ((sum + mod)  % mod);
		 }
		 return ans;
   }
   
    public long[][] rowPrefixSum(int[][] A){
        int mod = (int) (Math.pow(10,9)) + 7;
		 int R = A.length;
		 int C = A[0].length;
		 long[][] prefixSum = new long[R][C];
		 
		 for(int i=0; i < R; i++) {
			 prefixSum[i][0] = A[i][0];
			 for(int j = 1; j < C;j++) {
				 prefixSum[i][j] = prefixSum[i][j - 1] + A[i][j];
				 prefixSum[i][j] = (prefixSum[i][j] + mod)  % mod;
			 }
			 
		 }
		 return prefixSum;
	 }
	
	}
