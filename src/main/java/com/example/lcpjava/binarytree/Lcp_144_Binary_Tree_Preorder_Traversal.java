package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lcp_144_Binary_Tree_Preorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * traversal(root, result)
	 * return result
	 * */
	public List<Integer> preorderTraversal_1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		traversal(root, result);
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * result add(current val)
	 * traversal(current left, result)
	 * traversal(current right, result)
	 * */
	public void traversal(TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		result.add(current.val);																					// T : O(1)
		traversal(current.left, result);
		traversal(current.right, result);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * if root is equal to null
	 * 		return result
	 * end if
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * 
	 * TreeNode current <- root
	 * stack push(current)
	 * 
	 * while stack is not empty
	 * 		current <- stack pop
	 * 		result add(current val)
	 * 		if current left is not equal to null
	 * 			stack push(current right)
	 * 		end if
	 * 		if current right is not equal to null
	 * 			stack push(current left)
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> preorderTraversal_2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) { return result; }
		Stack<TreeNode> stack = new Stack<>();																		// S : O(n)
		
		TreeNode current = root;
		stack.push(current);																						// T : O(1)
		
		while (!stack.isEmpty()) {																					// T : O(n)
			current = stack.pop();																					// T : O(1)
			result.add(current.val);																				// T : O(1)
			if (current.right != null) { stack.push(current.right); }												// T : O(1)
			if (current.left != null) { stack.push(current.left); }													// T : O(1)
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(node right)
	 * 
	 * List<Integer> result <- new ArrayList
	 * Stack<TreeNode> stack <- new Stack
	 * TreeNode current <- root
	 * 
	 * while current is not equal to null || stack is not empty
	 * 		if current is not equal to null
	 * 			stack push(current right)
	 * 			result add(current val)
	 * 			current <- current left
	 * 		else
	 * 			current <- stack pop
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();																		// S : O(node right)
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {																// T : O(n)
			if (current != null) {
				stack.push(current.right);																			// T : O(1)
				result.add(current.val);																			// T : O(1)
				current = current.left;
			} else {
				current = stack.pop();																				// T : O(1)
			}
		}
		
		return result;
	}
	
}
