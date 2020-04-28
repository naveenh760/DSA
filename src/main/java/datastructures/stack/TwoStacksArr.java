package datastructures.stack;

public class TwoStacksArr {
	int arr[];
	int capacity, top1, top2;
	public TwoStacksArr(int capacity) {
		this.capacity = capacity;
		top1 = -1;
		top2 = capacity;
		arr = new int[capacity];
	}
	
	void push1(int x) {
		if(top1 < top2 - 1) {
			top1++;
			arr[top1] = x;
		}
	}
	
	void push2(int x) {
		if(top1 < top2 - 1) {
			top2--;
			arr[top2] = x;
		}
	}
	
	int pop1() {
		if(top1 >= 0) {
			int element = arr[top1];
			top1--;
			return element;
		}
		else {
			return -1;
		}
	}
	
	int pop2() {
		if(top2 < capacity) {
			int element = arr[top2];
			top2++;
			return element;
		}
		return -1;
	}
	
	int size1() {
		return top1 + 1;
	}
	
	int size2() {
		return capacity - top2;
	}

	int top1() {
		if(top1 >= 0) {
			return arr[top1];
		}
		return -1;
	}
	
	int top2() {
		if(top2 < capacity) {
			return arr[top2];
		}
		return -1;
	}
}
