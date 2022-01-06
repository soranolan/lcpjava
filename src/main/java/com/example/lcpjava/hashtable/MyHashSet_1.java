package com.example.lcpjava.hashtable;

public class MyHashSet_1 {
	
	boolean[] bucket;
	
	public MyHashSet_1() {
		bucket = new boolean[1000000 + 1];
	}
	
	public void add(int key) {
		bucket[key] = true;
	}
	
	public void remove(int key) {
		bucket[key] = false;
	}
	
	public boolean contains(int key) {
		return bucket[key];
	}
	
}
