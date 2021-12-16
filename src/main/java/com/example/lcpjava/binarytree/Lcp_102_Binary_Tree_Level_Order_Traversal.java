package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lcp_102_Binary_Tree_Level_Order_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<List<Integer>> result <- new ArrayList
	 * 
	 * if root is equal to null
	 * 		return result
	 * end if
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * BFS(queue, result)
	 * 
	 * return result
	 * */
	public List<List<Integer>> levelOrder_1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		BFS(queue, result);
		
		return result;
	}
	
	/**
	 * while queue is not empty
	 * 		List<Integer> level <- new ArrayList
	 * 		int size <- queue size
	 * 		
	 * 		while size is greater than zero
	 * 			TreeNode current <- queue poll
	 * 			level add(current val)
	 * 			
	 * 			if current left is not equal to null
	 * 				queue offer(current left)
	 * 			end if
	 * 			
	 * 			if current right is not equal to null
	 * 				queue offer(current right)
	 * 			end if
	 * 			
	 * 			size--
	 * 		end while
	 * 		
	 * 		result add(level)
	 * end while
	 * */
	public void BFS(Queue<TreeNode> queue, List<List<Integer>> result) {
		while (!queue.isEmpty()) {																					// T : O(n)
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			
			while (size > 0) {
				TreeNode current = queue.poll();
				level.add(current.val);
				if (current.left != null) { queue.offer(current.left); }											// T : O(1)
				if (current.right != null) { queue.offer(current.right); }											// T : O(1)
				size--;
			}
			
			result.add(level);																						// T : O(1)
		}
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<List<Integer>> result <- new ArrayList
	 * 
	 * DFS(root, 0, result)
	 * 
	 * return result
	 * */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		DFS(root, 0, result);
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * if depth is equal to result size
	 * 		result add(new ArrayList)
	 * end if
	 * 
	 * result get(depth) add(current val)
	 * 
	 * DFS(current left, depth plus one, result)
	 * 
	 * DFS(current right, depth plus one, result)
	 * */
	public void DFS(TreeNode current, int depth, List<List<Integer>> result) {
		if (current == null) { return; }
		if (depth == result.size()) { result.add(new ArrayList<>()); }
		result.get(depth).add(current.val);
		DFS(current.left, depth + 1, result);
		DFS(current.right, depth + 1, result);
	}
	
}
