package com.example.lcpjava.binarytree;

import com.example.lcpjava.common.TreeNode;

public class Lcp_1448_Count_Good_Nodes_in_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * */
	public int goodNodes(TreeNode root) {
		return traverse(root, root.val);
	}
	
	private int traverse(TreeNode current, int max) {
		if (current == null) { return 0; }
		
		int isCurrentGood = current.val < max ? 0 : 1;
		
		max = Math.max(max, current.val);
		
		return isCurrentGood + traverse(current.left, max) + traverse(current.right, max);
	}
	
}
