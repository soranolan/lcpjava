package com.example.lcpjava.hashtable;

import java.util.Iterator;
import java.util.List;

public class MyHashMap_5 {
	
	public static final double LOAD_FACTOR = 0.75D;
	
	public TreeNode[] bucket;
	
	public int size;
	
	public MyHashMap_5() {
		bucket = new TreeNode[16];
		size = 0;
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		TreeNode newNode = new TreeNode(key, value);
		TreeNode root = bucket[index];
		if (root == null) {
			bucket[index] = newNode;
		} else {
			TreeNode node = TreeHelper.getNode(root, key);
			if (node != null) {
				node.val = value;
			} else {
				TreeHelper.addNode(root, newNode);
			}
		}
		size++;
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
	}
	
	public int get(int key) {
		int index = hash(key);
		TreeNode root = bucket[index];
		if (root == null) { return -1; }
		
		TreeNode node = TreeHelper.getNode(root, key);
		return node != null ? node.val : -1;
	}
	
	public void remove(int key) {
		int index = hash(key);
		TreeNode root = bucket[index];
		if (root == null) { return; }
		
		bucket[index] = TreeHelper.removeNode(root, key);
		size--;
	}
	
	public int hash(int key) {
		return key % bucket.length;
	}
	
	public void rehash() {
		size = 0;
		TreeNode[] oldBucket = bucket;
		bucket = new TreeNode[oldBucket.length * 2];
		
		for (TreeNode oldNode : oldBucket) {
			if (oldNode == null) { continue; }
			
			List<TreeNode> list = TreeHelper.treeToList(oldNode);
			Iterator<TreeNode> it = list.iterator();
			
			while (it.hasNext()) {
				TreeNode n = it.next();
				put(n.key, n.val);
			}
		}
	}
	
}
