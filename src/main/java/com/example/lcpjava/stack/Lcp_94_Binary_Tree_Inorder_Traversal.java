package com.example.lcpjava.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.TreeNode;

public class Lcp_94_Binary_Tree_Inorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public List<Integer> inorderTraversal_1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		
		traversal(root, result);
		
		return result;
	}
	
	private void traversal(TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		
		traversal(current.left, result);
		
		result.add(current.val);
		
		traversal(current.right, result);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * */
	public List<Integer> inorderTraversal_2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();																		// S : O(n)
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {																// T : O(n)
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			result.add(current.val);
			current = current.right;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable
	 * */
	public List<Integer> inorderTraversal_3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();																		// S : O(n)
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {																// T : O(n)
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				result.add(current.val);
				current = current.right;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Morris Traversal - Threaded binary tree
	 * 
	 * will change input
	 * 
	 * Solution Tab
	 * */
	public List<Integer> inorderTraversal_4(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode current = root;
		TreeNode previous = null;
		
		while (current != null) {
			if (current.left != null) {
				previous = current.left;
				while (previous.right != null) { previous = previous.right; }
				
				previous.right = current;
				TreeNode temp = current;
				current = current.left;
				temp.left = null;
			} else {
				result.add(current.val);
				current = current.right;
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Morris Traversal - Threaded binary tree
	 * 
	 * recovers input
	 * 
	 * https://leetcode.com/problems/binary-tree-inorder-traversal/solution/154815
	 * */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		TreeNode current = root;
		
		while (current != null) {
			if (current.left != null) {
				TreeNode previous = current.left;
				while ((previous.right != null) && (previous.right != current)) { previous = previous.right; }
				
				if (previous.right == null) {
					previous.right = current;
					current = current.left;
				} else {
					previous.right = null;
					result.add(current.val);
					current = current.right;
				}
			} else {
				result.add(current.val);
				current = current.right;
			}
		}
		
		return result;
	}
	
}
