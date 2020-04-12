package datastructures.hashtable;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayProbs {

	public static boolean pairSumUnsorted(int arr[], int sum) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int element : arr) {
			if (hashSet.contains(sum - element)) {
				return true;
			}
			hashSet.add(element);
		}
		return false;
	}

	public static int countDistinctN(int arr[]) {
		int n = arr.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			boolean isDuplicate = false;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] == arr[i]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				count++;
			}
		}
		return count;
	}

	public static int countDistinct(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int element : arr) {
			set.add(element);
		}
		return set.size();
	}

	public static void printFreqN(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] == arr[i]) {
					flag = true;
					break;
				}
			}
			if (flag == true) {
				continue;
			}

			int freq = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] == arr[i]) {
					freq++;
				}
			}
			System.out.println(arr[i] + " " + freq);
		}
	}

	public void printFreq(int arr[]) {
		LinkedHashMap<Integer, Integer> freqMap = new LinkedHashMap<Integer, Integer>();

		for (int element : arr) {
			if (freqMap.containsKey(element)) {
				freqMap.put(element, freqMap.get(element) + 1);
			} else {
				freqMap.put(element, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static int intersectionCountN(int a[], int b[]) {
		int m = a.length;
		int n = b.length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			boolean flag = false;
			for (int j = i - 1; j >= 0; j--) {
				if (a[j] == a[i]) {
					flag = true;
					break;
				}
			}
			if (flag == true) {
				continue;
			}

			for (int j = 0; j < n; j++) {
				if (a[i] == b[j]) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	public static int intersectionCount(int a[], int b[]) {
		int count = 0;
		HashSet<Integer> setA = new HashSet<Integer>();
		for (int element : a) {
			setA.add(element);
		}

		for (int element : b) {
			if (setA.contains(element)) {
				count++;
				setA.remove(element);
			}
		}
		return count;
	}

	public static int unionCountN(int a[], int b[]) {
		int m = a.length;
		int n = b.length;
		int c[] = new int[m + n];
		int i;
		for (i = 0; i < m; i++) {
			c[i] = a[i];
		}

		for (int j = 0; j < n; j++) {
			c[i + j] = b[j];
		}

		return countDistinctN(c);
	}

	public static int unionCount(int a[], int b[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int element : a) {
			set.add(element);
		}

		for (int element : b) {
			set.add(element);
		}

		return set.size();
	}

	public static void input() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for (int j = 0; j < n; j++) {
				a[j] = sc.nextInt();
			}
			for (int j = 0; j < m; j++) {
				b[j] = sc.nextInt();
			}
			System.out.println(unionCount(a, b));
		}

		sc.close();
	}

	public static long countNonRepeated(int arr[]) {
		LinkedHashMap<Integer, Integer> freqMap = new LinkedHashMap<Integer, Integer>();

		for (int element : arr) {
			if (freqMap.containsKey(element)) {
				freqMap.put(element, freqMap.get(element) + 1);
			} else {
				freqMap.put(element, 1);
			}
		}

		long count = 0;
		for (int freq : freqMap.values()) {
			if (freq == 1) {
				count++;
			}
		}
		return count;
	}
	
	

}
