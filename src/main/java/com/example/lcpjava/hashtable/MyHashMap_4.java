package com.example.lcpjava.hashtable;

import com.example.lcpjava.common.Lcp_706_ListNode;

public class MyHashMap_4 {
	
	public static final int INITIAL_SIZE = 16;
	
	public static final double LOAD_FACTOR = 0.75D;
	
	public Lcp_706_ListNode[] bucket;
	
	public int size;
	
	public MyHashMap_4() {
		bucket = new Lcp_706_ListNode[INITIAL_SIZE];
		size = 0;
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		Lcp_706_ListNode previous = findPrevious(index, key);
		if (previous.next == null) {
			previous.next = new Lcp_706_ListNode(key, value);
		} else {
			previous.next.val = value;
		}
		size++;
		if (size > (int) (LOAD_FACTOR * bucket.length)) { rehash(); }
	}
	
	public int get(int key) {
		int index = hash(key);
		Lcp_706_ListNode previous = findPrevious(index, key);
		if (previous.next == null) { return -1; }
		return previous.next.val;
	}
	
	public void remove(int key) {
		int index = hash(key);
		Lcp_706_ListNode previous = findPrevious(index, key);
		if (previous.next == null) { return; }
		previous.next = previous.next.next;
		size--;
	}
	
	public int hash(int key) {
		return key % bucket.length;
	}
	
	public void rehash() {
		size = 0;
		Lcp_706_ListNode[] oldBucket = bucket;
		bucket = new Lcp_706_ListNode[oldBucket.length * 2];
		for (Lcp_706_ListNode oldNode : oldBucket) {
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
	
	public Lcp_706_ListNode findPrevious(int index, int key) {
		Lcp_706_ListNode current = bucket[index];
		if (current == null) { return bucket[index] = new Lcp_706_ListNode(-1, -1); }
		while (current.next != null && current.next.key != key) { current = current.next; }
		return current;
	}
	
}
