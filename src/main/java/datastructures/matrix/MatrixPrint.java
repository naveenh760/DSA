package datastructures.matrix;

public class MatrixPrint {
	
	public static void main(String[] args) {
		int arr[][] = {{1,2,3}, {4,5,6},{7,8,9}};
		//snakePattern(arr);
	    print2D(arr);
		boundaryTraversal(arr);
	}
	
	public static void print2D(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void snakePattern(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			}
			else {
				for(int j = arr[i].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void boundaryTraversal(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		
		if(rows == 1) {
			for(int j = 0; j < cols; j++) {
				System.out.print(mat[0][j] + " ");
			}
		}
		else if(cols == 1) {
			for(int i = 0 ; i < rows; i++) {
				System.out.print(mat[i][0] + " ");
			}
		}
		else {
			for(int j = 0; j < cols; j++) {
				System.out.print(mat[0][j] + " ");
			}
			
			for(int i = 1; i < rows; i++) {
				System.out.print(mat[i][cols - 1] + " ");
			}
			
			for(int j = cols - 2; j >= 0; j--) {
				System.out.print(mat[rows - 1][j] + " ");
			}
			
			for(int i = rows - 2; i >= 1; i--) {
				System.out.print(mat[i][0] + " ");
			}
		}
	}
	
	

}
