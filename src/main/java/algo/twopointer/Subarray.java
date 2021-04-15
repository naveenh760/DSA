package algo.twopointer;

import java.util.HashMap;
import java.util.Map;

public class Subarray {

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

	public int countSubarraysUnique(int[] A) {
		long ans = 0;
		int n = A.length;
		int l = 0;
		int r = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int mod = (int) (Math.pow(10, 9)) + 7;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(A[i])) {
				l = Math.max(l, map.get(A[i]) + 1); // If l is already updated to newer element dont update
			}
			map.put(A[i], i);
			ans += r - l + 1;
			ans = ans % mod;
			r++;
		}
		return (int) ans;
	}

}
