package com.example.lcpjava.binarysearchtree;

import java.util.Objects;

public class TreeNode {
	
	int count;
	
	int val;
	
	TreeNode left;
	
	TreeNode right;
	
	TreeNode() {  }
	
	TreeNode(int val) {
		this.val = val;
		this.count = 1;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(val);
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
		return val == other.val;
	}
	
}
