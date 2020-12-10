package datastructures.linkedlist;

public class ListNode {

	public int data;
	public ListNode next;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
	
}
