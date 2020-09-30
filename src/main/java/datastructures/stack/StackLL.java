package datastructures.stack;

import java.util.LinkedList;

public class StackLL implements IStack {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	@Override
	public void push(int data) {
		list.addFirst(data);
	}
	
	@Override
	public int pop() {
		int top = list.getFirst();
		list.removeFirst();
		return top;
	}
	
	@Override
	public int peek() {
		return list.getFirst();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
