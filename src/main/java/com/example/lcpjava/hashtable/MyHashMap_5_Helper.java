package com.example.lcpjava.hashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyHashMap_5_Helper {
	
	public static List<TreeNode> treeToList(TreeNode current) {
		List<TreeNode> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(current);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node);
			if (node.right != null) { queue.add(node.right); }
			if (node.left != null) { queue.add(node.left); }
		}
		
		return list;
	}
	
	public static void addNode(TreeNode oldNode, TreeNode newNode) {
		if (newNode.key > oldNode.key) {
			if (oldNode.right == null) {
				oldNode.right = newNode;
				return;
			}
			addNode(oldNode.right, newNode);
		} else if (newNode.key < oldNode.key) {
			if (oldNode.left == null) {
				oldNode.left = newNode;
				return;
			}
			addNode(oldNode.left, newNode);
		}
	}
	
	public static TreeNode getNode(TreeNode current, int target) {
		if (target == current.key) { return current; }
		if (target > current.key && current.right != null) { return getNode(current.right, target); }
		if (target < current.key && current.left != null) { return getNode(current.left, target); }
		return null;
	}
	
	public static TreeNode removeNode(TreeNode current, int target) {
		if (target == current.key) {
			if (current.right == null && current.left == null) { return null; }
			if (current.right == null || current.left == null) { return (current.left != null) ? current.left : current.right; }
			
			TreeNode leftMax = findMax(current.left);
			current.key = leftMax.key;
			current.val = leftMax.val;
			removeNode(current.left, current.key);
		}
		
		if (target > current.key && current.right != null) { current.right = removeNode(current.right, target); }
		if (target < current.key && current.left != null) { current.left = removeNode(current.left, target); }
		return current;
	}
	
	public static TreeNode findMax(TreeNode current) {
		TreeNode temp = current;
		while (temp.right != null) { temp = temp.right; }
		return temp;
	}
	
}
