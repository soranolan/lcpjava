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
	public List<Integer> inorderTraversal(TreeNode root) {
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
	
}
