package com.example.lcpjava.common;

import java.util.Objects;

public class Lcp_297_TreeNode {
	
	public int val;
	
	public Lcp_297_TreeNode left;
	
	public Lcp_297_TreeNode right;
	
	public Lcp_297_TreeNode() {  }
	
	public Lcp_297_TreeNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		return "Lcp_297_TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
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
		Lcp_297_TreeNode other = (Lcp_297_TreeNode) obj;
		return Objects.equals(left, other.left) && Objects.equals(right, other.right) && val == other.val;
	}
	
}
