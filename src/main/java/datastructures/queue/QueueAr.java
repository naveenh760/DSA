package datastructures.queue;

public class QueueAr implements IQueue {
	
	int[] arr;
	int front, capacity, size;
	
	public QueueAr(int capacity) {
		arr = new int[capacity];
		this.capacity = capacity;
		front = 0;
		size = 0;
	}

	@Override
	public void enqueue(int data) {
		if(isFull()) {
			return;
		}
		int rear = getRear();
		rear = (rear + 1) % capacity;
		arr[rear] = data;
		size++;
	}

	@Override
	public int dequeue() {
		if(isEmpty()) {
			return -1;
		}
		int element = arr[front];
		front = (front + 1 ) % capacity;
		size--;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int front() {
		if(isEmpty()) {
			return -1;
		}
		else {
			return front;
		}
	}
	
	public boolean isFull() {
		return capacity == size;
	}
	
	public int getRear() {
		if(isEmpty()) {
			return -1;
		}
		else {
			return ( front + size -1) % capacity;
		}
	}

}
