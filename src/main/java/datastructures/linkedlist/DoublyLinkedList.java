package datastructures.linkedlist;

public class DoublyLinkedList implements ILinkedList {
	private DListNode head;
	
	public DListNode getHead() {
		return head;
	}

	public void setHead(DListNode head) {
		this.head = head;
	}
	
	@Override
	public int size() {
		int size = 0;
		DListNode current = head;
		while(current != null) {
			current = current.getNext();
			size++;
		}
		
		return size;
	}
	
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append('[');
		DListNode current = head;
		while(current != null) {
			output.append(current.getData());
			current = current.getNext();
			if(current !=null) {
				output.append(",");
			}
		}
		output.append(']');
		return new String(output);
	}
	
	
	public int[] toArray() {
		int[] array = new int[this.size()];
		DListNode current = head;
		int i = 0;
		while(current != null) {
			array[i] = current.getData();
			current = current.getNext();
			i++;
		}
		
		return array;
	}
	
	@Override
	public void insertAtBegin(int data) {
		DListNode newNode = new DListNode(data);
		newNode.setNext(head);
		head = newNode;
	}
	
	@Override
	public void insertAtEnd(int data) {
		DListNode newNode = new DListNode(data);
		if(head == null) {
			head = newNode;
			return;
		}
		DListNode current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		newNode.setPrev(current);
		current.setNext(newNode);
	}
	
	public void insertAfterPos(int data, int pos) {
		DListNode newNode = new DListNode(data);
		DListNode current = head;
		for(int i = 0; i < pos; i++) {
			current = current.getNext();
		}
		DListNode next = current.getNext();
		current.setNext(newNode);
		newNode.setPrev(current);
		newNode.setNext(next);
	}
	

}
