package datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackProblems {

	public static void main(String[] args) {
		String s = "()[](";
		System.out.println(isBalanced(s));
	}

	public static int CountUnbalanced(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			Character current = input.charAt(i);
			if (current == '(') {
				stack.push(current);
			} else if (current == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					stack.push(current);
				} else {
					stack.pop();
				}
			}
		}
		return stack.size();
	}

	public static boolean isBalanced(String str) {
		int n = str.length();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < n; i++) {
			if (isOpening(str.charAt(i))) {
				stack.push(str.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (isMatchingTop(stack.peek(), str.charAt(i))) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatchingTop(Character peek, char charAt) {
		return ((peek == '(' && charAt == ')') || (peek == '{' && charAt == '}') || (peek == '[' && charAt == ']'));
	}

	private static boolean isOpening(char charAt) {

		return (charAt == '(' || charAt == '[' || charAt == '{');
	}

	public int[] balanceBrackets(String A) {
		int[] result = new int[2];
		Arrays.fill(result, 0);
		Stack<Character> stack = new Stack<Character>();
		int length = A.length();
		
		for (int i = 0; i < length; i++) {
			Character ch = A.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.empty()) {
					result[0]++;
				} else if (stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		result[1] = stack.size();
		return result;
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

}
