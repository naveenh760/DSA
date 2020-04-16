package datastructures.stack;

class StackNode {
	int data;
	StackNode next;

	StackNode(int a) {
		data = a;
		next = null;
	}
}

public class StackLLCustom implements IStack {
	StackNode top;

	@Override
	public void push(int element) {
		StackNode newNode = new StackNode(element);
		newNode.next = top;
		top = newNode;

	}

	@Override
	public int pop() {
		if (top == null) {
			return -1;
		}
		int element = top.data;
		top = top.next;
		return element;
	}

	@Override
	public int top() {
		if(top == null) {
			return -1;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

}
