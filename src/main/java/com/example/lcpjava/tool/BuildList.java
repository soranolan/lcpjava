package com.example.lcpjava.tool;

import com.example.lcpjava.common.ListNode;

public class BuildList {
	
	public ListNode singly(int[] input) {
		if (input.length == 0) { return null; }
		
		ListNode head = new ListNode(input[0]);
		ListNode current = head;
		
		for (int i = 1; i < input.length; i++) {
			current.next = new ListNode(input[i]);
			current = current.next;
		}
		
		return head;
	}
	
}
