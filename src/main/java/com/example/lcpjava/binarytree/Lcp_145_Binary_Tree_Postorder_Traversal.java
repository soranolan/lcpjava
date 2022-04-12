package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_145_TreeNode;

public class Lcp_145_Binary_Tree_Postorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> result <- new ArrayList
	 * traversal(root, result)
	 * return result
	 * */
	public List<Integer> postorderTraversal_1(Lcp_145_TreeNode root) {
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
	public void traversal(Lcp_145_TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		traversal(current.left, result);
		traversal(current.right, result);
		result.add(current.val);																					// T : O(1)
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
	public List<Integer> postorderTraversal_2(Lcp_145_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<Lcp_145_TreeNode> stack = new Stack<>();																// S : O(n)
		Lcp_145_TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {																// T : O(n)
			while (current != null) {
				stack.push(current);																				// T : O(1)
				current = (current.left != null) ? current.left : current.right;
			}
			
			Lcp_145_TreeNode temp = stack.pop();																	// T : O(1)
			result.add(temp.val);																					// T : O(1)
			if (!stack.isEmpty() && temp == stack.peek().left) { current = stack.peek().right; }					// T : O(1)
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
	public List<Integer> postorderTraversal_3(Lcp_145_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Stack<Lcp_145_TreeNode> stack = new Stack<>();																// S : O(n)
		Lcp_145_TreeNode current = root;
		
		while (current != null || !stack.isEmpty()) {																// T : O(n)
			while (!isLeaf(current)) {
				stack.push(current);																				// T : O(1)
				current = current.left;
			}
			
			if (current != null) { result.add(current.val); }														// T : O(1)
			
			while (!stack.isEmpty() && current == stack.peek().right) {
				current = stack.pop();																				// T : O(1)
				result.add(current.val);																			// T : O(1)
			}
			
			if (!stack.isEmpty()) {																					// T : O(1)
				current = stack.peek().right;																		// T : O(1)
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
	public boolean isLeaf(Lcp_145_TreeNode current) {
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
	public List<Integer> postorderTraversal(Lcp_145_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Stack<Lcp_145_TreeNode> stack = new Stack<>();																// S : O(n)
		Lcp_145_TreeNode current = root;
		stack.push(current);																						// T : O(1)
		stack.push(current);																						// T : O(1)
		
		while (!stack.isEmpty()) {																					// T : O(n)
			current = stack.pop();																					// T : O(1)
			if (!stack.isEmpty() && current == stack.peek()) {														// T : O(1)
				if (current.right != null) {
					stack.push(current.right);																		// T : O(1)
					stack.push(current.right);																		// T : O(1)
				}
				if (current.left != null) {
					stack.push(current.left);																		// T : O(1)
					stack.push(current.left);																		// T : O(1)
				}
			} else {
				result.add(current.val);																			// T : O(1)
			}
		}
		
		return result;
	}
	
}
