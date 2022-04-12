package com.example.lcpjava.common;

public class Pair {
	
	private Lcp_236_TreeNode node;
	
	private Integer state;
	
	public Pair() {  }
	
	public Pair(Lcp_236_TreeNode node, Integer state) {
		this.node = node;
		this.state = state;
	}
	
	public Lcp_236_TreeNode getNode() {
		return node;
	}
	
	public Integer getState() {
		return state;
	}
	
}
