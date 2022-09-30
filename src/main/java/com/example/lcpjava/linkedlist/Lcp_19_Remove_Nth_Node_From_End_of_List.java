package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_19_Remove_Nth_Node_From_End_of_List {
	
	/**
	 * time  : O(m)
	 * space : O(1)
	 * */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode slow = dummy;
		ListNode fast = dummy;
		
		while (n > 0) {																								// T : O(n)
			fast = fast.next;
			n--;
		}
		
		while (fast.next != null) {
			slow = slow.next;																						// T : O(m - n)
			fast = fast.next;																						// T : O(m - n)
		}
		
		slow.next = slow.next.next;
		
		return dummy.next;
	}
	
}
