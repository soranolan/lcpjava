package com.example.lcpjava.hashtable;

import com.example.lcpjava.common.Lcp_706_ListNode;

public class MyHashMap_2 {
	
	public Lcp_706_ListNode[] bucket;
	
	public MyHashMap_2() {
		bucket = new Lcp_706_ListNode[10000 + 1];
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		Lcp_706_ListNode previous = findPrevious(index, key);
		if (previous.next == null) {
			previous.next = new Lcp_706_ListNode(key, value);
			return;
		}
		previous.next.val = value;
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
	}
	
	public int hash(int key) {
		return Integer.hashCode(key) % bucket.length;
	}
	
	public Lcp_706_ListNode findPrevious(int index, int key) {
		Lcp_706_ListNode current = bucket[index];
		if (current == null) { return bucket[index] = new Lcp_706_ListNode(-1, -1); }
		while (current.next != null && current.next.key != key) { current = current.next; }
		return current;
	}
	
}
