package algo.twopointer;

public class PairOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");

	}

	
	public int countRectangles(int[] A, int B) {
		long cnt = 0L;
		int n = A.length;
		int i = 0;
		int j = n - 1;
		int mod = (int) (Math.pow(10, 9)) + 7;
		while (i <= j) {
			long prod = (long) A[i] * (long) A[j];
			if (prod >= B) {
				j--;
			} else {
				cnt = (cnt % mod) + ((j - i) * 2L) % mod + 1L;
				i++;
			}
		}
		return (int) cnt % mod;
	}

	public int countRectangles1(int[] A, int B) {
		int n = A.length;
		long ans = 0;
		int mod = (int) (Math.pow(10, 9)) + 7;
		int i = 0, j = n - 1;
		while (i < n && j >= 0) {
			if ((long) A[i] * A[j] < B) {
				ans = (ans + j + 1) % mod;
				i++;
			} else {
				j--;
			}
		}
		return (int) ans;
	}

}
