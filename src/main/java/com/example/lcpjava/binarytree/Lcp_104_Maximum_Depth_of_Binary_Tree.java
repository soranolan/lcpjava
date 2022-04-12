package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_104_TreeNode;

public class Lcp_104_Maximum_Depth_of_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int max <- 0
	 * if root is equal to null
	 * 		return max
	 * end if
	 * 
	 * Stack<TreeNode> treeStack <- new Stack
	 * Stack<Integer> depthStack <- new Stack
	 * 
	 * treeStack push(root)
	 * depthStack push(1)
	 * 
	 * while treeStack is not empty
	 * 		TreeNode current <- treeStack pop
	 * 		int depth <- depthStack pop
	 * 		
	 * 		if current left is not equal to null && current right is not equal to null
	 * 			max <- Math max(depth, max)
	 * 		end if
	 * 		
	 * 		if current left is not equal to null
	 * 			treeStack push(current left)
	 * 			depthStack push(depth plus one)
	 * 		end if
	 * 		
	 * 		if current right is not equal to null
	 * 			treeStack push(current right)
	 * 			depthStack push(depth plus one)
	 * 		end if
	 * end while
	 * 
	 * return max
	 * */
	public int maxDepth_1(Lcp_104_TreeNode root) {
		int max = 0;
		if (root == null) { return max; }
		
		Stack<Lcp_104_TreeNode> treeStack = new Stack<>();															// S : O(n)
		Stack<Integer> depthStack = new Stack<>();																	// S : O(n)
		
		treeStack.push(root);																						// T : O(1)
		depthStack.push(1);																							// T : O(1)
		
		while (!treeStack.isEmpty()) {																				// T : O(n)
			Lcp_104_TreeNode current = treeStack.pop();																// T : O(1)
			int depth = depthStack.pop();																			// T : O(1)
			
			if (current.left == null && current.right == null) { max = Math.max(depth, max); }
			if (current.left != null) {
				treeStack.push(current.left);																		// T : O(1)
				depthStack.push(depth + 1);																			// T : O(1)
			}
			if (current.right != null) {
				treeStack.push(current.right);																		// T : O(1)
				depthStack.push(depth + 1);																			// T : O(1)
			}
		}
		
		return max;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int depth <- 0
	 * if root is equal to null
	 * 		return depth
	 * end if
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * while queue is not empty
	 * 		depth++
	 * 		int size <- queue size
	 * 		
	 * 		while size is greater than zero
	 * 			TreeNode current <- queue poll
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
	 * end while
	 * 
	 * return depth
	 * */
	public int maxDepth_2(Lcp_104_TreeNode root) {
		int depth = 0;
		if (root == null) { return depth; }
		
		Queue<Lcp_104_TreeNode> queue = new LinkedList<>();															// S : O(n)
		queue.offer(root);																							// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			depth++;
			int size = queue.size();																				// T : O(1)
			while (size > 0) {
				Lcp_104_TreeNode current = queue.poll();															// T : O(1)
				if (current.left != null) { queue.offer(current.left); }											// T : O(1)
				if (current.right != null) { queue.offer(current.right); }											// T : O(1)
				size--;
			}
		}
		
		return depth;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int top_down_max <- 0
	 * 
	 * top_down(root, 1)
	 * 
	 * return top_down_max
	 * */
	int top_down_max = 0;
	public int maxDepth_3(Lcp_104_TreeNode root) {
		top_down(root, 1);
		return top_down_max;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * if current left is equal to null && current right is equal to null
	 * 		top_down_max <- Math max(depth, top_down_max)
	 * end if
	 * 
	 * top_down(current left, depth plus one)
	 * top_down(current right, depth plus one)
	 * */
	public void top_down(Lcp_104_TreeNode current, int depth) {
		if (current == null) { return; }
		if (current.left == null && current.right == null) { top_down_max = Math.max(depth, top_down_max); }
		top_down(current.left, depth + 1);
		top_down(current.right, depth + 1);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * return bottom_up(root, 1)
	 * */
	public int maxDepth(Lcp_104_TreeNode root) {
		return bottom_up(root, 1);
	}
	
	/**
	 * if current is equal to null
	 * 		return zero
	 * end if
	 * 
	 * int left <- bottom_up(current left, depth plus one)
	 * int right <- bottom_up(current right, depth plus one)
	 * return Math max(left, right) plus one
	 * */
	public int bottom_up(Lcp_104_TreeNode current, int depth) {
		if (current == null) { return 0; }
		int left = bottom_up(current.left, depth + 1);
		int right = bottom_up(current.right, depth + 1);
		return Math.max(left, right) + 1;
	}
	
}
