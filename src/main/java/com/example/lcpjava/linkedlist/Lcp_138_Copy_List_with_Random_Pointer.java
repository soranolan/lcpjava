package com.example.lcpjava.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.example.lcpjava.common.Lcp_138_Node;

public class Lcp_138_Copy_List_with_Random_Pointer {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Node original <- head
	 * Node temp <- null
	 * 
	 * while original is not equal to null
	 * 		temp <- original next
	 * 		
	 * 		Node newNode <- new Node(original val)
	 * 		original next <- newNode
	 * 		newNode next <- temp
	 * 		
	 * 		original <- original next next
	 * end while
	 * 
	 * original <- head
	 * while original is not equal to null
	 * 		if original random is not equal to null
	 * 			original next random <- original random next
	 * 		end if
	 * 		
	 * 		original <- original next next
	 * end while
	 * 
	 * original <- head
	 * Node newHead <- empty Node
	 * Node newTail <- newHead
	 * 
	 * while original is not equal to null
	 * 		temp <- orignal next
	 * 		newTail next <- temp
	 * 		newTail <- newTail next
	 * 		
	 * 		temp <- original next next
	 * 		original next <- temp
	 * 		original <- original next
	 * end while
	 * 
	 * return newHead next
	 * */
	public Lcp_138_Node copyRandomList_1(Lcp_138_Node head) {
		Lcp_138_Node original = head;
		Lcp_138_Node temp = null;
		
		while (original != null) {																					// T : O(n)
			temp = original.next;
			
			Lcp_138_Node newNode = new Lcp_138_Node(original.val);													// S : O(n)
			original.next = newNode;
			newNode.next = temp;
			
			original = original.next.next;
		}
		
		original = head;
		while (original != null) {																					// T : O(n)
			if (original.random != null) { original.next.random = original.random.next; }
			original = original.next.next;
		}
		
		original = head;
		Lcp_138_Node newHead = new Lcp_138_Node(0);
		Lcp_138_Node newTail = newHead;
		
		while (original != null) {																					// T : O(n)
			temp = original.next;
			newTail.next = temp;
			newTail = newTail.next;
			
			temp = original.next.next;
			original.next = temp;
			original = original.next;
		}
		
		return newHead.next;
	}
	
	Map<Lcp_138_Node, Lcp_138_Node> memo = new HashMap<>();
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<Node, Node> memo <- empty HashMap
	 * 
	 * if head is equal to null
	 * 		return head
	 * end if
	 * 
	 * if memo containsKey(head)
	 * 		return memo get(head)
	 * end if
	 * 
	 * Node newNode <- new Node(head val)
	 * memo put(head, newNode)
	 * 
	 * newNode next <- copyRandomList(head next)
	 * newNode random <- copyRandomList(head random)
	 * 
	 * return newNode
	 * */
	public Lcp_138_Node copyRandomList(Lcp_138_Node head) {
		if (head == null) { return head; }
		if (memo.containsKey(head)) { return memo.get(head); }
		
		Lcp_138_Node newNode = new Lcp_138_Node(head.val);
		memo.put(head, newNode);
		
		newNode.next = copyRandomList(head.next);
		newNode.random = copyRandomList(head.random);
		
		return newNode;
	}
	
}
