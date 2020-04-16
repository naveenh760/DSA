package datastructures.linkedlist;

public class DListNode {
	
	private int data;
	private DListNode next;
	private DListNode prev;
		
	public DListNode(int data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DListNode getNext() {
		return next;
	}
	public void setNext(DListNode next) {
		this.next = next;
	}
	public DListNode getPrev() {
		return prev;
	}
	public void setPrev(DListNode prev) {
		this.prev = prev;
	}
	
	

}
