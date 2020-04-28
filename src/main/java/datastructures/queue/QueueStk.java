package datastructures.queue;

import java.util.Stack;

public class QueueStk implements IQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	@Override
	public void enqueue(int data) {
		stack1.push(data);

	}

	@Override
	public int dequeue() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()) {
			return -1;
		}
		return stack2.pop();
	}

	@Override
	public boolean isEmpty() {
		return (stack1.isEmpty() && stack2.isEmpty());
	}

	@Override
	public int front() {
		// TODO Auto-generated method stub
		return 0;
	}

}
