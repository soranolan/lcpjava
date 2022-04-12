package com.example.lcpjava.hashtable;

import java.util.Iterator;
import java.util.List;

import com.example.lcpjava.common.MyHashTreeNode;

public class MyHashMap_5 {
	
	public static final double LOAD_FACTOR = 0.75D;
	
	public MyHashTreeNode[] bucket;
	
	public int size;
	
	public MyHashMap_5() {
		bucket = new MyHashTreeNode[16];
		size = 0;
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		MyHashTreeNode newNode = new MyHashTreeNode(key, value);
		MyHashTreeNode root = bucket[index];
		if (root == null) {
			bucket[index] = newNode;
		} else {
			MyHashTreeNode node = MyHashMap_5_Helper.getNode(root, key);
			if (node != null) {
				node.val = value;
			} else {
				MyHashMap_5_Helper.addNode(root, newNode);
			}
		}
		size++;
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
	}
	
	public int get(int key) {
		int index = hash(key);
		MyHashTreeNode root = bucket[index];
		if (root == null) { return -1; }
		
		MyHashTreeNode node = MyHashMap_5_Helper.getNode(root, key);
		return node != null ? node.val : -1;
	}
	
	public void remove(int key) {
		int index = hash(key);
		MyHashTreeNode root = bucket[index];
		if (root == null) { return; }
		
		bucket[index] = MyHashMap_5_Helper.removeNode(root, key);
		size--;
	}
	
	public int hash(int key) {
		return key % bucket.length;
	}
	
	public void rehash() {
		size = 0;
		MyHashTreeNode[] oldBucket = bucket;
		bucket = new MyHashTreeNode[oldBucket.length * 2];
		
		for (MyHashTreeNode oldNode : oldBucket) {
			if (oldNode == null) { continue; }
			
			List<MyHashTreeNode> list = MyHashMap_5_Helper.treeToList(oldNode);
			Iterator<MyHashTreeNode> it = list.iterator();
			
			while (it.hasNext()) {
				MyHashTreeNode n = it.next();
				put(n.key, n.val);
			}
		}
	}
	
}
