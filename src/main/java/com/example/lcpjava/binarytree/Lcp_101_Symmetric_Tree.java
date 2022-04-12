package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.TreeNode;

public class Lcp_101_Symmetric_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return true
	 * end if
	 * 
	 * return isEqual(root left, root right)
	 * */
	public boolean isSymmetric_1(TreeNode root) {
		if (root == null) { return true; }
		return isEqual(root.left, root.right);
	}
	
	/**
	 * if left is equal to null || right is equal to null
	 * 		return left is equal to null
	 * end if
	 * 
	 * if left val is not equal to right val
	 * 		return false
	 * end if
	 * 
	 * return isEqual(left left, right right) && isEqual(left right, right left)
	 * */
	public boolean isEqual(TreeNode left, TreeNode right) {
		if (left == null || right == null) { return left == right; }
		if (left.val != right.val) { return false; }
		return isEqual(left.left, right.right) && isEqual(left.right, right.left);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return true
	 * end if
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root left)
	 * queue offer(root right)
	 * 
	 * while queue is not empty
	 * 		TreeNode left <- queue poll
	 * 		TreeNode right <- queue poll
	 * 		
	 * 		if left is equal to null && right is equal to null
	 * 			continue
	 * 		end if
	 * 		
	 * 		if left is equal to null || right is equal to null
	 * 			return false
	 * 		end if
	 * 		
	 * 		if left val is not equal to right val
	 * 			return false
	 * 		end if
	 * 		
	 * 		queue offer(left left)
	 * 		queue offer(right right)
	 * 		queue offer(left right)
	 * 		queue offer(right left)
	 * end while
	 * 
	 * return true
	 * */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) { return true; }
		
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		queue.offer(root.left);																						// T : O(1)
		queue.offer(root.right);																					// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			TreeNode left = queue.poll();																			// T : O(1)
			TreeNode right = queue.poll();																			// T : O(1)
			
			if (left == null && right == null) { continue; }
			if (left == null || right == null) { return false; }
			if (left.val != right.val) { return false; }
			
			queue.offer(left.left);																					// T : O(1)
			queue.offer(right.right);																				// T : O(1)
			queue.offer(left.right);																				// T : O(1)
			queue.offer(right.left);																				// T : O(1)
		}
		
		return true;
	}
	
}
