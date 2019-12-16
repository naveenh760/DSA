package datastructures.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
	    list.insertAtBegin(3);
	    list.insertAtBegin(4);
		list.insertAtEnd(5);
		int[] array = list.toArray();
		for (int i : array) {
			System.out.print(i + " ");
		}
		

	}

}
