package com.example.lcpjava.hashtable;

import java.util.Iterator;
import java.util.List;

/** Binary Search Tree */
public class MyHashSet_4 {
	
	public Node[] bucket;
	
	public static final int INITIAL_SIZE = 1;
	
	public static final double LOAD_FACTOR = 0.7D;
	
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
			MyHashSet_4_Helper.addNode(oldNode, newNode);
		}
		size++;
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
	}
	
	public void remove(int key) {
		int index = hash(key);
		Node current = bucket[index];
		if (current == null) { return; }
		bucket[index] = MyHashSet_4_Helper.removeNode(current, key);
		size--;
	}
	
	public boolean contains(int key) {
		int index = hash(key);
		Node current = bucket[index];
		if (current == null) { return false; }
		return MyHashSet_4_Helper.containNode(current, key);
	}
	
	public int hash(int key) {
		return key % bucket.length;
	}
	
	public void rehash() {
		size = 0;
		Node[] newBucket = new Node[bucket.length * 2];
		Node[] oldBucket = bucket;
		bucket = newBucket;
		for (Node oldNode : oldBucket) {
			if (oldNode == null) { continue; }
			List<Node> list = MyHashSet_4_Helper.treeToList(oldNode);
			Iterator<Node> it = list.iterator();
			while (it.hasNext()) { add(it.next().val); }
		}
	}
	
}
