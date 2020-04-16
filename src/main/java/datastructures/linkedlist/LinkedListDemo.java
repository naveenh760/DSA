package datastructures.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
	//	slldemo();
	//	dlldemo();
		sllproblemsdemo1();
	}

	public static void slldemo() {
		SinglyLinkedList list = new SinglyLinkedList();
	    list.insertAtBegin(3);
	    list.insertAtBegin(4);
		list.insertAtEnd(5);
		System.out.println(list);
	}
	
	public static void dlldemo() {
		DoublyLinkedList list = new DoublyLinkedList();
	    list.insertAtBegin(3);
	    list.insertAtBegin(4);
	    list.insertAtEnd(5);
		System.out.println(list);
	}
	
	public static void sllproblemsdemo() {
		SllProblems list = new SllProblems();
	    list.insertAtBegin(3);
	    list.insertAtBegin(4);
		list.insertAtEnd(5);
		list.insertAtBegin(6);
		System.out.println(list);  // [6,4,3,5]
		
		SllProblems list1 = new SllProblems();
	    list1.insertAtBegin(3);
	    list.insertAtBegin(2);
		list.insertAtEnd(5);
		list.insertAtBegin(1);
		System.out.println(list);  
		
	//	System.out.println(list.checkSorted(list.getHead()));
	//	System.out.println(list1.checkSorted(list1.getHead()));
		
		list.setHead(list.recReverse(list.getHead()));
		System.out.println(list);
		list.setHead(list.recReverse1(list.getHead(),null));
		System.out.println(list);
	}
	
	public static void sllproblemsdemo1() {
		SllProblems list = new SllProblems();
	    list.insertAtBegin(3);
	    list.insertAtBegin(4);
		list.insertAtEnd(5);
		list.insertAtBegin(6);
		System.out.println(list);  // [6,4,3,5]
		
		SllProblems list1 = new SllProblems();
	    list1.insertAtBegin(3);
	    list1.insertAtBegin(2);
		list1.insertAtEnd(5);
		list1.insertAtBegin(1);
		System.out.println(list1);  
		
		list.setHead(list.recReverseK(list.getHead(), 2));
		System.out.println(list); 
		
		list1.reverseK(2);
		System.out.println(list1);
	
	}
}
