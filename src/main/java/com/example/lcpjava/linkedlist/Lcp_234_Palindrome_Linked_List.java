package com.example.lcpjava.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.ListNode;

public class Lcp_234_Palindrome_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/palindrome-linked-list/discuss/1137696/Short-and-Easy-w-Explanation-or-T-%3A-O(N)-S-%3A-O(1)-Solution-using-Fast-and-Slow
	 * */
	public boolean isPalindrome_1(ListNode head) {
		Stack<Integer> stack = new Stack<>();																		// S : O(n)
		
		ListNode current = head;
		while (current != null) {																					// T : O(n)
			stack.push(current.val);
			current = current.next;
		}
		
		current = head;
		while (!stack.isEmpty()) {																					// T : O(n)
			if (stack.pop() != current.val) { return false; }
			current = current.next;
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n / 2)
	 * 
	 * https://leetcode.com/problems/palindrome-linked-list/discuss/148220/Javathe-clear-method-with-stack
	 * */
	public boolean isPalindrome_2(ListNode head) {
		Stack<Integer> stack = new Stack<>();																		// S : O(n / 2)
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {																	// T : O(n / 2)
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// if n is odd
		if (fast != null) { slow = slow.next; }
		
		while (slow != null) {																						// T : O(n / 2)
			if (!stack.isEmpty() && stack.pop() != slow.val) { return false; }
			slow = slow.next;
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/palindrome-linked-list/discuss/1610149/C%2B%2B-or-Two-Approaches-with-explanation-or-O(N)-Solution-or-Easy-to-understand
	 * */
	public boolean isPalindrome_3(ListNode head) {
		List<Integer> bucket = new ArrayList<>();																	// S : O(n)
		
		ListNode current = head;
		while (current != null) {																					// T : O(n)
			bucket.add(current.val);																				// T : O(1);
			current = current.next;
		}
		
		int left = 0;
		int right = bucket.size();
		
		while (left < right) {																						// T : O(n)
			if (bucket.get(left) != bucket.get(right - 1)) { return false; }										// T : O(1)
			left++;
			right--;
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
	 * */
	public boolean isPalindrome(ListNode head) {
		ListNode rightPart = findRightPart(head);																	// T : O(n / 2)
		
		ListNode right = reverse(rightPart);																		// T : O(n / 2)
		
		ListNode left = head;
		
		while (right != null) {																						// T : O(n / 2)
			if (left.val != right.val) { return false; }
			left = left.next;
			right = right.next;
		}
		
		return true;
	}
	
	private ListNode findRightPart(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {																	// T : O(n / 2)
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode newHead = head;
		ListNode current = head;
		
		while (current.next != null) {																				// T : O(n / 2)
			ListNode nextNode = current.next;
			current.next = current.next.next;
			
			nextNode.next = newHead;
			newHead = nextNode;
		}
		
		return newHead;
	}
	
}
