package com.example.lcpjava.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.example.lcpjava.common.ListNode;

public class Lcp_234_Palindrome_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> container <- empty ArrayList
	 * 
	 * ListNode current <- head
	 * while current is not equal to null
	 * 		container add current val
	 * 		current <- current next
	 * end while
	 * 
	 * int left <- 0
	 * int right <- container size
	 * 
	 * while left is lower than right
	 * 		if container get(left) is not equal to container get(right minus one)
	 * 			return false
	 * 		end if
	 * 		left++
	 * 		right--
	 * end while
	 * 
	 * return true
	 * */
	public boolean isPalindrome_1(ListNode head) {
		List<Integer> container = new ArrayList<>();
		
		ListNode current = head;
		while (current != null) {																					// T : O(n)
			container.add(current.val);																				// T : O(1); S : O(n)
			current = current.next;
		}
		
		int left = 0;
		int right = container.size();
		
		while (left < right) {																						// T : O(n)
			if (container.get(left) != container.get(right - 1)) { return false; }									// T : O(1)
			left++;
			right--;
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * if head is equal to null || head next is equal to null
	 * 		return true
	 * end if
	 * 
	 * ListNode firstTail <- findFirstTail(head)
	 * ListNode secondHead <- reverse(firstTail next)
	 * 
	 * ListNode first <- head
	 * ListNode second <- secondHead
	 * 
	 * while second is not equal to null
	 * 		if first val is not equal to second val
	 * 			return false
	 * 		end if
	 * 		first <- first next
	 * 		second <- second next
	 * end while
	 * 
	 * return true
	 * */
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) { return true; }
		
		ListNode firstTail = findFirstTail(head);																	// T : O(n)
		ListNode secondHead = reverse(firstTail.next);																// T : O(n)
		
		ListNode first = head;
		ListNode second = secondHead;
		
		while (second != null) {																					// T : O(n)
			if (first.val != second.val) { return false; }
			first = first.next;
			second = second.next;
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode slow <- head
	 * ListNode fast <- head
	 * 
	 * while fast next is not equal to null && fast next next is not equal to null
	 * 		slow <- slow next
	 * 		fast <- fast next next
	 * end while
	 * 
	 * return slow
	 * */
	public ListNode findFirstTail(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {														// T : O(n)
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode current <- head
	 * ListNode newHead <- head
	 * 
	 * while current next is not equal to null
	 * 		ListNode temp <- current next
	 * 		current next <- current next next
	 * 		temp next <- newHead
	 * 		newHead <- temp
	 * end while
	 * 
	 * return newHead
	 * */
	public ListNode reverse(ListNode head) {
		ListNode current = head;
		ListNode newHead = head;
		
		while (current.next != null) {																				// T : O(n)
			ListNode temp = current.next;
			current.next = current.next.next;
			temp.next = newHead;
			newHead = temp;
		}
		
		return newHead;
	}
	
}
