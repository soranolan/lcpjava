package com.example.lcpjava.hashtable;

public class MyHashSet_3 {
	
	int[] bucket;
	
	public MyHashSet_3() {
		bucket = new int[1000000 / 32 + 1];
	}
	
	public void add(int key) {
		bucket[hash(key)] |= bit(key);
	}
	
	public void remove(int key) {
		bucket[hash(key)] &= ~bit(key);
	}
	
	public boolean contains(int key) {
		return (bucket[hash(key)] & bit(key)) != 0;
	}
	
	public int hash(int key) {
		return key / 32;
	}
	
	public int bit(int key) {
		key %= 32;
		return 1 << key;
	}
	
}
