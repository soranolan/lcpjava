package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_141_Linked_List_Cycle {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode slow <- head
	 * ListNode fast <- head
	 * 
	 * while fast is not equal to null && fast next is not equal to null
	 * 		slow <- slow next
	 * 		fast <- fast next next
	 * 		if slow is equal to fast
	 * 			return true
	 * 		end if
	 * end while
	 * 
	 * return false
	 * */
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {																	// T : O(n)
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { return true; }
		}
		
		return false;
	}
	
}
