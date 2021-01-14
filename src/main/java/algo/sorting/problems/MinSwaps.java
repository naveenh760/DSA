package algo.sorting.problems;

import java.util.Arrays;

import utilities.*;

public class MinSwaps {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,0};
		System.out.println(minSwaps1(arr));

	}

	public int minSwaps(int arr[]) {
		int count = 0;
		int pos = 0;
		while (!isSorted(arr)) {
			if (arr[pos] != pos) {
				swap(arr, pos, arr[pos]);
				count++;
			} else {
				pos++;
			}
		}
		return count;
	}

	public static int minSwaps1(int arr[]) {
		int n = arr.length;
		Pair[] pairs = populatePairs(arr);
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		int count = 0;
		for (int i = 0; i < n; i++) {
			int cycleSize = 0;
			if(visited[i]) {
				continue;
			}
			while (visited[i] == false) {
				visited[i] = true;
				i = pairs[i].y;
				cycleSize++;
			}
			count = count + (cycleSize - 1);
		}

		return count;

	}
	
	
	public static int minSwaps2(int arr[]) {
		int n = arr.length;
		Pair[] pairs = populatePairs(arr);
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		int count = 0;
		for (int i = 0; i < n; i++) {
			int current = pairs[i].x;
			int cycleSize = 0;
			if(visited[current]) {
				continue;
			}
			while (visited[current] == false) {
				visited[current] = true;
				current = pairs[current].y;
				cycleSize++;
			}
			count = count + (cycleSize - 1);
		}

		return count;

	}

	static Pair[] populatePairs(int[] arr) {
		int n = arr.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			Pair p = new Pair(arr[i], i);
			pairs[i] = p;
		}
		Arrays.sort(pairs);
		return pairs;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	private boolean isSorted(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] != i) {
				return false;
			}
		}
		return true;
	}

}
