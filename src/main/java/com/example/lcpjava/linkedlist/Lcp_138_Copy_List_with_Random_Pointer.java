package com.example.lcpjava.linkedlist;

import java.util.HashMap;
import java.util.Map;

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
	public Node copyRandomList_1(Node head) {
		Node original = head;
		Node temp = null;
		
		while (original != null) {																					// T : O(n)
			temp = original.next;
			
			Node newNode = new Node(original.val);																	// S : O(n)
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
		Node newHead = new Node(0);
		Node newTail = newHead;
		
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
	
	Map<Node, Node> memo = new HashMap<>();
	
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
	public Node copyRandomList(Node head) {
		if (head == null) { return head; }
		if (memo.containsKey(head)) { return memo.get(head); }
		
		Node newNode = new Node(head.val);
		memo.put(head, newNode);
		
		newNode.next = copyRandomList(head.next);
		newNode.random = copyRandomList(head.random);
		
		return newNode;
	}
	
}
