package com.example.lcpjava.common;

import java.util.Objects;

public class Lcp_226_TreeNode {
	
	public int val;
	
	public Lcp_226_TreeNode left;
	
	public Lcp_226_TreeNode right;
	
	public Lcp_226_TreeNode() {  }
	
	public Lcp_226_TreeNode(int val) {
		this.val = val;
	}
	
	public Lcp_226_TreeNode(int val, Lcp_226_TreeNode left, Lcp_226_TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Lcp_226_TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(left, right, val);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lcp_226_TreeNode other = (Lcp_226_TreeNode) obj;
		return Objects.equals(left, other.left) && Objects.equals(right, other.right) && val == other.val;
	}
	
}
