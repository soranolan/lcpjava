package com.example.lcpjava.common;

import java.util.Objects;

public class Lcp_106_TreeNode {
	
	public int val;
	
	public Lcp_106_TreeNode left;
	
	public Lcp_106_TreeNode right;
	
	public Lcp_106_TreeNode() {  }
	
	public Lcp_106_TreeNode(int val) {
		this.val = val;
	}
	
	public Lcp_106_TreeNode(int val, Lcp_106_TreeNode left, Lcp_106_TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Lcp_106_TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	// TODO why? can't recall it
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lcp_106_TreeNode other = (Lcp_106_TreeNode) obj;
		return Objects.equals(left, other.left) && Objects.equals(right, other.right) && val == other.val;
	}
	
}
