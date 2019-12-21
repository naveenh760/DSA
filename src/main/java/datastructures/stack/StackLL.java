package datastructures.stack;

import java.util.LinkedList;

public class StackLL {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	public void push(int data) {
		list.addFirst(data);
	}
	
	public int pop() {
		int top = list.getFirst();
		list.removeFirst();
		return top;
	}
	
	public int top() {
		return list.getFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
