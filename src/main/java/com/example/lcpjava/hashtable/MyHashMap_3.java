package com.example.lcpjava.hashtable;

public class MyHashMap_3 {
	
	public static final int INITIAL_SIZE = 16;
	
	public static final double LOAD_FACTOR = 0.75D;
	
	public ListNode[] bucket;
	
	public int size;
	
	public MyHashMap_3() {
		bucket = new ListNode[INITIAL_SIZE];
		size = 0;
	}
	
	public void put(int key, int value) {
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
		putNode(key, value);
	}
	
	public void putNode(int key, int value) {
		size++;
		int index = hash(key);
		ListNode newNode = new ListNode(key, value);
		ListNode root = bucket[index];
		if (root == null) {
			bucket[index] = newNode;
			return;
		}
		if (root.key == key) {
			root.val = value;
			return;
		}
		ListNode current = root;
		while (current.next != null) {
			if (current.next.key == key) {
				current.next.val = value;
				return;
			}
			current = current.next;
		}
		current.next = newNode;
	}
	
	public int get(int key) {
		int index = hash(key);
		ListNode root = bucket[index];
		ListNode current = root;
		while (current != null && current.key != key) { current = current.next; }
		if (current == null || current.key != key) { return -1; }
		return current.val;
	}
	
	public void remove(int key) {
		int index = hash(key);
		ListNode root = bucket[index];
		if (root == null) { return; }
		if (root.key == key) {
			bucket[index] = root.next;
			size--;
			return;
		}
		ListNode current = root;
		while (current.next != null) {
			if (current.next.key == key) {
				current.next = current.next.next;
				size--;
				return;
			}
			current = current.next;
		}
	}
	
	public int hash(int key) {
		return key % INITIAL_SIZE;
	}
	
	public void rehash() {
		size = 0;
		ListNode[] oldBucket = bucket;
		bucket = new ListNode[oldBucket.length * 2];
		for (ListNode oldNode : oldBucket) {
			while (oldNode != null) {
				putNode(oldNode.key, oldNode.val);
				oldNode = oldNode.next;
			}
		}
	}
	
}
