package datastructures.linkedlist;

public class SinglyLinkedList implements ILinkedList{

	protected ListNode head;

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head ) {
		this.head = head;
	}
	
	@Override
	public int size() {
		int size = 0;
		ListNode current = head;
		while(current != null) {
			current = current.getNext();
			size++;
		}
		
		return size;
	}
	
	
	@Override
	public void insertAtBegin(int data) {
		ListNode newNode = new ListNode(data);
		newNode.setNext(head);
		head = newNode;
	}
	
	@Override
	public void insertAtEnd(int data) {
		ListNode newNode = new ListNode(data);
		ListNode current = head;
		if(head == null) {
			head = newNode;
			return;
		}
		while(current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(newNode);
	}
	
	
	public void insertAtPos(int data, int pos) {
		ListNode newNode = new ListNode(data);
		ListNode current = head;
		
		if(pos == 0 || head == null) {
			newNode.setNext(head);
			head = newNode;
		}
		
		for(int i = 1 ; i <  pos && current.getNext() != null ; i++) {
			current = current.getNext();
		}
		
		newNode.setNext(current.getNext());
		current.setNext(newNode);
	}
	
	public void remove(int data) {
		if(head == null) {
			return;
		}
		
		if(head.getData() == data) {
			head = head.getNext();
			return;
		}
		
		ListNode current = head;
		ListNode prev = null;
		while(current != null) {
			if(current.getData() == data) {
				prev.setNext(current.getNext());
				return;    
			}
			prev = current;
			current = current.getNext();
		}
	}
	
	public void reverse() {
		ListNode current = head;
		ListNode prev = null;
		ListNode next;
		while(current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		head = prev;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append('[');
		ListNode current = head;
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
		ListNode current = head;
		int i = 0;
		while(current != null) {
			array[i] = current.getData();
			current = current.getNext();
			i++;
		}
		
		return array;
	}
	
	
}
