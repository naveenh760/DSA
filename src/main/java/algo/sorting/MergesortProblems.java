package algo.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergesortProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 6, 7, 7, 9, 13 };
		int b[] = { 2, 4, 4, 6, 15, 17, 19 };
		Integer[] result = intersectionOfSortedArrays1(a, b);
		System.out.println(Arrays.toString(result));
	}
	
	public static Integer[] interectionOfSortedArrays(int a[], int b[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m = a.length;
		int n = b.length;

		for (int i = 0; i < m; i++) {
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}

			for (int j = 0; j < n; j++) {
				if (a[i] == b[j]) {
					list.add(a[i]);
					break;
				}
			}
		}
		return list.toArray(new Integer[0]);
	}

	public static Integer[] intersectionOfSortedArrays1(int a[], int b[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int m = a.length;
		int n = b.length;
		int i = 0, j = 0;

		while (i < m && j < n) {
			if (i > 0 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {
				j++;
			} else {
				list.add(a[i]);
				i++;
				j++;
			}
		}
		return list.toArray(new Integer[0]);
	}

	public static Integer[] unionOfSortedArrays(int a[], int b[]) {
		int m = a.length;
		int n = b.length;
		int i = 0, j = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (i < m && j < n) {
			if (i != 0 && a[i] == a[i - 1]) {
				i++;
				continue;
			}

			if (j != 0 && b[j] == b[j - 1]) {
				j++;
				continue;
			}

			if (a[i] < b[j]) {
				list.add(a[i]);
				i++;
			} else if (a[i] > b[j]) {
				list.add(b[j]);
				j++;
			} else {
				list.add(a[i]);
				i++;
				j++;
			}
		}

		while (i < m) {
			if (i == 0 || a[i] != a[i - 1]) {
				list.add(a[i]);
				i++;
			}
		}

		while (j < n) {
			if (j == 0 || b[j] != b[j - 1]) {
				list.add(b[j]);
				j++;
			}
		}
		return list.toArray(new Integer[0]);
	}

	int getInversionCount(int arr[], int start, int end) {
		int c = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			c = c + getInversionCount(arr, start, mid);
			c = c + getInversionCount(arr, mid + 1, end);
			c = c + merge(arr, start, mid, end);
		}
		return c;
	}

	private int merge(int[] arr, int start, int mid, int end) {
		int c = 0;
		int temp[] = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
				k++;
			} else {
				temp[k] = arr[j];
				c = c + (mid + 1 - i);
				j++;
				k++;
			}
		}

		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while (j <= end) {
			temp[k] = arr[j];
			k++;
			j++;
		}
		for (i = start; i <= end; i++) {
			arr[i] = temp[i - start];
		}
		return c;
	}

	public void sort(int arr[]) {
		getInversionCount(arr, 0, arr.length - 1);
	}


}
