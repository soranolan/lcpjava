package com.example.lcpjava.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Lcp_1721_Swapping_Nodes_in_a_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> bucket <- new ArrayList
	 * ListNode dummy <- head
	 * while dummy is not equal to null
	 * 		bucket add(dummy val)
	 * 		dummy <- dummy next
	 * end while
	 * 
	 * int size <- bucket size
	 * int l <- k minus one
	 * int r <- size minus k
	 * int left <- bucket get(l)
	 * int right <- bucket get(r)
	 * bucket set(l, right)
	 * bucket set(r, left)
	 * 
	 * int index <- 0
	 * dummy <- head
	 * while dummy is not equal to null
	 * 		int number <= bucket get(index)
	 * 		
	 * 		if dummy val is not equal to number
	 * 			dummy val <- number
	 * 		end if
	 * 		
	 * 		dummy <- dummy next
	 * 		index++
	 * end while
	 * 
	 * return head
	 * */
	public ListNode swapNodes_1(ListNode head, int k) {
		List<Integer> bucket = new ArrayList<>();																	// S : O(n)
		ListNode dummy = head;
		while (dummy != null) {																						// T : O(n)
			bucket.add(dummy.val);																					// T : O(1)
			dummy = dummy.next;
		}
		
		int size = bucket.size();																					// T : O(1)
		int l = k - 1;
		int r = size - k;
		int left = bucket.get(l);																					// T : O(1)
		int right = bucket.get(r);																					// T : O(1)
		bucket.set(l, right);																						// T : O(1)
		bucket.set(r, left);																						// T : O(1)
		
		int index = 0;
		dummy = head;
		while (dummy != null) {																						// T : O(n)
			int num = bucket.get(index);																			// T : O(1)
			if (dummy.val != num) { dummy.val = num; }
			dummy = dummy.next;
			index++;
		}
		
		return head;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode slow <- head
	 * ListNode fast <- head
	 * ListNode left <- null
	 * ListNode right <- null
	 * 
	 * for int i <- 0; if i is lower than k minus one; i++
	 * 		fast <- fast next
	 * end for
	 * left <- fast
	 * 
	 * while fast next is not equal to null
	 * 		fast <- fast next
	 * 		slow <- slow next
	 * end while
	 * right <- slow
	 * 
	 * int temp <- left val
	 * left val <- right val
	 * right val <- temp
	 * 
	 * return head
	 * */
	public ListNode swapNodes_2(ListNode head, int k) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode left = null;
		ListNode right = null;
		
		for (int i = 0; i < k - 1; i++) { fast = fast.next; }														// T : O(k)
		left = fast;
		
		while (fast.next != null) {																					// T : O(n - k)
			fast = fast.next;
			slow = slow.next;
		}
		right = slow;
		
		int temp = left.val;
		left.val = right.val;
		right.val = temp;
		
		return head;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode dummy <- new ListNode(minus one)
	 * dummy next <- head
	 * 
	 * ListNode leftPrev <- dummy
	 * ListNode rightPrev <- dummy
	 * ListNode tail <- dummy
	 * 
	 * int index <- one
	 * while tail next is not equal to null
	 * 		if index is lower than k
	 * 			leftPrev <- leftPrev next
	 * 		end if
	 * 		
	 * 		if index is greater than k
	 * 			rightPrev <- rightPrev next
	 * 		end if
	 * 		
	 * 		tail <- tail next
	 * 		index++
	 * end while
	 * 
	 * ListNode left <- leftPrev next
	 * ListNode right <- rightPrev next
	 * 
	 * if left is equal to right
	 * 		return head
	 * end if
	 * 
	 * leftPrev next <- right
	 * rightPrev next <- left
	 * 
	 * ListNode temp <- left next
	 * left next <- right next
	 * right next <- temp
	 * 
	 * return dummy next
	 * */
	public ListNode swapNodes(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		
		ListNode leftPrev = dummy;
		ListNode rightPrev = dummy;
		ListNode tail = dummy;
		
		int index = 1;
		while (tail.next != null) {																					// T : O(n)
			if (index < k) { leftPrev = leftPrev.next; }
			if (index > k) { rightPrev = rightPrev.next; }
			tail = tail.next;
			index++;
		}
		
		ListNode left = leftPrev.next;
		ListNode right = rightPrev.next;
		
		if (left == right) { return head; }
		
		leftPrev.next = right;
		rightPrev.next = left;
		
		ListNode temp = left.next;
		left.next = right.next;
		right.next = temp;
		
		return dummy.next;
	}
	
}
