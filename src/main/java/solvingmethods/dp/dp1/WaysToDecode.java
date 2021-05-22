package solvingmethods.dp.dp1;

import java.util.Arrays;

public class WaysToDecode {

	public static void main(String[] args) {
		String A = "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
		String B = "31201";
		System.out.println(waysToDecodeTab(B));
	}

	public static int numDecodings(String A) {
		int n = A.length();
		return waysToDecodeRec(A, n - 1);
	}

	//Recursive version is not complete, need to add code to make sure that recursion stops when any of intermediate answer is 0.
	public static int waysToDecodeRec(String A, int i) {
		if (i == 0) {
			if (A.charAt(i) == '0') {
				return 0;
			}
			return 1;
		}
		if (i == 1) {
			if (A.charAt(i) == '0' && A.charAt(i - 1) != '1' && A.charAt(i - 1) != '2') {
				return 0;
			}
			if (Integer.parseInt(A.substring(0, 2)) <= 26) {
				return 2;
			} else {
				return 1;
			}
		}

		int temp = 0;
		if (A.charAt(i) == '0' && A.charAt(i - 1) != '1' && A.charAt(i - 1) != '2') {
			return 0;
		}
		if (Integer.parseInt(A.substring(i - 1, i + 1)) <= 26) {
			temp = waysToDecodeRec(A, i - 2);
		}
		return waysToDecodeRec(A, i - 1) + temp;
	}

	public static int waysToDecodeTab(String A) {
		int mod = (int) Math.pow(10, 9) + 7;
		int n = A.length();
		int[] ways = new int[n];
		Arrays.fill(ways, 0);
		if (A.charAt(0) == '0') {
			return 0;
		} else {
			ways[0] = 1;
		}
		if (n == 1) {
			return ways[0];
		}
		int pre = 1;
		for (int i = 1; i < n; i++) {
			if (A.charAt(i) == '0') {
				if (A.charAt(i - 1) != '1' && A.charAt(i - 1) != '2') {
					return 0;
				} else {
					if (i == 1) {
						ways[i] = pre;
					} else {
						ways[i] = ways[i - 2];
					}
				}
			} else {
				int temp = 0;
				int num = Integer.parseInt(A.substring(i - 1, i + 1));
				if (num <= 26 && num >= 10) {
					if (i == 1) {
						temp = pre;
					} else {
						temp = ways[i - 2];
					}
				}
				ways[i] = ((ways[i - 1] % mod) + (temp % mod)) % mod;
			}
		}
		return ways[n - 1] % mod;
	}

}
