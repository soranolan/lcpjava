package com.example.lcpjava.common;

public class MyHashTreeNode {
	
	public int key;
	
	public int val;
	
	public MyHashTreeNode left;
	
	public MyHashTreeNode right;
	
	public MyHashTreeNode() {  }
	
	public MyHashTreeNode(int val) {
		this.val = val;
	}
	
	public MyHashTreeNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
	
	public MyHashTreeNode(int val, MyHashTreeNode left, MyHashTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
}
