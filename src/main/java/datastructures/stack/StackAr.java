package datastructures.stack;

public class StackAr implements IStack {
	
	int[] array;
    int capacity;
    int size;
    int top;
    
	
	public StackAr(int capacity) {
		super();
		this.capacity = capacity;
		array = new int[capacity];
		size = 0;
		top = -1;
	}

	@Override
	public void push(int element) {
		top++;
		array[top] = element;
		size++;

	}

	@Override
	public int pop() {
		int element = array[top];
		top--;
		return element;
	}

	@Override
	public int top() {
		return array[top];
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

}
