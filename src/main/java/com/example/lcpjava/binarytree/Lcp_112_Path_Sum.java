package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.example.lcpjava.common.Lcp_112_TreeNode;

public class Lcp_112_Path_Sum {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return false
	 * end if
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * Map<TreeNode, Integer> memo <- new HashMap
	 * memo put(root, 0)
	 * 
	 * while queue is not empty
	 * 		TreeNode current <- queue poll
	 * 		int sum <- memo get(current) plus current val
	 * 		
	 * 		if current left is equal to null && current right is equal to null && sum is equal to targetSum
	 * 			return true
	 * 		end if
	 * 		
	 * 		if current left is not equal to null
	 * 			queue offer(current left)
	 * 			memo put(current left, sum)
	 * 		end if
	 * 		
	 * 		if current right is not equal to null
	 * 			queue offer(current right)
	 * 			memo put(current right, sum)
	 * 		end if
	 * end while
	 * 
	 * return false
	 * */
	public boolean hasPathSum_1(Lcp_112_TreeNode root, int targetSum) {
		if (root == null) { return false; }
		
		Queue<Lcp_112_TreeNode> queue = new LinkedList<>();															// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		Map<Lcp_112_TreeNode, Integer> memo = new HashMap<>();														// S : O(n)
		memo.put(root, 0);																							// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			Lcp_112_TreeNode current = queue.poll();																// T : O(1)
			int sum = memo.get(current) + current.val;																// T : O(1)
			
			if (current.left == null && current.right == null && sum == targetSum) { return true; }
			
			if (current.left != null) {
				queue.offer(current.left);																			// T : O(1)
				memo.put(current.left, sum);																		// T : O(1)
			}
			
			if (current.right != null) {
				queue.offer(current.right);																			// T : O(1)
				memo.put(current.right, sum);																		// T : O(1)
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * DFS(root, zero, targetSum)
	 * */
	public boolean hasPathSum(Lcp_112_TreeNode root, int targetSum) {
		return DFS(root, 0, targetSum);
	}
	
	/**
	 * if current is equal to null
	 * 		return false
	 * end if
	 * 
	 * sum <- sum plus current val
	 * 
	 * if current is leaf node
	 * 		return if sum is equal to targetSum
	 * end if
	 * 
	 * return DFS(current left, sum, targetSum) || DFS(current right, sum, targetSum)
	 * */
	public boolean DFS(Lcp_112_TreeNode current, int sum, int targetSum) {
		if (current == null) { return false; }
		sum = sum + current.val;
		if (current.left == null && current.right == null) { return sum == targetSum; }
		return DFS(current.left, sum, targetSum) || DFS(current.right, sum, targetSum);
	}
	
}
