package com.example.lcpjava.linkedlist;

public class Lcp_328_Odd_Even_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * if head is equal to null
	 * 		return head
	 * end if
	 * 
	 * ListNode odd <- head
	 * ListNode even <- head next
	 * ListNode evenHead <- head next
	 * 
	 * while even is not equal to null && even next is not equal to null
	 * 		odd next <- odd next next
	 * 		even next <- even next next
	 * 		odd <- odd next
	 * 		even <- even next
	 * end while
	 * 
	 * odd next <- evenHead
	 * 
	 * return head
	 * */
	public ListNode oddEvenList(ListNode head) {
		if (head == null) { return head; } 
		
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = head.next;
		
		while (even != null && even.next != null) {																	// T : O(n)
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
		
		return head;
	}
	
}
