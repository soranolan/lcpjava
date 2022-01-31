package com.example.lcpjava.hashtable;

public class TreeNode {
	
	public int key;
	
	public int val;
	
	public TreeNode left;
	
	public TreeNode right;
	
	public TreeNode() {  }
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
}
