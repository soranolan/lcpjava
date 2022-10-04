package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.example.lcpjava.common.TreeNode;

public class Lcp_112_Path_Sum {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public boolean hasPathSum_1(TreeNode root, int targetSum) {
		if (root == null) { return false; }
		
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		Map<TreeNode, Integer> memo = new HashMap<>();																// S : O(n)
		memo.put(root, 0);																							// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			TreeNode current = queue.poll();																		// T : O(1)
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
	 * time  : Ω(log n) ~ O(n)
	 * space : Ω(log n) ~ O(n)
	 * 
	 * try early return
	 * */
	public boolean hasPathSum_2(TreeNode root, int targetSum) {
		boolean[] result = new boolean[1];
		
		traverse(root, 0, targetSum, result);
		
		return result[0];
	}
	
	private void traverse(TreeNode current, int currentSum, int targetSum, boolean[] result) {
		if (result[0] || current == null) { return; }
		
		currentSum += current.val;
		
		if (current.left == null && current.right == null && currentSum == targetSum) {
			result[0] = true;
			return;
		}
		
		if (!result[0]) {																							// if not found, result[0] == false
			traverse(current.left, currentSum, targetSum, result);
			traverse(current.right, currentSum, targetSum, result);
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return DFS(root, 0, targetSum);
	}
	
	private boolean DFS(TreeNode current, int currentSum, int targetSum) {
		if (current == null) { return false; }
		
		currentSum = currentSum + current.val;
		
		if (current.left == null && current.right == null) { return currentSum == targetSum; }
		
		return DFS(current.left, currentSum, targetSum) || DFS(current.right, currentSum, targetSum);
	}
	
}
