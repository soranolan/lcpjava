package com.example.lcpjava.hashtable;

public class MyHashMap_1 {
	
	public int[] bucket;
	
	public MyHashMap_1() {
		bucket = new int[1000000 + 1];
	}
	
	public void put(int key, int value) {
		bucket[key] = value + 1;
	}
	
	public int get(int key) {
		return bucket[key] - 1;
	}
	
	public void remove(int key) {
		bucket[key] = 0;
	}
	
}
