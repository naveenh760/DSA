package datastructures.queue;

import datastructures.linkedlist.ListNode;

public class QueueLLCustom implements IQueue {
	ListNode front, rear;
	int size;
	public QueueLLCustom() {
		front = null;
		rear = null;
		size = 0;
	}

	@Override
	public void enqueue(int data) {
		ListNode newNode = new ListNode(data);
		size++;
		if(front == null) {
			front = newNode;
			rear = newNode;
			return;
		}
		rear.setNext(newNode);
		rear = newNode;

	}

	@Override
	public int dequeue() {
		if(front == null) {
			return -1;
		}
		int element = front.getData();
		size--;
		front = front.getNext();
		if(front == null) {   //Single element
			rear = null;
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int front() {
		if(isEmpty()) {
			return -1;
		}
		return front.getData();
	}

}
