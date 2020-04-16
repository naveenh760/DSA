package datastructures.stack;

import java.util.Stack;

public class StackProblems {
	
	public static void main(String[] args) {
		String s = "()[](";
		System.out.println(isBalanced(s));
	}
	
	public static int CountUnbalanced(String input) {
		Stack<Character> stack =  new Stack<Character>();	
		for(int i = 0; i < input.length(); i++) {
			Character  current = input.charAt(i);
			if(current == '(') {
				stack.push(current);
			}
			else if(current == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					stack.push(current);
				}
				else {
					stack.pop();
				}
			}
		}
		return stack.size();
	}
	
	public static boolean isBalanced(String str) {
		int n = str.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < n; i++) {
			if(isOpening(str.charAt(i))) {
				stack.push(str.charAt(i));
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				else if(isMatchingTop(stack.peek(), str.charAt(i))) {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatchingTop(Character peek, char charAt) {
		return (
				(peek == '(' && charAt == ')') ||
				(peek == '{' && charAt == '}') ||
				(peek == '[' && charAt == ']')
				);
	}

	private static boolean isOpening(char charAt) {

		return (charAt == '(' || charAt == '[' || charAt == '{');
	}

}
