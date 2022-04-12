package com.example.lcpjava.common;

public class Pair {
	
	private TreeNode node;
	
	private Integer state;
	
	public Pair() {  }
	
	public Pair(TreeNode node, Integer state) {
		this.node = node;
		this.state = state;
	}
	
	public TreeNode getNode() {
		return node;
	}
	
	public Integer getState() {
		return state;
	}
	
}
