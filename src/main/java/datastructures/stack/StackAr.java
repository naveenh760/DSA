package datastructures.stack;

public class StackAr implements IStack {
	
	int[] array;
    int capacity;
    int top;
    
	
	public StackAr(int capacity) {
		super();
		this.capacity = capacity;
		array = new int[capacity];
		top = -1;
	}

	@Override
	public void push(int element) {
		if(top < capacity -1) {
			top++;
			array[top] = element;
		}
		else {
			// throw Overflow
		}
	}

	@Override
	public int pop() {
		if(top >= 0) {
			int element = array[top];
			top--;
			return element;
		}
		else {
			// throw underflow
			return -1;
		}
	}

	@Override
	public int peek() {
		if(top >= 0) {
			return array[top];
		}
		else {
			return -1;
		}
	}

	@Override
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public int size() {
		return top + 1;
	}

}
