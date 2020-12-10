package datastructures.stack;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	int min = Integer.MAX_VALUE;

	public void push(int x) {
		stack.push(x);
		int curMin = Math.min(min, x);
		minStack.push(curMin);
		min  = curMin;
	}

	public void pop() {
		if(!stack.isEmpty()) {
			stack.pop();
			minStack.pop();
			min = minStack.peek();
		}
	}

	public int top() {
		if(stack.isEmpty()) {
			return -1;
		}
		return stack.pop();
	}

	public int getMin() {
		if(stack.isEmpty()) {
			return -1;
		}
		return min;
	}

}
