package datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {

	}


	public static void calculateSpan(int price[], int S[]) {
		int n = price.length;
		for (int i = 0; i < n; i++) {
			int span = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (price[j] <= price[i]) {
					span++;
				} else {
					break;
				}
			}
			S[i] = span;
		}

	}

	public static void calculateSpan1(int price[], int S[]) {
		int n = price.length;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
				stack.pop();
			}
			int span = stack.isEmpty() ? i + 1 : i - stack.peek();
			S[i] = span;
			stack.push(i);
		}
	}

	public static int[] prevGreater(int arr[]) {
		int n = arr.length;
		int[] greaterArray = new int[n];

		for (int i = 0; i < n; i++) {
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					greaterArray[i] = arr[j];
					break;
				}
			}
			if (j == -1) {
				greaterArray[i] = -1;
			}
		}
		return greaterArray;
	}

	public static int[] prevGreater1(int arr[]) {
		int n = arr.length;
		int[] greaterArray = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			int greaterElement = stack.isEmpty() ? -1 : stack.peek();
			greaterArray[i] = greaterElement;
			stack.push(arr[i]);
		}
		return greaterArray;
	}

	public static long[] nextGreater(long[] arr) {
		int n = arr.length;
		long[] result = new long[n];
		for (int i = 0; i < n; i++) {
			int j;
			for (j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					result[i] = arr[j];
					break;
				}
			}
			if (j == n) {
				result[i] = -1;
			}
		}
		return result;
	}

	public static long[] nextGreater1(long[] arr) {
		int n = arr.length;
		Stack<Long> stack = new Stack<Long>();
		long[] result = new long[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			result[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(arr[i]);
		}
		return result;
	}

	public int passingGame(int A, int B, int[] C) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(B);
		for(int num: C) {
			if(num > 0) {
				stack.push(num);
			}
			else {
				stack.pop();
			}
		}
		
		return stack.peek();
	}

}
