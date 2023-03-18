package com.example.lcpjava.narytree;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.N_Ary_TreeNode;

public class Lcp_559_Maximum_Depth_of_N_ary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height);
	 * */
	public int maxDepth_1(N_Ary_TreeNode root) {
		int[] maxDepth = new int[1];
		
		topDown(root, 1, maxDepth);
		
		return maxDepth[0];
	}
	
	private void topDown(N_Ary_TreeNode current, int depth, int[] maxDepth) {
		if (current == null) { return; }
		
		maxDepth[0] = Math.max(maxDepth[0], depth);
		
		for (N_Ary_TreeNode child : current.children) { topDown(child, depth + 1, maxDepth); }
	}
	
	/**
	 * time  : O(n)
	 * space : O(height);
	 * */
	public int maxDepth_2(N_Ary_TreeNode root) {
		return bottomUp(root);
	}
	
	private int bottomUp(N_Ary_TreeNode current) {
		if (current == null) { return 0; }
		
		int maxChildDepth = 0;
		
		for (N_Ary_TreeNode child : current.children) { maxChildDepth = Math.max(maxChildDepth, bottomUp(child)); }
		
		return maxChildDepth + 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Iterative Solution
	 * 
	 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/solutions/183060/java-bfs-iterative-solution/
	 * */
	public int maxDepth(N_Ary_TreeNode root) {
		if (root == null) { return 0; }
		
		Queue<N_Ary_TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		int maxDepth = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				N_Ary_TreeNode current = queue.poll();
				for (N_Ary_TreeNode child : current.children) { queue.offer(child); }
			}
			
			maxDepth++;
		}
		
		return maxDepth;
	}
	
}
