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
	public ListNode rotateRight_1(ListNode head, int k) {
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
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * if head is equal to null
	 * 		return head
	 * end if
	 * 
	 * ListNode newTail <- head
	 * int size <- 1
	 * while newTail next is not equal to null
	 * 		newTail <- newTail next
	 * 		size++
	 * end while
	 * 
	 * newTail next <- head
	 * k <- k mod size
	 * int target <- size minus k
	 * while target is greater than zero
	 * 		newTail <- newTail next
	 * 		target--
	 * end while
	 * 
	 * head <- newTail next
	 * newTail next <- null
	 * 
	 * return head
	 * */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) { return head; }
		
		ListNode newTail = head;
		int size = 1;
		while (newTail.next != null) {																				// T : O(n)
			newTail = newTail.next;
			size++;
		}
		
		newTail.next = head;
		k %= size;
		int target = size - k;
		while (target > 0) {																						// T : O(m)
			newTail = newTail.next;
			target--;
		}
		
		head = newTail.next;
		newTail.next = null;
		return head;
	}
	
}
