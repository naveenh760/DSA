package algo.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utilities.ArrayUtils;
import utilities.Pair;

public class SumDifference {

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

	public int pairSumCnt(int[] A, int B) {
		// Not working
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

	public int pairSumCnt2(int[] A, int B) {
		int mod = (int) (Math.pow(10, 9)) + 7;
		long cnt = 0;
		Map<Integer, Integer> map = ArrayUtils.computeFreqMap(A);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			if (entry.getValue() >= 0) {
				int otherNum = B - num;
				if (map.containsKey(otherNum)) {
					if (num == otherNum) {
						long equlCnt = entry.getValue();
						cnt = cnt + (equlCnt * (equlCnt - 1L)) / 2L;
					} else {
						long cnt1 = entry.getValue();
						long cnt2 = map.get(otherNum);
						cnt = cnt + (cnt1 * cnt2);
						map.put(otherNum, 0);
					}
				}
			}
		}
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

	public int pairDifference(int[] A, int B) {
		int cnt = 0;
		int l = 0;
		int r = 1;
		int n = A.length;
		Arrays.sort(A);
		while (r < n) {
			int diff = A[r] - A[l];
			if (diff < B) {
				r++;
			} else if (diff > B) {
				l++;
			} else if (diff == B) {
				cnt++;
				int curLeft = A[l];
				while (l < n && A[l] == curLeft) {
					l++;
				}

				int curRight = A[r];
				while (r < n && A[r] == curRight) {
					r++;
				}
			}
			if (l == r) {
				r++;
			}
		}
		return cnt;
	}

	public int pairDifferenceHash(int[] A, int B) {
		int count = 0;
		Map<Integer, Integer> freqMap = ArrayUtils.computeFreqMap(A);
		if (B == 0) {
			for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
				if (entry.getValue() >= 2) {
					count++;
				}
			}
			return count;
		}

		Set<Pair> pairs = new HashSet<Pair>();
		for (int num : freqMap.keySet()) {
			if (freqMap.containsKey(num + B)) {
				pairs.add(new Pair(num, num + B));
			}
			if (freqMap.containsKey(num - B)) {
				pairs.add(new Pair(num, num - B));
			}
		}
		return pairs.size();
	}

	public int threeSumClosest(int[] A, int B) {
		int n = A.length;
		int minDiff = Integer.MAX_VALUE;
		int sumAns = 0;
		Arrays.sort(A);
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = A[i] + A[j] + A[k];
				int diff = Math.abs(sum - B);
				if (diff < minDiff) {
					minDiff = diff;
					sumAns = sum;
				}
				if (sum == B) {
					return sumAns;
				} else if (sum < B) {
					j++;
				} else {
					k--;
				}
			}
		}
		return sumAns;
	}

	public int[] closestPair(int[] A, int[] B, int C) {
		int m = A.length;
		int n = B.length;
		int i = 0;
		int j = n - 1;
		int minDiff = Integer.MAX_VALUE;
		int minI = Integer.MAX_VALUE;
		int minJ = Integer.MAX_VALUE;
		while (i < m && j >= 0) {
			int diff = Math.abs(A[i] + B[j] - C);
			if (diff < minDiff || (diff == minDiff && i < minI) || (diff == minDiff && i == minI && j < minJ)) {
				minDiff = diff;
				minI = i;
				minJ = j;
			}
			if (A[i] + B[j] == C) {
				break;
			} else if (A[i] + B[j] > C) {
				j--;
			} else if (A[i] + B[j] < C) {
				i++;
			}
		}

		int[] res = new int[2];
		res[0] = A[minI];
		res[1] = B[minJ];
		return res;
	}

}
