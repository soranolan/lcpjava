package com.example.lcpjava.binarytree;

import com.example.lcpjava.common.TreeNode;

public class Lcp_814_Binary_Tree_Pruning {
	
	/**
	 * time  : O(n)
	 * space : O(log n)
	 * */
	public TreeNode pruneTree_1(TreeNode root) {
		// try to handle : [ 0 ]
		TreeNode dummyHead = new TreeNode(1);
		dummyHead.left = root;
		
		pruning(dummyHead);
		
		return dummyHead.left;
	}
	
	private boolean pruning(TreeNode current) {
		if (current == null) { return false; }
		
		boolean selfIsOne = (current.val == 1);
		boolean leftContainsOne = pruning(current.left);
		boolean rightContainsOne = pruning(current.right);
		
		if (!leftContainsOne) { current.left = null; }
		if (!rightContainsOne) { current.right = null; }
		
		return selfIsOne || leftContainsOne || rightContainsOne;
	}
	
	/**
	 * time  : O(n)
	 * space : O(log n)
	 * 
	 * https://leetcode.com/problems/binary-tree-pruning/discuss/122730/C%2B%2BJavaPython-Self-Explaining-Solution-and-2-lines
	 * */
	public TreeNode pruneTree(TreeNode root) {
		return pruning(root) ? root : null;
	}
	
}
