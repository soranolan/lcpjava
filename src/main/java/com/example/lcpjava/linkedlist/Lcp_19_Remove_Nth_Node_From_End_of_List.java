package com.example.lcpjava.linkedlist;

public class Lcp_19_Remove_Nth_Node_From_End_of_List {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * ListNode newHead <- new node
	 * newHead next <- head
	 * 
	 * ListNode slow <- newHead
	 * ListNode fast <- newHead
	 * 
	 * while n is greater than zero
	 * 		fast <- fast next
	 * 		n--
	 * end while
	 * 
	 * while fast next is not equal to null
	 * 		slow <- slow next
	 * 		fast <- fast next
	 * end while
	 * 
	 * slow next <- slow next next
	 * 
	 * return newHead next
	 * */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		
		ListNode slow = newHead;
		ListNode fast = newHead;
		
		while (n > 0) {																								// T : O(n)
			fast = fast.next;
			n--;
		}
		
		while (fast.next != null) {																					// T : O(n)
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		
		return newHead.next;
	}
	
}
