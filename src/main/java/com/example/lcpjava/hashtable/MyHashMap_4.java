package com.example.lcpjava.hashtable;

public class MyHashMap_4 {
	
	public static final int INITIAL_SIZE = 16;
	
	public static final double LOAD_FACTOR = 0.75D;
	
	public ListNode[] bucket;
	
	public int size;
	
	public MyHashMap_4() {
		bucket = new ListNode[INITIAL_SIZE];
		size = 0;
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		ListNode previous = findPrevious(index, key);
		if (previous.next == null) {
			previous.next = new ListNode(key, value);
		} else {
			previous.next.val = value;
		}
		size++;
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
	}
	
	public int get(int key) {
		int index = hash(key);
		ListNode previous = findPrevious(index, key);
		if (previous.next == null) { return -1; }
		return previous.next.val;
	}
	
	public void remove(int key) {
		int index = hash(key);
		ListNode previous = findPrevious(index, key);
		if (previous.next == null) { return; }
		previous.next = previous.next.next;
		size--;
	}
	
	public int hash(int key) {
		return key % bucket.length;
	}
	
	public void rehash() {
		size = 0;
		ListNode[] oldBucket = bucket;
		bucket = new ListNode[oldBucket.length * 2];
		for (ListNode oldNode : oldBucket) {
			while (oldNode != null) {
				if (oldNode.key == -1) {
					oldNode = oldNode.next;
					continue;
				}
				put(oldNode.key, oldNode.val);
				oldNode = oldNode.next;
			}
		}
	}
	
	public ListNode findPrevious(int index, int key) {
		ListNode current = bucket[index];
		if (current == null) { return bucket[index] = new ListNode(-1, -1); }
		while (current.next != null && current.next.key != key) { current = current.next; }
		return current;
	}
	
}
