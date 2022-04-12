package com.example.lcpjava.hashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyHashSet_4_Helper {
	
	public static List<Node> treeToList(Node current) {
		List<Node> list = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(current);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			list.add(node);
			if (node.right != null) { queue.add(node.right); }
			if (node.left != null) { queue.add(node.left); }
		}
		
		return list;
	}
	
	public static void addNode(Node oldNode, Node newNode) {
		if (newNode.val > oldNode.val) {
			if (oldNode.right == null) {
				oldNode.right = newNode;
				return;
			}
			addNode(oldNode.right, newNode);
		} else if (newNode.val < oldNode.val) {
			if (oldNode.left == null) {
				oldNode.left = newNode;
				return;
			}
			addNode(oldNode.left, newNode);
		}
	}
	
	public static boolean containNode(Node current, int target) {
		if (target == current.val) { return true; }
		if (target > current.val && current.right != null) { return containNode(current.right, target); }
		if (target < current.val && current.left != null) { return containNode(current.left, target); }
		return false;
	}
	
	public static Node removeNode(Node current, int target) {
		if (target == current.val) {
			if (current.right == null && current.left == null) { return null; }
			if (current.right == null || current.left == null) { return (current.left != null) ? current.left : current.right; }
			
			current.val = findMax(current.left).val;
			removeNode(current.left, current.val);
		}
		
		if (target > current.val && current.right != null) { current.right = removeNode(current.right, target); }
		if (target < current.val && current.left != null) { current.left = removeNode(current.left, target); }
		return current;
	}
	
	public static Node findMax(Node current) {
		Node temp = current;
		while (temp.right != null) { temp = temp.right; }
		return temp;
	}
	
}
