package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_206_Reverse_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) { return head; }
		
		ListNode newHead = head;
		
		while (head.next != null) {																					// T : O(n)
			ListNode nextNode = head.next;
			head.next = head.next.next;
			nextNode.next = newHead;
			newHead = nextNode;
		}
		
		return newHead;
	}
	
}
