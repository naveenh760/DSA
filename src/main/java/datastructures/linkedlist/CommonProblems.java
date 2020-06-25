package datastructures.linkedlist;

import java.util.HashSet;

public class CommonProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean detectLoop(ListNode head) {
		ListNode current = head;
		HashSet<ListNode> hs = new HashSet<ListNode>();

		while (current != null) {
			if (hs.contains(current)) {
				return true;
			}
			hs.add(current);
			current = current.getNext();
		}
		return false;
	}

	public boolean detectLoopFloyd(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public void removeTheLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast) {
			return;
		}
		slow = head;
		while (slow.getNext() != fast.getNext()) {
			slow = slow.getNext();
			fast = fast.getNext();
		}
		fast.setNext(null);
	}

	public int countNodesinLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast) {
			return 0;
		}
		
		int count = 0;
		while(true) {
		  fast = fast.getNext();
		  count++;
		  if(fast == slow) {
			  break;
		  }
		}
		return count;
	}

}
