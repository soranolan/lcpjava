package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_236_Pair;
import com.example.lcpjava.common.TreeNode;

public class Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution
	 * 
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65236/JavaPython-iterative-solution
	 * */
	public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) { return null; }
		
		Stack<TreeNode> stack = new Stack<>();																		// S : O(n)
		Map<TreeNode, TreeNode> child2Ancestor = new HashMap<>();													// S : O(n)
		Set<TreeNode> commonAncestors = new HashSet<>();															// S : O(n)
		
		stack.push(root);																							// T : O(1)
		child2Ancestor.put(root, null);																				// T : O(1)
		
		while (!child2Ancestor.containsKey(p) || !child2Ancestor.containsKey(q)) {
			TreeNode current = stack.pop();																			// T : O(1)
			if (current.left != null) {
				stack.push(current.left);																			// T : O(1)
				child2Ancestor.put(current.left, current);															// T : O(1)
			}
			if (current.right != null) {
				stack.push(current.right);																			// T : O(1)
				child2Ancestor.put(current.right, current);															// T : O(1)
			}
		}
		
		while (p != null) {																							// T : O(n)
			commonAncestors.add(p);																					// T : O(1)
			p = child2Ancestor.get(p);																				// T : O(1)
		}
		
		while (!commonAncestors.contains(q)) {																		// T : O(1)
			q = child2Ancestor.get(q);																				// T : O(1)
		}
		
		return q;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution
	 * */
	private static int BOTH_PENDING = 2;
	private static int LEFT_DONE = 1;
	private static int BOTH_DONE = 0;
	public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) { return null; }
		
		Stack<Lcp_236_Pair> stack = new Stack<Lcp_236_Pair>();														// S : O(n)
		stack.push(new Lcp_236_Pair(root, BOTH_PENDING));															// T : O(1)
		
		boolean foundOne = false;
		TreeNode lca = null;
		TreeNode child = null;
		
		while (!stack.isEmpty()) {
			Lcp_236_Pair top = stack.pop();																			// T : O(1)
			TreeNode current = top.getNode();
			int state = top.getState();
			
			if (state == BOTH_PENDING && (current == p || current == q)) {
				if (foundOne) { return lca; }
				foundOne = true;
				lca = current;
			}
			
			if (state == BOTH_PENDING) { child = current.left; }
			if (state == LEFT_DONE) { child = current.right; }
			
			if (state == BOTH_PENDING || state == LEFT_DONE) {
				stack.push(new Lcp_236_Pair(current, state - 1));													// T : O(1)
				if (child != null) { stack.push(new Lcp_236_Pair(child, BOTH_PENDING)); }							// T : O(1)
				continue;
			}
			
			if (state == BOTH_DONE && lca == current && foundOne) { lca = stack.peek().getNode(); }					// T : O(1)
		}
		
		return null;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65226/My-Java-Solution-which-is-easy-to-understand
	 * */
	public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
		return DFS_1(root, p, q);
	}
	
	private TreeNode DFS_1(TreeNode current, TreeNode p, TreeNode q) {
		if (current == null || current == p || current == q) { return current; }
		
		TreeNode left = DFS_1(current.left, p, q);
		TreeNode right = DFS_1(current.right, p, q);
		
		if (left == null) { return right; }
		if (right == null) { return left; }
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public TreeNode lowestCommonAncestor_4(TreeNode root, TreeNode p, TreeNode q) {
		lca = null;
		DFS_2(root, p, q);
		return lca;
	}
	
	private boolean DFS_2(TreeNode current, TreeNode p, TreeNode q) {
		if (current == null || lca != null) { return false; }
		
		int left = DFS_2(current.left, p, q) ? 1 : 0;
		int right = DFS_2(current.right, p, q) ? 1 : 0;
		
		int mid = (current == p || current == q) ? 1 : 0;
		int sum = left + right + mid;
		
		if (sum == 2) { lca = current; }
		
		return sum > 0;
	}
	
	/*
	
	Lcp_1394_Find_Lucky_Integer_in_an_Array
	
	https://blog.marklee.tw/java-interview-jvm-stack-heap/
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode lca = new TreeNode(1000000001);
		DFS(root, p, q, lca);
		return lca;
	}
	
	private boolean DFS(TreeNode current, TreeNode p, TreeNode q, TreeNode lca) {
		if (current == null || lca.val != 1000000001) { return false; }
		
		int left = DFS(current.left, p, q, lca) ? 1 : 0;
		int right = DFS(current.right, p, q, lca) ? 1 : 0;
		
		int mid = (current == p || current == q) ? 1 : 0;
		int sum = left + right + mid;
		
		if (sum == 2) { lca.val = current.val; }
		
		return sum > 0;
	}
	*/
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	TreeNode lca = null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		DFS(root, p, q);
		return lca;
	}
	
	private boolean DFS(TreeNode current, TreeNode p, TreeNode q) {
		if (current == null || lca != null) { return false; }
		
		boolean mid = (current == p || current == q);
		boolean left = DFS(current.left, p, q);
		boolean right = DFS(current.right, p, q);
		
		if ((left && right) || (mid && left) || (mid && right)) { lca = current; }
		
		return mid || left || right;
	}
	
}
