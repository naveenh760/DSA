package recursion.backtrack;

public class MinSwapsPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int minSwaps(int A, int[] B, int[][] C, int pairNum) {
		if(pairNum == A) {
			return 0;
		}
		int sIdx1 = 2 * (pairNum - 1);
		int sIdx2 = getPairPos(B[sIdx1 + 1], C,B);
		
		int sIdx3 = 2 * (pairNum - 1) + 1;
		int sIdx4 = getPairPos(B[sIdx3 - 1], C,B);
		
		if(sIdx1 == sIdx2) {
			return minSwaps(A, B, C,  pairNum + 1);
		}
		else {
			swap(B, sIdx1, sIdx2);
			int ans1 = minSwaps(A, B, C, pairNum + 1);
			swap(B, sIdx1, sIdx2);
			
			swap(B, sIdx3, sIdx4);
			int ans2 = minSwaps(A, B, C, pairNum + 1);
			swap(B, sIdx3, sIdx4);

			return 1 + Math.min(ans1, ans2);
		}
		
	}

	private void swap(int[] B, int sIdx1, int sIdx2) {
		int temp = B[sIdx1];
		B[sIdx1] = B[sIdx2];
		B[sIdx2] = temp;
		
	}

	private int getPairPos(int num, int[][] C, int[] B) {
		int r = C.length;
		int c = C[0].length;
		int pairElement = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(C[i][j] == num) {
					if(j == 0) {
						pairElement = C[i][1];
						break;
					}
					else {
						pairElement = C[i][0];
						break;
					}
				}
			}
			if(pairElement != 0) {
				break;
			}
		}
		
		for(int i = 0; i < B.length; i++) {
			if(B[i] == pairElement) {
				return i;
			}
		}
		
		return -1;
	}

}
