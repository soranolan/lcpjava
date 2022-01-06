package com.example.lcpjava.hashtable;

public class MyHashSet_2 {
	
	boolean[] bucket;
	
	public MyHashSet_2() {
		bucket = new boolean[1];
	}
	
	public void add(int key) {
		if (key > bucket.length - 1) {
			boolean[] newBucket = new boolean[key + bucket.length * 2];
			System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
			bucket = newBucket;
		}
		bucket[key] = true;
	}
	
	public void remove(int key) {
		if (key > bucket.length - 1) { return; }
		bucket[key] = false;
	}
	
	public boolean contains(int key) {
		if (key > bucket.length - 1) { return false; }
		return bucket[key];
	}
	
}
