package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lcp_145_Binary_Tree_Postorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * traversal(root, result)
	 * return result
	 * */
	public List<Integer> postorderTraversal_1(TreeNode root) {
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
	 * traversal(current right, result)
	 * result add(current val)
	 * */
	public void traversal(TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		traversal(current.left, result);
		traversal(current.right, result);
		result.add(current.val);
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
	 * 			current <- if current left is not equal to null then current left else current right
	 * 		end while
	 * 		
	 * 		TreeNode temp <- stack pop
	 * 		result add(temp val)
	 * 		if stack is not empty && temp is equal to stack peek left
	 * 			current <- stack peek right
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> postorderTraversal_2(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = (current.left != null) ? current.left : current.right;
			}
			
			TreeNode temp = stack.pop();
			result.add(temp.val);
			if (!stack.isEmpty() && temp == stack.peek().left) { current = stack.peek().right; }
		}
		
		return result;
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
	 * 		while current is not leaf node
	 * 			stack push(current)
	 * 			current <- current left
	 * 		end while
	 * 		
	 * 		if current is not equal to null
	 * 			result add(current val)
	 * 		end if
	 * 		
	 * 		while stack is not empty && current is equal to stack peek right
	 * 			current <- stack pop
	 * 			result add(current val)
	 * 		end while
	 * 		
	 * 		if stack is not empty
	 * 			current <- stack peek right
	 * 		else
	 * 			current <- null
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> postorderTraversal_3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {
			while (!isLeaf(current)) {
				stack.push(current);
				current = current.left;
			}
			
			if (current != null) { result.add(current.val); }
			
			while (!stack.isEmpty() && current == stack.peek().right) {
				current = stack.pop();
				result.add(current.val);
			}
			
			if (!stack.isEmpty()) {
				current = stack.peek().right;
			} else {
				current = null;
			}
		}
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return true
	 * end if
	 * 
	 * return if current left is equal to null && current right is equal to null then true else false
	 * */
	public boolean isLeaf(TreeNode current) {
		if (current == null) { return true; }
		return current.left == null && current.right == null;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Duplicates / Double push
	 * 
	 * List<Integer> result <- new ArrayList
	 * if root is equal to null
	 * 		return result
	 * end if
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * TreeNode current <- root
	 * stack push(current)
	 * stack push(current)
	 * 
	 * while stack is not empty
	 * 		current <- stack pop
	 * 		if stack is not empty && current is equal to stack peek
	 * 			if current right is not equal to null
	 * 				stack push(current right)
	 * 				stack push(current right)
	 * 			end if
	 * 			if current left is not equal to null
	 * 				stack push(current left)
	 * 				stack push(current left)
	 * 			end if
	 * 		else
	 * 			result add(current val)
	 * 		end if
	 * end while
	 * 
	 * return result
	 * */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		stack.push(current);
		stack.push(current);
		
		while (!stack.isEmpty()) {
			current = stack.pop();
			if (!stack.isEmpty() && current == stack.peek()) {
				if (current.right != null) {
					stack.push(current.right);
					stack.push(current.right);
				}
				if (current.left != null) {
					stack.push(current.left);
					stack.push(current.left);
				}
			} else {
				result.add(current.val);
			}
		}
		
		return result;
	}
	
}
