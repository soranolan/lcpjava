package com.example.lcpjava.linkedlist;

public class Lcp_430_Flatten_a_Multilevel_Doubly_Linked_List {
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Node parent <- head
	 * 
	 * while parent is not equal to null
	 * 		if parent child is equal to null
	 * 			parent <- parent next
	 * 			continue
	 * 		end if
	 * 		
	 * 		Node child <- parent child
	 * 		while child next is not equal to null
	 * 			child <- child next
	 * 		end while
	 * 		
	 * 		child next <- parent next
	 * 		if parent next is not equal to null
	 * 			parent next prev <- child
	 * 		end if
	 * 		
	 * 		parent next <- parent child
	 * 		parent child prev <- parent;
	 * 		parent child <- null
	 * end while
	 * 
	 * return head
	 * */
	public Node flatten(Node head) {
		Node parent = head;
		
		while (parent != null) {																					// T : O(n)
			if (parent.child == null) {
				parent = parent.next;
				continue;
			}
			
			Node child = parent.child;
			while (child.next != null) { child = child.next; }														// T : O(n)
			
			child.next = parent.next;
			if (parent.next != null) { parent.next.prev = child; }
			
			parent.next = parent.child;
			parent.child.prev = parent;
			parent.child = null;
		}
		
		return head;
	}
	
}
