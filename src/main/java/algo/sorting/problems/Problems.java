package algo.sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problems {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// list.addAll(Arrays.asList(-1,-2,-3,4,5));
		list.addAll(Arrays.asList(5, -17, -100, -11));
		/*
		 * int end = 3; int start = 1; int element = list.remove(end); list.add(start,
		 * element);
		 */
		list = posNeg1(list);
		System.out.println(list);

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
	
	public int[] subUnsort1(int[] A) {
		int n = A.length;
		int i = 0;
		int j = n - 1;
		int noans[] = { -1 };
		int ans[] = new int[2];
		while( i < n - 1 && A[i] <= A[i + 1]) {
			i++;
		}
		
		if(i == n - 1) {
			return noans;
		}
		
		while(j > 0 && A[j] >= A[j - 1]) {
			j--;
		}
		
		int min = A[i];
		int max = A[i];
		for(int k =i;k <= j;k++) {
			min = Math.min(min, A[k]);
			max = Math.max(max, A[k]);
		}
		
		int l = 0;
		int r = n - 1;
		while(l <= i && A[l] <= min) {
			l++;
		}
		
		while(r >= j && A[r] >= max) {
			r--;
		}
		ans[0] = l;
		ans[1] = r;
		return ans;
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

	public static ArrayList<Integer> posNeg1(ArrayList<Integer> A) {
		int n = A.size();
		boolean oopNeg = false;
		for (int i = 0; i < n; i++) {
			if ((i % 2 == 0 && A.get(i) >= 0) || (i % 2 == 1 && A.get(i) < 0)) {
				int oopIdx = i;
				if (A.get(i) < 0) {
					oopNeg = true;
				} else {
					oopNeg = false;
				}
				int rotatePosition = i++;
				
				while (i < n) {
					if ((oopNeg == true && A.get(i) >= 0) || (oopNeg == false && A.get(i) < 0)) {
						rotatePosition = i;
						break;
					}
					i++;
				}
				
				if (i < n) {
					rightRotateByOne(A, oopIdx, rotatePosition);
					i = oopIdx;
				}
			}
		}
		return A;
	}

	private static void rightRotateByOne(ArrayList<Integer> list, int start, int end) {
		int element = list.remove(end);
		list.add(start, element);
	}
	
	
	
}
