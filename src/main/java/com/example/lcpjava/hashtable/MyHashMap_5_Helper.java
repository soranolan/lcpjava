package com.example.lcpjava.hashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.lcpjava.common.MyHashTreeNode;

public class MyHashMap_5_Helper {
	
	public static List<MyHashTreeNode> treeToList(MyHashTreeNode current) {
		List<MyHashTreeNode> list = new LinkedList<>();
		Queue<MyHashTreeNode> queue = new LinkedList<>();
		queue.add(current);
		
		while (!queue.isEmpty()) {
			MyHashTreeNode node = queue.poll();
			list.add(node);
			if (node.right != null) { queue.add(node.right); }
			if (node.left != null) { queue.add(node.left); }
		}
		
		return list;
	}
	
	public static void addNode(MyHashTreeNode oldNode, MyHashTreeNode newNode) {
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
	
	public static MyHashTreeNode getNode(MyHashTreeNode current, int target) {
		if (target == current.key) { return current; }
		if (target > current.key && current.right != null) { return getNode(current.right, target); }
		if (target < current.key && current.left != null) { return getNode(current.left, target); }
		return null;
	}
	
	public static MyHashTreeNode removeNode(MyHashTreeNode current, int target) {
		if (target == current.key) {
			if (current.right == null && current.left == null) { return null; }
			if (current.right == null || current.left == null) { return (current.left != null) ? current.left : current.right; }
			
			MyHashTreeNode leftMax = findMax(current.left);
			current.key = leftMax.key;
			current.val = leftMax.val;
			removeNode(current.left, current.key);
		}
		
		if (target > current.key && current.right != null) { current.right = removeNode(current.right, target); }
		if (target < current.key && current.left != null) { current.left = removeNode(current.left, target); }
		return current;
	}
	
	public static MyHashTreeNode findMax(MyHashTreeNode current) {
		MyHashTreeNode temp = current;
		while (temp.right != null) { temp = temp.right; }
		return temp;
	}
	
}
