package com.example.lcpjava.hashtable;

public class MyHashMap_2 {
	
	public ListNode[] bucket;
	
	public MyHashMap_2() {
		bucket = new ListNode[10000 + 1];
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		ListNode previous = findPrevious(index, key);
		if (previous.next == null) {
			previous.next = new ListNode(key, value);
			return;
		}
		previous.next.val = value;
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
	}
	
	public int hash(int key) {
		return Integer.hashCode(key) % bucket.length;
	}
	
	public ListNode findPrevious(int index, int key) {
		if (bucket[index] == null) { return bucket[index] = new ListNode(-1, -1); }
		ListNode current = bucket[index];
		while (current.next != null && current.next.key != key) { current = current.next; }
		return current;
	}
	
}
