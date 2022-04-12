package com.example.lcpjava.common;

import java.util.Objects;

public class TreeNode {
	
	public int val;
	
	public TreeNode left;
	
	public TreeNode right;
	
	public TreeNode() {  }
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
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
		TreeNode other = (TreeNode) obj;
		return Objects.equals(left, other.left) && Objects.equals(right, other.right) && val == other.val;
	}
	
}
