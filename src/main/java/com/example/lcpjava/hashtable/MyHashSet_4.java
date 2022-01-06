package com.example.lcpjava.hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyHashSet_4 {
	
	public Node[] bucket;
	
	public final static double LOAD_FACTOR = 0.7D;
	
	public final static int INITIAL_SIZE = 1;
	
	public int size;
	
	public MyHashSet_4() {
		bucket = new Node[INITIAL_SIZE];
		size = 0;
	}
	
	public void add(int key) {
		int index = hash(key);
		Node newNode = new Node(key);
		Node oldNode = bucket[index];
		if (oldNode == null) {
			bucket[index] = newNode;
		} else {
			BSTHelper.addNode(oldNode, newNode);
		}
		size++;
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
	}
	
	public void remove(int key) {
		int index = hash(key);
		Node current = bucket[index];
		if (current == null) { return; }
		bucket[index] = BSTHelper.removeNode(current, key);
		size--;
	}
	
	public boolean contains(int key) {
		int index = hash(key);
		Node current = bucket[index];
		if (current == null) { return false; }
		return BSTHelper.containNode(current, key);
	}
	
	public int hash(int key) {
		return key % bucket.length;
	}
	
	public void rehash() {
		Node[] newBucket = new Node[bucket.length * 2];
		Node[] oldBucket = bucket;
		bucket = newBucket;
		for (Node oldNode : oldBucket) {
			if (oldNode == null) { continue; }
			List<Node> list = BSTHelper.treeToList(oldNode);
			Iterator<Node> it = list.iterator();
			while (it.hasNext()) { add(it.next().val); }
		}
	}
	
}

/** Binary Search Tree */
class Node {
	
	public int val;
	
	public Node left;
	
	public Node right;
	
	public Node() {  }
	
	public Node(int val) { this.val = val; }
	
}

class BSTHelper {
	
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
