package com.example.lcpjava.narytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.N_Ary_TreeNode;

public class Lcp_589_N_ary_Tree_Preorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public List<Integer> preorder_1(N_Ary_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		recursive(root, result);
		return result;
	}
	
	private void recursive(N_Ary_TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		
		result.add(current.val);
		
		for (N_Ary_TreeNode child : current.children) { recursive(child, result); }
	}
	
	/**
	 * Follow up: Recursive solution is trivial, could you do it iteratively?
	 * */
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public List<Integer> preorder(N_Ary_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Stack<N_Ary_TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			N_Ary_TreeNode current = stack.pop();
			
			result.add(current.val);
			
			for (int i = current.children.size() - 1; i >= 0; i--) { stack.push(current.children.get(i)); }
		}
		
		return result;
	}
	
}
