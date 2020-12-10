package datastructures.linkedlist;

public class Rearrange {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		int arr[] = {1,2,3};
		for(int num: arr) {
			sll.insertAtEnd(num);
		}
		System.out.println(sll);
		ListNode head = reorderList(sll.head);
		System.out.println(new SinglyLinkedList(head));
	}
	
	 public static ListNode reorderList(ListNode A) {
		 if(A.next == null) {
			 return A;
		 }
		 ListNode middle = middle(A);
		 ListNode reverseHead = reverse(middle);
		 ListNode current = A;
		 ListNode revCurrent = reverseHead;
		 ListNode prev = null;
		 while(current != null && revCurrent != null) {
			 ListNode curNext = current.next;
			 current.next = revCurrent;
			 ListNode revNext = revCurrent.next;
			 revCurrent.next = curNext;
			 current = curNext;
			 prev = revCurrent;
			 revCurrent = revNext;
		 }
		 if(prev != null) {
			 prev.next = revCurrent;
		 }
		 
		 return A;
	    }
	 
	 static ListNode middle(ListNode head) {
			if(head == null) {
				return null;
			}
			
			ListNode slow = head;
			ListNode fast = head;
			ListNode prev = null;
			while(fast!= null && fast.getNext()!= null) {
				prev = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			if(prev != null) {
				prev.setNext(null);

			}
			return slow;
		}
	 
	 public static ListNode reverse(ListNode head) {
			ListNode current = head;
			ListNode prev = null;
			ListNode next;
			while(current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			
			head = prev;
			return head;
		}
	 
	 
	 public ListNode swapPairs(ListNode A) {
	        if(A == null){
	            return null;
	        }
	        if(A.next == null){
	            return A;
	        }
	        ListNode prev = A;
	        ListNode curr = A.next;
	        ListNode curTail = null;
	        ListNode head = curr;
	        while(prev != null && curr != null){
	            ListNode next = curr.next;
	            curr.next = prev;
	            if(curTail != null){
	                curTail.next = curr;
	            }
	            curTail = prev;
	            prev = next;
	            if(next != null){
	                curr = next.next;
	            }
	            else{
	                curr = null;
	            }
	        }
	        if(curr == null){
	            curTail.next = prev;
	        }
	        return head;
	    }
	 
	 public ListNode swapPairsRec(ListNode A) {
	        if(A == null){
	            return null;
	        }
	        if(A.next == null){
	            return A;
	        }
	        ListNode restHead = swapPairsRec(A.next.next);
	        ListNode temp = A.next;
	        temp.next = A;
	        A.next = restHead;
	        return temp;
	        
	    }
	 
	 
	 public int lPalin(ListNode A) {
	        int ans = 1;
	        if(A.next == null){
	            return 1;
	        }
	        
	        int size = size(A);
	        ListNode middle = middle(A);
	        
	        ListNode head2 = middle;
	        if(size % 2 == 1){
	            head2 = middle.next;
	        }
	        ListNode cur1 = A;
	        head2 = reverse(head2);
	        
	        ListNode cur2 = head2;
	        while(cur1 != middle && cur2 != null){
	            if(cur1.data != cur2.data){
	                ans = 0;
	                break;
	            }
	            cur1 = cur1.next;
	            cur2 = cur2.next;
	        }
	        
	        head2 = reverse(head2);
	        return ans;
	        
	    }
	 
	 public int size(ListNode head) {
			int size = 0;
			ListNode current = head;
			while(current != null) {
				current = current.getNext();
				size++;
			}
			
			return size;
		}
	 
	 public ListNode partition(ListNode A, int B) {
	        if(A.next == null){
	            return A;
	        }
	        ListNode headL = new ListNode(0);
	        ListNode headR = new ListNode(0);
	        ListNode cur = A;
	        ListNode curL = headL;
	        ListNode curR = headR;
	        while(cur != null){
	            if(cur.data < B){
	                curL.next = cur;
	                curL = curL.next;
	            }
	            else{
	                curR.next = cur;
	                curR = curR.next;
	            }
	            cur = cur.next;
	        }
	        curL.next = headR.next;
	        curR.next = null;
	        return headL.next;
	    }
	 
		

}
