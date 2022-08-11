package com.example.lcpjava.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.TreeNode;

public class Lcp_98_Validate_Binary_Search_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
	 * */
	public boolean isValidBST_1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();																		// S : O(height)
		
		TreeNode previous = null;
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {																// T : O(n)
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			
			if (previous != null && current.val <= previous.val) { return false; }
			
			previous = current;
			current = current.right;
		}
		
		return true;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
	 * */
	public boolean isValidBST_2(TreeNode root) {
		List<Integer> bucket = new ArrayList<>();																	// S : O(n)
		
		inorder(root, bucket);
		
		for (int i = 0; i < bucket.size() - 1; i++) {																// T : O(n - 1)
			if (bucket.get(i) >= bucket.get(i + 1)) { return false; }
		}
		
		return true;
	}
	
	private void inorder(TreeNode current, List<Integer> bucket) {
		if (current == null) { return; }
		
		inorder(current.left, bucket);
		
		bucket.add(current.val);
		
		inorder(current.right, bucket);
	}
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
	 * */
	public boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}
	
	private boolean isValid(TreeNode current, TreeNode min, TreeNode max) {
		if (current == null) { return true; }
		
		if (min != null && current.val <= min.val) { return false; }
		
		if (max != null && current.val >= max.val) { return false; }
		
		return isValid(current.left, min, current) && isValid(current.right, current, max);
	}
	
}
