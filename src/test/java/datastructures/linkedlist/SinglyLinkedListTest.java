package datastructures.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

	@Test
	void testInsertAtBegin() {
		int[] expected = {5,4,3};
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBegin(3);
		list.insertAtBegin(4);
		list.insertAtBegin(5);
		int[] actual = list.toArray();
		assertArrayEquals(expected, actual);
		
	}
	
	@Test
	void testInsertAtEnd() {
		int[] expected = {3,4,5};
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		
		int[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testInsertAtPos() {
		int[] expected = {3,5,4};
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtBegin(3);
		list.insertAtEnd(4);
		list.insertAtPos(5, 1);
		int[] actual = list.toArray();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testRemove() {
		int[] expected = {6,5};
		SinglyLinkedList list = new SinglyLinkedList();
		list.remove(5);
		list.insertAtBegin(3);
		list.remove(3);
		list.insertAtEnd(4);
		list.insertAtEnd(6);
		list.insertAtEnd(5);
		list.insertAtEnd(5);
		list.remove(4);
		list.remove(5);
		
		int[] actual = list.toArray();
		assertArrayEquals(expected, actual);
		
	}
	
	@Test
	void testReverse() {
		int[] expected = {5,4,3};
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertAtEnd(3);
		list.reverse();
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.reverse();
		int[] actual = list.toArray();
		assertArrayEquals(expected, actual);
		
		
	}

}
