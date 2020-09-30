package datastructures.stack;

public class StackDemo {

	public static void main(String[] args) {

		arrayStack();
		linkedListStack();
	}
	
	
	public static void arrayStack() {
		IStack stack = new StackAr(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		System.out.println(stack.peek());
	}
	
	public static void linkedListStack() {
		IStack stack = new StackLL();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.pop();
		System.out.println(stack.peek());
	}

}
