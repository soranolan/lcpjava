package com.example.lcpjava.common;

public class Lcp_230_TreeNode {
	
	public int count;
	
	public int val;
	
	public Lcp_230_TreeNode left;
	
	public Lcp_230_TreeNode right;
	
	public Lcp_230_TreeNode() {  }
	
	public Lcp_230_TreeNode(int val) {
		this.val = val;
		this.count = 1;
	}
	
	public Lcp_230_TreeNode(int val, Lcp_230_TreeNode left, Lcp_230_TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
}
