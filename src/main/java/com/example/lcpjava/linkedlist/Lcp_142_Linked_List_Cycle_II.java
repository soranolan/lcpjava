package com.example.lcpjava.linkedlist;

public class Lcp_142_Linked_List_Cycle_II {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Floy'd Cycle Detection Algorithm
	 * 
	 * ListNode slow <- head
	 * ListNode fast <- head
	 * boolean isCycle <- false
	 * 
	 * while fast is not equal to null && fast next is not equal to null
	 * 		slow <- slow next
	 * 		fast <- fast next next
	 * 		if slow is equal to fast
	 * 			isCycle <- true
	 * 			break
	 * 		end if
	 * end while
	 * 
	 * if isCycle is equal to false
	 * 		return null
	 * end if
	 * 
	 * slow <- head
	 * 
	 * while slow is not equal to fast
	 * 		slow <- slow next
	 * 		fast <- fast next
	 * end while
	 * 
	 * return slow
	 * */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;
		
		while (fast != null && fast.next != null) {																	// T : O(n)
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				isCycle = true;
				break;
			}
		}
		
		if (isCycle == false) { return null; }
		
		slow = head;
		
		while (slow != fast) {																						// T : O(n)
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
}
