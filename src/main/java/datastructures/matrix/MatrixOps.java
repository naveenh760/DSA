package datastructures.matrix;

public class MatrixOps {

	public static void main(String[] args) {
		int mat[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
		int mat1[][] = {{1,2,3},{4,5,6}};
		MatrixPrint.print2D(mat1);
	//	reverseEachColumn(mat);
		System.out.println();
	//	rotate90AntiClockNaive(mat);
	//	rotate90AntiClock(mat);
		int[][] trans = transpose(mat1);
		MatrixPrint.print2D(trans);
	//	MatrixPrint.print2D(mat);

	}

	public static void transposeSquare(int mat[][]) {
		int n = mat.length;
		for(int i = 0 ; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
	}
	
	public static int[][] transpose(int mat[][]){
		int m = mat.length;
		int n = mat[0].length;
		int trans[][] = new int[n][m];
		
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		trans[i][j] = mat[j][i];
        	}
        }
        
        return trans;
	}
	
	
	public static void reverseEachColumn(int mat[][]) {
		int n = mat.length;
		
		for(int j = 0; j < n; j++) {
			int low = 0;
			int high = n - 1;
			while( low < high) {
				int temp = mat[low][j];
				mat[low][j] = mat[high][j];
				mat[high][j] = temp;
				low++;
				high--;
			}
		}
	}
	
	public static void reverseEachRow(int mat[][]) {
		int n = mat.length;
		
		for(int i = 0; i < n; i++) {
			int low = 0;
			int high = n - 1;
			while(low < high) {
				int temp = mat[i][low];
				mat[i][low] = mat[i][high];
				mat[i][high] = temp;
				low++;
				high--;
			}
		}
	}
	
	public static void rotate90AntiClock(int mat[][]) {
		transposeSquare(mat);
		reverseEachColumn(mat);
	}
	
	public static void rotate90AntiClockNaive(int mat[][]) {
		int n = mat.length;
		int temp[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				temp[i][j] = mat[i][j];
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = temp[j][n - 1 - i];
			}
		}
	}
	
	
	public static int[][] multiply(int A[][], int B[][]){
		int m = A.length;
		int p = B[0].length;
		int n;
		if(A[0].length == B.length) {
			n = B.length;
		}
		else {
			return null;
		}
		int C[][] = new int[m][p];
		for(int i = 0 ; i < m; i++) {
			for(int j = 0; j < p; j++) {
				C[i][j] = 0;
				for(int k = 0; k < n; k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return C;
	}
	
}
