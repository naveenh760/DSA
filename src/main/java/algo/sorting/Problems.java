package algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problems {

	public static void main(String[] args) {

	}

	public int[] subUnsort(int[] A) {
		int n = A.length;
		int noans[] = { -1 };
		int ans[] = new int[2];
		int[] unSorted = Arrays.copyOf(A, n);
		Arrays.sort(A);
		int firstIndex = -1;
		int lastIndex = n;
		for (int i = 0; i < n; i++) {
			if (unSorted[i] != A[i]) {
				firstIndex = i;
				break;
			}
		}
		if (firstIndex == -1) {
			return noans;
		}

		for (int i = n - 1; i >= 0; i--) {
			if (unSorted[i] != A[i]) {
				lastIndex = i;
				break;
			}
		}
		ans[0] = firstIndex;
		ans[1] = lastIndex;
		return ans;
	}

	public int reversePair(int[] A) {
		int n = A.length;
		int mod = (int) (Math.pow(10, 9)) + 7;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (A[i] > 2 * A[j]) {
					cnt++;
				}
			}
		}
		return cnt % mod;
	}

	public ArrayList<Integer> posNeg(ArrayList<Integer> A) {
		int n = A.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> posNos = new ArrayList<Integer>();
		ArrayList<Integer> negNos = new ArrayList<Integer>();
		int countPos = 0;
		int countNeg = 0;
		for (int i = 0; i < n; i++) {
			if (A.get(i) >= 0) {
				posNos.add(A.get(i));
			} else {
				negNos.add(A.get(i));
			}
		}
		countPos = posNos.size();
		countNeg = negNos.size();
		int minCnt = Math.min(countPos, countNeg);
		for (int i = 0; i < minCnt; i++) {
			result.add(negNos.get(i));
			result.add(posNos.get(i));
		}

		// only one of the two loops will be executed
		for (int i = minCnt; i < countPos; i++) {
			result.add(posNos.get(i));
		}
		for (int i = minCnt; i < countNeg; i++) {
			result.add(negNos.get(i));
		}

		return result;
	}

}
