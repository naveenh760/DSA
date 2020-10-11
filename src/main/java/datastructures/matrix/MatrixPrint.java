package datastructures.matrix;

public class MatrixPrint {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// snakePattern(arr);
		print2D(arr);
		boundaryTraversal(arr);
	}

	public static void print2D(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void snakePattern(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			} else {
				for (int j = arr[i].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public static void boundaryTraversal(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;

		if (rows == 1) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[0][j] + " ");
			}
		} else if (cols == 1) {
			for (int i = 0; i < rows; i++) {
				System.out.print(mat[i][0] + " ");
			}
		} else {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[0][j] + " ");
			}

			for (int i = 1; i < rows; i++) {
				System.out.print(mat[i][cols - 1] + " ");
			}

			for (int j = cols - 2; j >= 0; j--) {
				System.out.print(mat[rows - 1][j] + " ");
			}

			for (int i = rows - 2; i >= 1; i--) {
				System.out.print(mat[i][0] + " ");
			}
		}
	}

	public static void boundaryTraversal1(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (i == 0 || j == 0 || i == mat.length - 1 || j == mat[i].length - 1) {
					System.out.println(mat[i][j] + " ");
				}
			}
		}

	}

	static void printSpiral(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		int topRow = 0, leftCol = 0, bottomRow = rows - 1, rightCol = cols - 1;

		while (topRow <= bottomRow && leftCol <= rightCol) {
			for (int j = leftCol; j <= rightCol; j++)
				System.out.print(mat[topRow][j] + " ");

			topRow++;

			for (int i = topRow; i <= bottomRow; i++)
				System.out.print(mat[i][rightCol] + " ");

			rightCol--;

			if (topRow <= bottomRow) {
				for (int j = rightCol; j >= leftCol; j--)
					System.out.print(mat[bottomRow][j] + " ");

				bottomRow--;
			}

			if (leftCol <= rightCol) {
				for (int i = bottomRow; i >= topRow; i--)
					System.out.print(mat[i][leftCol] + " ");

				leftCol++;
			}
		}
	}

}
