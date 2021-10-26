package com.example.lcpjava.linkedlist;

public class Lcp_203_Remove_Linked_List_Elements {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * if head is null
	 * 		return head
	 * end if
	 * 
	 * ListNode newHead <- new ListNode zero
	 * newHead next <- head
	 * 
	 * ListNode current <- newHead
	 * 
	 * while current next is not equal to null
	 * 		if current next val is equal to val
	 * 			current next <- current next next
	 * 		else
	 * 			current <- current next
	 * 		end if
	 * end while
	 * 
	 * return newHead next
	 * */
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) { return head; }
		
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		
		ListNode current = newHead;
		
		while (current.next != null) {																				// T : O(n)
			if (current.next.val == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		
		return newHead.next;
	}
	
}
