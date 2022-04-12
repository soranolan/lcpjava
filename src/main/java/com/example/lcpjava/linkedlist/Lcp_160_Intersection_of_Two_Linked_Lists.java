package com.example.lcpjava.linkedlist;

import com.example.lcpjava.common.ListNode;

public class Lcp_160_Intersection_of_Two_Linked_Lists {
	
	/**
	 * time  : O(m + n)
	 * space : O(1)
	 * 
	 * ListNode nodeA <- headA
	 * ListNode nodeB <- headB
	 * 
	 * while nodeA is not equal to nodeB
	 * 		nodeA <- if nodeA is equal to null then headB else nodeA next
	 * 		nodeB <- if nodeB is equal to null then headA else nodeB next
	 * end while
	 * 
	 * return nodeA
	 * */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		
		while (nodeA != nodeB) {
			nodeA = (nodeA == null) ? headB : nodeA.next;															// T : O(m)
			nodeB = (nodeB == null) ? headA : nodeB.next;															// T : O(n)
		}
		
		return nodeA;
	}
	
}
