package recursion.backtrack;

import java.util.ArrayList;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean sudoku(ArrayList<ArrayList<Character>> a) {
		int n = a.size();
		boolean foundEmptyCell = false;
		int i = 0;
		int j = 0;
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				if(a.get(i).get(j) == '.') {
					foundEmptyCell = true;
					break;
				}
			}
			if(foundEmptyCell) {
				break;
			}
		}
		if(!foundEmptyCell) {
			return true;
		}
		for(int k = 1; k <= n; k++) {
			char ch = Integer.toString(k).charAt(0);
			if(isFeasible(a, i, j, ch)) {
				a.get(i).set(j, ch);
				if(sudoku(a)) {
					return true;
				}
				a.get(i).set(j, '.');
			}
		}
		return false;
	}
	
	boolean isFeasible(ArrayList<ArrayList<Character>> a, int r, int c, char num) {
		int n = a.size();
		for(int k = 0; k < n; k++) {
			if(a.get(r).get(k) == num || a.get(k).get(c) == num) {
				return false;
			}
		}
		
		int blockSize = (int) Math.sqrt(n);
		int blockStartRow = r - (r % blockSize);
		int blockStartCol = c - (c % blockSize);
		for(int i = 0; i < blockSize; i++) {
			for(int j = 0; j < blockSize; j++) {
				if(a.get(blockStartRow + i).get(blockStartCol + j) == num) {
					return false;
				}
			}
		}
		return true;
	}

}
