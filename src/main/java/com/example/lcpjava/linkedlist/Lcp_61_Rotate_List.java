package com.example.lcpjava.linkedlist;

public class Lcp_61_Rotate_List {
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * if head is equal to null
	 * 		return head
	 * end if
	 * 
	 * ListNode newHead <- new ListNode
	 * ListNode leftTail <- newHead
	 * ListNode rightTail <- newHead
	 * 
	 * newHead next <- head
	 * 
	 * int size <- 0
	 * while rightTail next is not equal to null
	 * 		rightTail <- rightTail next
	 * 		size++
	 * end while
	 * 
	 * k <- k mod size
	 * int target <- size minus k
	 * while target is greater than zero
	 * 		leftTail <- leftTail next
	 * 		target--
	 * end while
	 * 
	 * rightTail next <- newHead next
	 * newHead next <- leftTail next
	 * leftTail next <- null
	 * 
	 * return newHead next
	 * */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) { return head; }
		
		ListNode newHead = new ListNode(0);
		ListNode leftTail = newHead;
		ListNode rightTail = newHead;
		
		newHead.next = head;
		
		int size = 0;
		while (rightTail.next != null) {																			// T : O(n)
			rightTail = rightTail.next;
			size++;
		}
		
		k %= size;
		int target = size - k;
		while (target > 0) {																						// T : O(m)
			leftTail = leftTail.next;
			target--;
		}
		
		rightTail.next = newHead.next;
		newHead.next = leftTail.next;
		leftTail.next = null;
		
		return newHead.next;
	}
	
}
