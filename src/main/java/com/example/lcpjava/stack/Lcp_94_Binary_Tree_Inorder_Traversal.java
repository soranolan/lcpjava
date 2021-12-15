package com.example.lcpjava.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lcp_94_Binary_Tree_Inorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * traversal(root, result)
	 * return result
	 * */
	public List<Integer> inorderTraversal_1(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		traversal(root, result);
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * traversal(current left, result)
	 * result add(current val)
	 * traversal(current right, result)
	 * */
	public void traversal(TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		traversal(current.left, result);
		result.add(current.val);
		traversal(current.right, result);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * Stack<TreeNode> stack <- new Stack
	 * TreeNode current <- root
	 * 
	 * while current is not equal to null || stack is not empty
	 * 		while current is not equal to null
	 * 			stack push(current)
	 * 			current <- current left
	 * 		end while
	 * 		
	 * 		current <- stack pop
	 * 		result add(current val)
	 * 		current <- current right
	 * end while
	 * 
	 * return result
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
	 * List<Integer> result <- new ArrayList
	 * Stac<TreeNode> stack <- new Stack
	 * TreeNode current <- root
	 * 
	 * while current is not equal to null || stack is not empty
	 * 		if current is not equal to null
	 * 			stack push(current)
	 * 			current <- current left
	 * 		else
	 * 			current <- stack pop
	 * 			result add(current val)
	 * 			current <- current right
	 * 		end if
	 * end while
	 * 
	 * return result
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
	 * List<Integer> result <- new ArrayList
	 * TreeNode current <- root
	 * TreeNode previous <- null
	 * 
	 * while current is not equal to null
	 * 		if current left is not equal to null
	 * 			previous <- current left
	 * 			while previous right is not equal to null
	 * 				previous <- previous right
	 * 			end while
	 * 			
	 * 			previous right <- current
	 * 			TreeNode temp <- current
	 * 			current <- current left
	 * 			temp left <- null
	 * 		else
	 * 			result add(current val)
	 * 			current <- current right
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> inorderTraversal(TreeNode root) {
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
	
}
