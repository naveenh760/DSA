package datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArrayProbs {

	public static void main(String[] args) {
		System.out.println(-27 % 5);

	}

	public static int getWater(int arr[]) {
		int n = arr.length;
		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			int lMax = arr[i];
			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, arr[i]);
			}

			int rMax = arr[i];
			for (int j = i + 1; j < n; j++) {
				rMax = Math.max(rMax, arr[i]);
			}

			res += (Math.min(lMax, rMax) - arr[i]);
		}
		return res;
	}

	public static int getWater1(int arr[]) {
		int n = arr.length;
		int res = 0;
		int lMax[] = new int[n];
		int rMax[] = new int[n];

		lMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			lMax[i] = Math.max(arr[i], lMax[i - 1]);
		}

		rMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = Math.max(arr[i], rMax[i + 1]);
		}

		for (int i = 1; i < n - 1; i++) {
			res += (Math.min(lMax[i], rMax[i]) - arr[i]);
		}
		return res;
	}

	public static int maxConsecOnes(int[] arr) {
		int n = arr.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int curr = 0;
			for (int j = i; j < n; j++) {
				if (arr[j] == 1) {
					curr++;
				} else {
					break;
				}
			}
			res = Math.max(res, curr);
		}
		return res;
	}

	public static int maxConsecutiveOnes1(int[] arr) {
		int n = arr.length;
		int res = 0;
		int curr = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				curr = 0;
			} else {
				curr++;
				res = Math.max(res, curr);
			}
		}
		return res;
	}

	public static int minAdjDiff(int arr[]) {
		int n = arr.length;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int adj = (i + 1) % n;
			int absDiff = Math.abs(arr[i] - arr[adj]);
			minDiff = Math.min(minDiff, absDiff);
		}
		return minDiff;
	}

	public static void convertToWave(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i += 2) {
			if (i + 1 < n) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

	}

	public static void frequencycount(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] - 1;
		}
		for (int i = 0; i < n; i++) {
			arr[arr[i] % n] += n;
		}
		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / n;
		}
	}

	public int[] repeatedNumber(final int[] A) {
		HashSet<Integer> set = new HashSet<Integer>();
		int[] ans = new int[2];
		for (int num : A) {
			if (set.contains(num)) {
				ans[0] = num;
			}
		}
		for (int i = 1; i <= A.length; i++) {
			if (!set.contains(i)) {
				ans[1] = i;
			}
		}
		return ans;
	}

	public int makeEqual(int[][] A, int B) {
		int rows = A.length;
		int cols = A[0].length;
		int n = rows * cols;
		int[] arr = new int[n];
		int count = 0;
		int temp;
		int mod;
		if (A[0][0] < 0) {
			temp = toPositive(A[0][0], B);
			mod = temp % B;
		} else {
			mod = A[0][0] % B;
		}
		int k = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int curMod = A[i][j] % B;
				if (A[i][j] < 0) {
					temp = toPositive(A[i][j], B);
					curMod = temp % B;
				}
				if (curMod != mod) {
					return -1;
				}
				arr[k] = A[i][j];
				k++;
			}
		}
		Arrays.sort(arr);
		if (n % 2 == 1) {
			int medianPos = n / 2;
			int median = arr[medianPos];
			for (int i = 0; i < n; i++) {
				count = count + Math.abs(arr[i] - median) / B;
			}
			return count;
		} else {
			int count1 = 0;
			int count2 = 0;
			int median1Pos = (n / 2) - 1;
			int median1 = arr[median1Pos];
			int median2Pos = n / 2;
			int median2 = arr[median2Pos];
			for (int i = 0; i < n; i++) {
				count1 = count1 + Math.abs(arr[i] - median1) / B;
				count2 = count2 + Math.abs(arr[i] - median2) / B;
			}
			return Math.min(count1, count2);
		}	
	}
	
	public int toPositive(int number, int add) {
		while (number < 0) {
			number = number + add;
		}
		return number;
	}
	
	public int maxChunksSorted(int[] A) {
        int n = A.length;
        if(n == 1){
            return 1;
        }
        int[] minRight = new int[n];
        int min = A[n - 1];
        minRight[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--){
            min = Math.min(min,A[i]);
            minRight[i] = min;
        }
        int count = 1;
        int maxLeft = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++){
            maxLeft = Math.max(maxLeft, A[i]);
            if(maxLeft <= minRight[i + 1]){
                count++;
            }
        }
        return count;
    }

}
