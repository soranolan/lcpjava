package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.example.lcpjava.common.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
 * */
public class Lcp_449_Serialize_and_Deserialize_BST {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * StringBuilder sb <- new StringBuilder
	 * 
	 * preorder(root, sb)
	 * 
	 * return sb to string
	 * */
	public String serialize(TreeNode root) {
		if (root == null) { return null; }
		
		StringBuilder sb = new StringBuilder();
		preorder(root, sb);
		
		return sb.toString();
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * sb append(current val) append(",")
	 * 
	 * preorder(current left, sb)
	 * 
	 * preorder(current right, sb)
	 * */
	private void preorder(TreeNode current, StringBuilder sb) {
		if (current == null) { return; }
		
		sb.append(current.val).append(",");
		preorder(current.left, sb);
		preorder(current.right, sb);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if data is equal to null
	 * 		return null
	 * end if
	 * 
	 * Queue<String> queue <- new LinkedList
	 * String[] nodes <- data split(",")
	 * 
	 * for String node in nodes
	 * 		queue offer(node)
	 * end for
	 * 
	 * return rebuild(queue, Integer minimum value, Integer maximum value)
	 * */
	public TreeNode deserialize(String data) {
		if (data == null) { return null; }
		
		Queue<String> queue = new LinkedList<>();																	// S : O(n)
		String[] nodes = data.split(",");																			// S : O(n)
		for (String node : nodes) { queue.offer(node); }															// T : O(n)
		
		return rebuild(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * if queue is empty
	 * 		return null
	 * end if
	 * 
	 * int val <- Integer valueOf(queue peek)
	 * 
	 * if val is lower than minimum || val is greater than maximum
	 * 		return null
	 * end if
	 * 
	 * queue poll
	 * 
	 * TreeNode current <- new TreeNode(val)
	 * current left <- rebuild(queue, minimum, val)
	 * current right <- rebuild(queue, val, maximum)
	 * 
	 * return current
	 * */
	private TreeNode rebuild(Queue<String> queue, int min, int max) {
		if (queue.isEmpty()) { return null; }
		
		int val = Integer.valueOf(queue.peek());
		if (val < min || val > max) { return null; }
		
		queue.poll();
		
		TreeNode current = new TreeNode(val);
		current.left = rebuild(queue, min, val);
		current.right = rebuild(queue, val, max);
		
		return current;
	}
	
}
