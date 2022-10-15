package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_2181_Merge_Nodes_in_Between_Zeros {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public ListNode mergeNodes_1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		
		int sum = 0;
		
		while (fast.next != null) {
			sum += fast.val;
			
			fast = fast.next;
			
			if (fast.next != null && fast.val == 0) {
				slow.val = sum;
				
				sum = 0;
				
				slow.next = fast;
				slow = fast;
				fast = fast.next;
			}
		}
		
		if (sum > 0) {
			slow.val = sum;
			slow.next = null;
		}
		
		return head;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public ListNode mergeNodes_2(ListNode head) {
		ListNode current = head;
		
		while (current != null) {
			if (current.next.val != 0) {
				current.val = current.val + current.next.val;
				current.next = current.next.next;
			} else {
				current.next = current.next.next;
				current = current.next;
			}
		}
		
		return head;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/merge-nodes-in-between-zeros/discuss/1785026/Recursive-vs-Iterative-without-Dummy-oror-O(1)-Space-%2B-Intuition
	 * */
	public ListNode mergeNodes(ListNode head) {
		ListNode slow = head.next;
		ListNode fast = null;
		int sum = 0;
		
		while (slow != null) {
			fast = slow;
			sum = 0;
			
			while (fast.val != 0) {
				sum += fast.val;
				fast = fast.next;
			}
			
			slow.val = sum;
			slow.next = fast.next;
			slow = slow.next;
		}
		
		return head.next;
	}
	
}
