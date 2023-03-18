package com.example.lcpjava.narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.lcpjava.common.N_Ary_TreeNode;

public class Lcp_429_N_ary_Tree_Level_Order_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public List<List<Integer>> levelOrder_1(N_Ary_TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Queue<N_Ary_TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				N_Ary_TreeNode current = queue.poll();
				
				level.add(current.val);
				
				for (N_Ary_TreeNode child : current.children) { queue.offer(child); }
			}
			
			result.add(level);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/solutions/1386593/c-python-bfs-dfs-solutions-clean-concise/
	 * */
	public List<List<Integer>> levelOrder(N_Ary_TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		traversal(root, 0, result);
		
		return result;
	}
	
	private void traversal(N_Ary_TreeNode root, int depth, List<List<Integer>> result) {
		if (root == null) { return; }
		
		if (result.size() == depth) { result.add(new ArrayList<>()); }
		
		result.get(depth).add(root.val);
		
		for (N_Ary_TreeNode child : root.children) { traversal(child, depth + 1, result); }
	}
	
}
