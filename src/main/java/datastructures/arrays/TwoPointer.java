package datastructures.arrays;

import java.util.HashMap;

public class TwoPointer {

	public static boolean isPairSumSorted(int arr[], int X, int l, int r) {
		boolean found = false;
		while (l < r) {
			if (arr[l] + arr[r] == X) {
				found = true;
			} else if (arr[l] + arr[r] > X) {
				r--;
			} else {
				l++;
			}
		}
		return found;
	}

	public static boolean isPairSumSorted(int arr[], int x) {
		int n = arr.length;
		int l = 0, r = n - 1;
		return isPairSumSorted(arr, x, l, r);
	}

	public static boolean isTripletSumSorted(int arr[], int x) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (isPairSumSorted(arr, x - arr[i], i + 1, n - 1)) {
				return true;
			}
		}
		return false;
	}

	public int[] subArraySum(int[] A, int B) {
		int n = A.length;
		int i = 0;
		int j = 0;
		int sum = A[0];
		while (j < n) {
			if (sum == B) {
				break;
			} else if (sum < B) {
				j++;
				if (j < n) {
					sum = sum + A[j];
				}

			} else {
				sum = sum - A[i];
				i++;
			}
		}
		if (j == n) {
			return new int[] { -1 };
		} else {
			int size = j - i + 1;
			int[] res = new int[size];
			for (int k = 0; k < size; k++) {
				res[k] = A[i + k];
			}
			return res;
		}

	}

	public int pairSumCnt(int[] A, int B) {
		int mod = (int) (Math.pow(10, 9)) + 7;
		long cnt = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int number : A) {
			if (map.containsKey(number)) {
				map.put(number, map.get(number) + 1);
			} else {
				map.put(number, 1);
			}
		}

		for (int number : A) {
			if (map.containsKey(B - number)) {
				map.put(number, map.get(number) - 1);
				cnt = (cnt % mod + map.get(B - number) % mod) % mod;
				map.put(number, map.get(number) + 1);
			}

		}
		cnt = (cnt % mod) / 2L;
		return (int) (cnt % mod);

	}

	public int pairSumCnt1(int[] A, int B) {
		int n = A.length;
		int mod = (int) (Math.pow(10, 9)) + 7;
		long cnt = 0;
		int i = 0;
		int j = n - 1;

		while (i < j) {
			if (A[i] + A[j] < B) {
				i++;
			} else if (A[i] + A[j] > B) {
				j--;
			} else {
				if (A[i] == A[j]) {
					long equalCnt = j - i + 1;
					cnt = (cnt + (equalCnt * (equalCnt - 1) / 2L)) % mod;
					break;
				} else {
					int k = i;
					while (A[k] == A[i] && k < n) {
						k++;
					}
					long aiCnt = k - i;

					int l = j;
					while (A[l] == A[j] && l >= 0) {
						l--;
					}
					long ajCnt = j - l;
					cnt = (cnt + (aiCnt * ajCnt)) % mod;
					i += aiCnt;
					j -= ajCnt;

				}
			}
		}
		return (int) (cnt % mod);

	}
	
	

}
