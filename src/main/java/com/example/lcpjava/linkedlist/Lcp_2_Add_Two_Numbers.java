package com.example.lcpjava.linkedlist;

public class Lcp_2_Add_Two_Numbers {
	
	/**
	 * time  : O(max(m, n))
	 * space : O(max(m, n))
	 * 
	 * ListNode head <- new ListNode(0)
	 * ListNode tail <- head
	 * int carry <- 0
	 * 
	 * while l1 is not equal to null || l2 is not equal to null
	 * 		int v1 <- if l1 is equal to null then zero else l1 val
	 * 		int v2 <- if l2 is equal to null then zero else l2 val
	 * 		int sum <- l1 val plus l2 val plus carry
	 * 		carry <- sum divided by ten
	 * 		
	 * 		if sum is lower than and equal to nine
	 * 			tail next <- new ListNode(sum)
	 * 		else
	 * 			tail next <- new ListNode(sum modulo ten)
	 * 		end if
	 * 		
	 * 		if l1 is not equal to null
	 * 			l1 <- l1 next
	 * 		end if
	 * 		if l2 is not equal to null
	 * 			l2 <- l2 next
	 * 		end if
	 * 		tail <- tail next
	 * end while
	 * 
	 * if carry is not equal to zero
	 * 		tail next <- new ListNode(carry)
	 * end if
	 * 
	 * return head next
	 * */
	public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);																			// S : O(n)
		ListNode tail = head;
		int carry = 0;
		
		while (l1 != null || l2 != null) {																			// T : O(n)
			int v1 = (l1 == null) ? 0 : l1.val;
			int v2 = (l2 == null) ? 0 : l2.val;
			int sum = v1 + v2 + carry;
			carry = sum / 10;
			
			if (sum <= 9) {
				tail.next = new ListNode(sum);
			} else {
				tail.next = new ListNode(sum % 10);
			}
			
			if (l1 != null) { l1 = l1.next; }
			if (l2 != null) { l2 = l2.next; }
			tail = tail.next;
		}
		
		if (carry != 0) { tail.next = new ListNode(carry); }
		
		return head.next;
	}
	
	/**
	 * time  : O(max(m, n))
	 * space : O(max(m, n))
	 * 
	 * ListNode head <- new ListNode(0)
	 * ListNode tail <- head
	 * int carry <- 0
	 * 
	 * while l1 is not equal to null || l2 is not equal to null
	 * 		int v1 <- 0
	 * 		int v2 <- 0
	 * 		
	 * 		if l1 is not equal to null
	 * 			v1 <- l1 val
	 * 			l1 <- l1 next
	 * 		end if
	 * 		
	 * 		if l2 is not equal to null
	 * 			v2 <- l2 val
	 * 			l2 <- l2 next
	 * 		end if
	 * 		
	 * 		int sum <- v1 plus v2 plus carry
	 * 		carry <- sum divided by ten
	 * 		sum <- sum modulo ten
	 * 		
	 * 		tail next <- new ListNode(sum)
	 * 		tail <- tail next
	 * end while
	 * 
	 * if carry is not equal to zero
	 * 		tail next <- new ListNode(carry)
	 * end if
	 * 
	 * return head next
	 * */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);																			// S : O(n)
		ListNode tail = head;
		int carry = 0;
		
		while (l1 != null || l2 != null) {																			// T : O(n)
			int v1 = 0;
			int v2 = 0;
			
			if (l1 != null) {
				v1 = l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				v2 = l2.val;
				l2 = l2.next;
			}
			
			int sum = v1 + v2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			
			tail.next = new ListNode(sum);
			tail = tail.next;
		}
		
		if (carry != 0) { tail.next = new ListNode(carry); }
		
		return head.next;
	}
	
}
