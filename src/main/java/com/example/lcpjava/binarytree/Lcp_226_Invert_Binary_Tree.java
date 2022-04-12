package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_226_TreeNode;

public class Lcp_226_Invert_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return root
	 * end if
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * stack push(root)
	 * 
	 * while stack is not empty
	 * 		TreeNode current <- stack pop
	 * 		TreeNode left <- current left
	 * 		TreeNode right <- current right
	 * 		
	 * 		current left <- right
	 * 		current right <- left
	 * 		
	 * 		if left is not equal to null
	 * 			stack push(left)
	 * 		end if
	 * 		
	 * 		if right is not equal to null
	 * 			stack push(right)
	 * 		end if
	 * end while
	 * 
	 * return root
	 * */
	public Lcp_226_TreeNode invertTree_1(Lcp_226_TreeNode root) {
		if (root == null) { return root; }
		
		Stack<Lcp_226_TreeNode> stack = new Stack<>();																// S : O(n)
		stack.push(root);																							// T : O(1)
		
		while (!stack.isEmpty()) {																					// T : O(n)
			Lcp_226_TreeNode current = stack.pop();																	// T : O(1)
			Lcp_226_TreeNode left = current.left;
			Lcp_226_TreeNode right = current.right;
			
			current.left = right;
			current.right = left;
			
			if (left != null) { stack.push(left); }																	// T : O(1)
			if (right != null) { stack.push(right); }																// T : O(1)
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return root
	 * end if
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * while queue is not empty
	 * 		TreeNode current <- queue poll
	 * 		TreeNode left <- current left
	 * 		TreeNode right <- current right
	 * 		
	 * 		current left <- right
	 * 		current right <- left
	 * 		
	 * 		if left is not equal to null
	 * 			queue offer(left)
	 * 		end if
	 * 		
	 * 		if right is not equal to null
	 * 			queue offer(right)
	 * 		end if
	 * end while
	 * 
	 * return root
	 * */
	public Lcp_226_TreeNode invertTree_2(Lcp_226_TreeNode root) {
		if (root == null) { return root; }
		
		Queue<Lcp_226_TreeNode> queue = new LinkedList<>();															// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			Lcp_226_TreeNode current = queue.poll();																// T : O(1)
			Lcp_226_TreeNode left = current.left;
			Lcp_226_TreeNode right = current.right;
			
			current.left = right;
			current.right = left;
			
			if (left != null) { queue.offer(left); }																// T : O(1)
			if (right != null) { queue.offer(right); }																// T : O(1)
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * return DFS(root)
	 * */
	public Lcp_226_TreeNode invertTree(Lcp_226_TreeNode root) {
		return DFS(root);
	}
	
	/**
	 * if current is equal to null
	 * 		return null
	 * end if
	 * 
	 * TreeNode left <- current left
	 * TreeNode right <- current right
	 * 
	 * current left <- DFS(right)
	 * current right <- DFS(left)
	 * 
	 * return current
	 * */
	public Lcp_226_TreeNode DFS(Lcp_226_TreeNode current) {
		if (current == null) { return null; }
		
		Lcp_226_TreeNode left = current.left;
		Lcp_226_TreeNode right = current.right;
		
		current.left = DFS(right);
		current.right = DFS(left);
		
		return current;
	}
	
}
