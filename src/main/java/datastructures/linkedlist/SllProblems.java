 package datastructures.linkedlist;

public class SllProblems extends SinglyLinkedList{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	void printMiddleN() {
		if(this.head == null) {
			return;
		}
		
		int size = size();
		ListNode current = this.head;
		for(int i = 1; i <= size / 2; i++) {
			current = current.getNext();
		}
		System.out.println(current.getData());
		
	}
	
	
	void printMiddle() {
		if(this.head == null) {
			return;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast!= null && fast.getNext()!= null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		System.out.println(slow.getData());
	}
	
	
	void printNthFromLastN(int n) {
	  int size = size();
	  if(n > size) {
		  return;
	  }
	  ListNode current = head;
	  for(int i = 1; i <= size - n; i++) {
		  current = current.getNext();
	  }
	  System.out.println(current.getData());
		
	}
	
	void printNthFromLast(int n) {
		ListNode first = head;
		ListNode second = head;
		for(int i = 1; i <= n; i++) {
			if(first == null) {
				return;
			}
			first = first.getNext();
		}
		
		while(first != null) {
			first = first.getNext();
			second = second.getNext();
		}
		System.out.println(second.getData());
	}
	
	boolean checkSorted(ListNode head) {
		if(head == null || head.getNext() == null) {
			return true;
		}
		if(head.getData() <= head.getNext().getData() && checkSorted(head.getNext())) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	boolean checkSorted() {
		if(head == null) {
			return true;
		}
		ListNode current = head;
		while(current.getNext() != null) {
			if(current.getData() > current.getNext().getData()) {
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
	
	
	public ListNode recReverse(ListNode head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		
		ListNode restHead = recReverse(head.getNext());
		ListNode restTail = head.getNext();
		restTail.setNext(head);
		head.setNext(null);
		return restHead;
	}
	
	
	public ListNode recReverse1(ListNode curr, ListNode prev) {
		if(curr == null) {
			return prev;
		}
		
		ListNode next  = curr.getNext();
		curr.setNext(prev);
		return recReverse1(next, curr);
	}
	
	
	public ListNode recReverseK(ListNode head, int k) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		int count = 0;
		while(curr != null && count < k) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			ListNode restHead = recReverseK(next, k);
			head.setNext(restHead);
		}
		return prev;
	}
	
	
	public void reverseK(int k) {
		ListNode current = head; 
		ListNode firstOfPrevPass = null;
		boolean isFirstPass = true;
		
		while(current != null) {
			ListNode first = current;
			ListNode prev = null;
			int count = 0;
			while(current != null && count < k) {
				ListNode next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
				count++;
			}
			
			if(isFirstPass) {
				head = prev;
				isFirstPass = false;
			}
			else {
				firstOfPrevPass.setNext(prev);
			}
			firstOfPrevPass = first;
		}
	}
	
	public boolean isIdentical(ListNode head1, ListNode head2) {
		ListNode current1 = head1;
		ListNode current2 = head2;
		while(current1 != null && current2 != null) {
			if(current1.getData() != current2.getData()) {
				return false;
			}
			current1 = current1.getNext();
			current2 = current2.getNext();
		}
		
		if(current1 == null && current2 == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null){
            return B;
        }
        if(B == null){
            return A;
        }
        ListNode head = new ListNode(0);  
        ListNode tail = head;
        while(A != null && B!= null){
            if(A.data < B.data){
                tail.next = A;
                tail = tail.next;
                A = A.next;
            }
            else{
                tail.next = B;
                tail = tail.next;
                B = B.next;
            }
        }
        
        while(A != null){
            tail.next = A;
            tail = tail.next;
            A = A.next;
        }
        while(B != null){
            tail.next = B;
            tail = tail.next;
            B = B.next;
        }
        return head.next;
        
    }

}
