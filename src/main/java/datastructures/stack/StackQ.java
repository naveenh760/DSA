package datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackQ implements IStack {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	@Override
	public void push(int element) {
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		q1.add(element);
		while(!q2.isEmpty()) {
			q1.add(q2.poll());
		}

	}

	@Override
	public int pop() {
		if(q1.isEmpty()) {
			return -1;
		}
		return q1.poll();
	}

	@Override
	public int top() {
		return q1.peek();
	}

	@Override
	public boolean isEmpty() {
		return q1.isEmpty();
	}

}
