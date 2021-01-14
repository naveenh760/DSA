package algo.search;

import java.util.Arrays;

public class AnswerSearchProblems {

	public static void main(String[] args) {
		// System.out.println(athMagical1(807414236, 3788, 38141));
		int[][] a = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 }

		};
		// System.out.println(findMedian(a));
		// System.out.println(maxHeightStair1(92761));
		// printSums(432);
	//	int[] arr = { 5, 10, 20, 100, 105 };
	//	System.out.println(specialInteger(arr, 130));
		solve("59");
	}

	long floorSqrt(long x) {
		long low = 0;
		long high = x;
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return high;
	}

	public int athMagical(int A, int B, int C) {
		int mod = (int) (Math.pow(10, 9)) + 7;
		int num = 2;
		int count = 0;
		while (true) {
			if ((num % B == 0) || (num % C == 0)) {
				count++;
				if (count == A) {
					break;
				}
			}
			num++;
		}
		return num % mod;
	}

	public static int athMagical1(int A, int B, int C) {
		long ans = 0;
		int mod = (int) (Math.pow(10, 9)) + 7;
		long low = 1L;
		long high = (long) A * (long) Math.max(B, C);
		long lcm = (B * C) / gcd(B, C);
		while (low <= high) {
			long mid = (low + (high - low) / 2);
			long count = (mid / B) + (mid / C) - (mid / lcm);
			if (count >= A) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return (int) (ans % mod);
	}

	static int gcd(int A, int B) {
		if (A == 0) {
			return B;
		}
		return gcd(B % A, A);
	}

	public static int findMedian(int[][] A) {
		int R = A.length;
		int C = A[0].length;
		int smallerCount = (1 + R * C) / 2;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			min = Math.min(A[i][0], min);
		}
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < R; j++) {
			max = Math.max(A[j][C - 1], max);
		}
		int low = min;
		int high = max;
		int ans = A[0][0];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			for (int i = 0; i < R; i++) {
				count = count + countLesserElements(A[i], mid);
			}
			if (count < smallerCount) {
				low = mid + 1;
			} else {
				ans = mid;
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int countLesserElements(int[] arr, int x) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > x) {
				high = mid - 1;
			} else {
				ans = mid + 1;
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int maxHeightStair(int A) {
		int ans = 0;
		for (int i = 1; i <= A; i++) {
			int curBlocks = (i * (i + 1)) / 2;
			if (curBlocks <= A) {
				ans = i;
			} else {
				break;
			}

		}
		return ans;
	}

	public static int maxHeightStair1(int A) {
		int ans = 0;
		int low = 1;
		int high = A;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			long curBlocksUsed = ((long) mid * (mid + 1)) / 2;
			if (curBlocksUsed <= A) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int specialInteger(int[] A, int B) {
		int n = A.length;
		int ans = 0;
		for (int k = 1; k <= n; k++) {
			if (isSubSumLessThanB(A, B, k)) {
				ans = k;
			} else {
				break;
			}
		}
		return ans;

	}

	public static int specialInteger1(int[] A, int B) {
		int n = A.length;
		int ans = 0;
		int low = 0;
		int high = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isSubSumLessThanB(A, B, mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;

	}

	static boolean isSubSumLessThanB(int[] arr, int B, int k) {
		int n = arr.length;
		long currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += arr[i];
		}
		if (currSum > B) {
			return false;
		}

		for (int i = k; i < n; i++) {
			currSum -= arr[i - k];
			currSum += arr[i];
			if (currSum > B) {
				return false;
			}
		}
		return true;
	}

	public int agressiveCows(int[] A, int B) {
		Arrays.sort(A);
		int max = Integer.MIN_VALUE;
		for (int num : A) {
			max = Math.max(max, num);
		}
		int low = 0;
		int high = max;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isFeasible(A, B, mid)) {
				low = mid + 1;
				ans = mid;
			} else {
				high = mid - 1;
			}
		}
		return ans;

	}

	public boolean isFeasible(int[] arr, int B, int minDist) {
		int n = arr.length;
		int prevStallPos = 0;
		int i = 0;
		int count = 1;
		int prevStallLocation;
		int nextMin;
		while (i < n) {
			prevStallLocation = arr[prevStallPos];
			nextMin = prevStallLocation + minDist;
			while (i < n && arr[i] < nextMin) {
				i++;
			}
			if (i < n) {
				prevStallPos = i;
				count++;
				if (count == B) {
					return true;
				}
				i++;
			}

		}
		return false;
	}
	
	public static String solve(String A) {
		Long number = Long.parseLong(A);
		int k = 58;
		while(true) {
			String baseKVal = Long.toString(number, k);
			int len = baseKVal.length();
			int i;
			for(i = 0; i < len; i++) {
				char ch = baseKVal.charAt(i);
				if(ch != '1') {
					break;
				}
			}
			if(i == len) {
				return Integer.toString(k);
			}
			k++;
		}
    }

	public static void printSums(int n) {
		for (int i = 0; i <= n; i++) {
			int ans = (i * (i + 1)) / 2;
			System.out.println(i + " " + ans);
		}
	}

}
