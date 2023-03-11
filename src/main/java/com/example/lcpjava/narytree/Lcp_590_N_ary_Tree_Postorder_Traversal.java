package com.example.lcpjava.narytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.N_Ary_TreeNode;

public class Lcp_590_N_ary_Tree_Postorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public List<Integer> postorder_1(N_Ary_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		
		recursive(root, result);
		
		return result;
	}
	
	private void recursive(N_Ary_TreeNode current, List<Integer> result) {
		if (current == null) { return; }
		
		for (N_Ary_TreeNode child : current.children) { recursive(child, result); }
		
		result.add(current.val);
	}
	
	/**
	 * Follow up: Recursive solution is trivial, could you do it iteratively?
	 * */
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * will change input
	 * */
	public List<Integer> postorder_2(N_Ary_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Stack<N_Ary_TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			N_Ary_TreeNode current = stack.peek();
			
			if (current.children == null) {
				stack.pop();
				result.add(current.val);
				continue;
			}
			
			for (int i = current.children.size() - 1; i >= 0; i--) { stack.push(current.children.get(i)); }
			
			current.children = null;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/926/discuss/174665/Java-Iterative-Solution-Using-Two-Stacks.
	 * */
	public List<Integer> postorder(N_Ary_TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) { return result; }
		
		Stack<N_Ary_TreeNode> parents = new Stack<>();
		Stack<N_Ary_TreeNode> childs = new Stack<>();
		parents.push(root);
		
		while (!parents.isEmpty()) {
			N_Ary_TreeNode parent = parents.pop();
			
			childs.push(parent);
			
			for (N_Ary_TreeNode child : parent.children) { parents.push(child); }
		}
		
		while (!childs.isEmpty()) {
			result.add(childs.pop().val);
		}
		
		return result;
	}
	
}
