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
	 * 			if current left is not equal to null
	 * 				queue offer(current left)
	 * 			end if
	 * 			
	 * 			if current right is not equal to null
	 * 				queue offer(current right)
	 * 			end if
	 * 		end while
	 * end while
	 * 
	 * return root
	 * */
	public Node connect_1(Node root) {
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
				
				if (current.left != null) { queue.offer(current.left); }											// T : O(1)
				if (current.right != null) { queue.offer(current.right); }											// T : O(1)
			}
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * DFS(root left, root right)
	 * 
	 * return root
	 * */
	public Node connect_2(Node root) {
		if (root == null) { return null; }
		DFS_1(root.left, root.right);
		return root;
	}
	
	/**
	 * if left is equal to null || right is equal to null
	 * 		return
	 * end if
	 * 
	 * if left next is not equal to null
	 * 		return
	 * end if
	 * 
	 * left next <- right
	 * 
	 * DFS(left left, left right)
	 * DFS(left right, right left)
	 * DFS(right left, right right)
	 * */
	public void DFS_1(Node left, Node right) {
		if (left == null || right == null) { return; }
		if (left.next != null) { return; }
		left.next = right;
		DFS_1(left.left, left.right);
		DFS_1(left.right, right.left);
		DFS_1(right.left, right.right);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * DFS(root, null)
	 * 
	 * return root
	 * */
	public Node connect(Node root) {
		DFS(root, null);
		return root;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * current next <- nextNode
	 * 
	 * DFS(current left, current right)
	 * DFS(current right, if current next is equal to null then null else current next left)
	 * */
	public void DFS(Node current, Node nextNode) {
		if (current == null) { return; }
		current.next = nextNode;
		DFS(current.left, current.right);
		DFS(current.right, current.next == null ? null : current.next.left);
	}
	
}
