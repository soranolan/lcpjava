package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Lcp_116_Populating_Next_Right_Pointers_in_Each_Node {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * Queue<Node> queue <- new LinkedList
	 * queue offer(root left)
	 * queue offer(root right)
	 * 
	 * while queue is not empty
	 * 		Node previous <- null
	 * 		int size <- queue size
	 * 		
	 * 		while size is greater than zero
	 * 			size--
	 * 			Node current <- queue poll
	 * 			if current is equal to null
	 * 				continue
	 * 			end if
	 * 			
	 * 			if previous is not equal to null
	 * 				previous next <- current
	 * 			end if
	 * 			
	 * 			previous <- current
	 * 			
	 * 			queue offer(current left)
	 * 			queue offer(current right)
	 * 		end while
	 * end while
	 * 
	 * return root
	 * */
	public Node connect(Node root) {
		if (root == null) { return null; }
		
		Queue<Node> queue = new LinkedList<>();																		// S : O(n)
		queue.offer(root.left);																						// T : O(1)
		queue.offer(root.right);																					// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			Node previous = null;
			int size = queue.size();																				// T : O(1)
			while (size > 0) {
				size--;
				Node current = queue.poll();																		// T : O(1)
				if (current == null) { continue; }
				
				if (previous != null) { previous.next = current; }
				previous = current;
				
				queue.offer(current.left);																			// T : O(1)
				queue.offer(current.right);																			// T : O(1)
			}
		}
		
		return root;
	}
	
}
