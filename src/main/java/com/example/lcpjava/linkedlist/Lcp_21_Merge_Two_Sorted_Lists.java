package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_21_Merge_Two_Sorted_Lists {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode head <- new ListNode
	 * ListNode tail <- head
	 * 
	 * while l1 is not equal to null && l2 is not equal to null
	 * 		if l1 val is lower than or equal to l2 val
	 * 			tail next <- l1
	 * 			l1 <- l1 next
	 * 		else
	 * 			tail next <- l2
	 * 			l2 <- l2 next
	 * 		end if
	 * 		
	 * 		tail <- tail next
	 * end while
	 * 
	 * if l1 is not equal to null
	 * 		tail next <- l1
	 * else if l2 is not equal to null
	 * 		tail next <- l2
	 * end if
	 * 
	 * return head next
	 * */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		while (l1 != null && l2 != null) {																			// T : O(n)
			if (l1.val <= l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			
			tail = tail.next;
		}
		
		if (l1 != null) {
			tail.next = l1;
		} else if (l2 != null) {
			tail.next = l2;
		}
		
		return head.next;
	}
	
}
