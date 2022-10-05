package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_623_Node;
import com.example.lcpjava.common.TreeNode;

public class Lcp_623_Add_One_Row_to_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * */
	public TreeNode addOneRow_1(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		
		Stack<Lcp_623_Node> stack = new Stack<>();																	// S : O(n)
		stack.push(new Lcp_623_Node(root, 2));
		
		while (!stack.isEmpty()) {																					// T : O(n)
			Lcp_623_Node current = stack.pop();
			if (current.node == null) { continue; }
			
			if (current.level == depth) {
				TreeNode newLeft = new TreeNode(val);
				TreeNode newRight = new TreeNode(val);
				
				if (current.node.left != null) { newLeft.left = current.node.left; }
				if (current.node.right != null) { newRight.right = current.node.right; }
				
				current.node.left = newLeft;
				current.node.right = newRight;
			} else {
				stack.push(new Lcp_623_Node(current.node.left, current.level + 1));
				stack.push(new Lcp_623_Node(current.node.right, current.level + 1));
			}
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Solution Tab
	 * */
	public TreeNode addOneRow_2(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		
		int level = 2;
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(2 ^ (depth - 1) ~ n / 2)
		queue.offer(root);
		
		while (!queue.isEmpty()) {																					// T : O(n)
			if (level == depth) { break; }
			
			int size = queue.size();
			
			for (int i = 0;i < size; i++) {
				TreeNode current = queue.poll();
				
				if (current.left != null) { queue.offer(current.left); }
				if (current.right != null) { queue.offer(current.right); }
			}
			
			level++;
		}
		
		while (!queue.isEmpty()) {																					// T : O(2 ^ (depth - 1) ~ n / 2)
			TreeNode current = queue.poll();
			
			TreeNode newLeft = new TreeNode(val);
			TreeNode newRight = new TreeNode(val);
			
			if (current.left != null) { newLeft.left = current.left; }
			if (current.right != null) { newRight.right = current.right; }
			
			current.left = newLeft;
			current.right = newRight;
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		
		traverse(root, val, 2, depth);
		
		return root;
	}
	
	private void traverse(TreeNode current, int val, int level, int depth) {
		if (current == null) { return; }
		
		if (level == depth) {
			TreeNode newLeft = new TreeNode(val);
			TreeNode newRight = new TreeNode(val);
			
			if (current.left != null) { newLeft.left = current.left; }
			if (current.right != null) { newRight.right = current.right; }
			
			current.left = newLeft;
			current.right = newRight;
		} else {
			traverse(current.left, val, level + 1, depth);
			traverse(current.right, val, level + 1, depth);
		}
	}
	
}
