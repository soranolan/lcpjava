package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_92_Reverse_Linked_List_II {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode leftPart = findPrevious(dummy, left);																// T : O(left - 1)
		ListNode subHead = leftPart.next;
		ListNode subTail = findPrevious(dummy, right).next;															// T : O(right - 1)
		
		ListNode rightPart = subTail.next;
		subTail.next = null;
		
		ListNode reversePart = reverseList(subHead);																// T : O(right - left)
		
		leftPart.next = reversePart;
		subHead.next = rightPart;
		
		return dummy.next;
	}
	
	private ListNode findPrevious(ListNode head, int target) {
		int index = 1;
		ListNode current = head;
		
		while (index < target) {
			current = current.next;
			index++;
		}
		
		return current;
	}
	
	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) { return head; }
		
		ListNode newHead = head;
		
		while (head.next != null) {
			ListNode nextNode = head.next;
			head.next = head.next.next;
			nextNode.next = newHead;
			newHead = nextNode;
		}
		
		return newHead;
	}
	
}
