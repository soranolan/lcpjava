package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Lcp_513_Find_Bottom_Left_Tree_Value {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * TreeNode current <- root
	 * queue offer(current)
	 * 
	 * while queue is not empty
	 * 		current <- queue poll
	 * 		
	 * 		if current right is not equal to null
	 * 			queue offer(current right)
	 * 		end if
	 * 		
	 * 		if current left is not equal to null
	 * 			queue offer(current left)
	 * 		end if
	 * end while
	 * 
	 * return current val
	 * */
	public int findBottomLeftValue_1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		TreeNode current = root;
		queue.offer(current);																						// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			current = queue.poll();																					// T : O(1)
			if (current.right != null) { queue.offer(current.right); }												// T : O(1)
			if (current.left != null) { queue.offer(current.left); }												// T : O(1)
		}
		
		return current.val;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * max <- 0
	 * result <- 0
	 * 
	 * postorder(root, one)
	 * 
	 * return result
	 * */
	int max;
	int result;
	public int findBottomLeftValue(TreeNode root) {
		max = 0;
		result = 0;
		
		postorder(root, 1);
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * if depth is greater than max
	 * 		max <- depth
	 * 		result <- current val
	 * end if
	 * 
	 * postorder(current left, depth plus one)
	 * postorder(current right, depth plus one)
	 * */
	public void postorder(TreeNode current, int depth) {
		if (current == null) { return; }
		
		if (depth > max) {
			max = depth;
			result = current.val;
		}
		
		postorder(current.left, depth + 1);
		postorder(current.right, depth + 1);
	}
	
}
