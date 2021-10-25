package com.example.lcpjava.linkedlist;

public class Lcp_206_Reverse_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * if head is equal to null || head next is equal to null
	 * 		return head
	 * end if
	 * 
	 * ListNode newHead <- head
	 * 
	 * while head next is not equal to null
	 * 		ListNode temp <- head next
	 * 		head next <- head next next
	 * 		temp next <- newHead
	 * 		newHead <- temp
	 * end while
	 * 
	 * return newHead
	 * */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) { return head; }
		
		ListNode newHead = head;
		
		while (head.next != null) {																					// T : O(n)
			ListNode temp = head.next;
			head.next = head.next.next;
			temp.next = newHead;
			newHead = temp;
		}
		
		return newHead;
	}
	
}
