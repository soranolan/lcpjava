package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_237_Delete_Node_in_a_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public void deleteNode_1(ListNode node) {
		ListNode current = node;
		
		while (current.next.next != null) {																			// T : O(n)
			current.val = current.next.val;
			current = current.next;
		}
		
		current.val = current.next.val;
		current.next = null;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * 
	 * Solution Tab
	 * */
	public void deleteNode(ListNode node) {
		ListNode current = node;
		current.val = current.next.val;
		current.next = current.next.next;
	}
	
}
