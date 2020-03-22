package datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayOps {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		reverseInGroups(list, 5, 3);
	//	leftRotate2(array, 4);
		for (int element : list) {
			System.out.println(element);
		}
	}

	public static int[] reverseArray(int[] array) {
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			int other = n - 1 - i;
			int temp = array[i];
			array[i] = array[other];
			array[other] = temp;
		}
		return array;
	}

	public static int[] reverseArray1(int[] array, int low, int high) {
		while (low < high) {
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			low++;
			high--;
		}

		return array;
	}
	
	public static void reverseArrayList(ArrayList<Integer> list, int low, int high) {
		while (low < high) {
			int temp = list.get(low);
			list.set(low, list.get(high));
			list.set(high, temp);
			low++;
			high--;
		}

	}
	
	public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        int totalTimes = (int) Math.ceil(n /(double) k);
        int high = -1;
        for(int i = 1; i <= totalTimes; i++) {
        	int low = high + 1;
        	high = Math.min(low + k - 1,  n - 1);
        	reverseArrayList(mv, low, high);
        }
        
        return mv;
    }

	public static int[] reverseArray1(int[] array) {
		return reverseArray1(array, 0, array.length - 1);
	}

	public static void largestAndSecondLargest(int arr[]) {
		int max = -1;
		int max2 = -1;

		for (int element : arr) {
			if (element > max) {
				max2 = max;
				max = element;
			} else if (element > max2 && element != max) {
				max2 = element;
			}
		}

		System.out.println(max + " " + max2);
	}

	// O(n)
	public static void leftRoatateByOne(int[] arr) {
		int n = arr.length;
		int temp = arr[0];
		for (int i = 0; i < n - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[n - 1] = temp;
	}

	public static void leftRotate(int[] arr, int d) {
		d = d % arr.length;
		for (int i = 1; i <= d; i++) {
			leftRoatateByOne(arr);
		}
	}

	public static void leftRotate1(int[] arr, int d) {
		int n = arr.length;
		int[] temp = new int[d];
		d = d % n;
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}

		for (int i = 0; i < n - d; i++) {
			arr[i] = arr[i + d];
		}

		for (int i = 0; i < d; i++) {
			arr[n - d + i] = temp[i];
		}

	}

	public static void leftRotate2(int[] arr, int d) {
		int n = arr.length;
		d = d % n;

		arr = reverseArray1(arr, 0, d - 1);
		arr = reverseArray1(arr, d, n - 1);
		arr = reverseArray1(arr, 0, n - 1);
	}

	public static void rightRotateByOne(int[] arr) {
		int n = arr.length;
		int temp = arr[n - 1];
		for (int i = n - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}

	public static void rightRotate(int[] arr, int d) {
		d = d % arr.length;
		for (int i = 1; i <= d; i++) {
			rightRotateByOne(arr);
		}
	}

	public static void rightRotate1(int[] arr, int d) {
		int n = arr.length;
		d = d % n;
		int temp[] = new int[d];

		for (int i = 0; i < d; i++) {
			temp[i] = arr[n - d + i];
		}

		for (int i = n - 1; i >= d; i--) {
			arr[i] = arr[i - d];
		}

		for (int i = 0; i < d; i++) {
			arr[i] = temp[i];
		}
	}

	public static int countUnchangedRightRotate(int arr[], int d) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int j = (i + d) % n;
			if (arr[i] == arr[j]) {
				count++;
			}
		}
		return count;
	}

	public static int removeDuplicatesSorted(int arr[]) {
		int n = arr.length;
		if (n == 0) {
			return 0;
		}
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] != arr[count - 1]) {
				arr[count] = arr[i];
				count++;
			}
		}
		return count;
	}

}
