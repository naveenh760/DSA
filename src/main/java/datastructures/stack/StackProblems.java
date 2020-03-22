package datastructures.stack;

import java.util.Stack;

public class StackProblems {
	
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

}
