package com.example.lcpjava.common;

import java.util.List;
import java.util.Objects;

public class N_Ary_TreeNode {
	
	public int val;
	
	public List<N_Ary_TreeNode> children;
	
	public N_Ary_TreeNode() {  }
	
	public N_Ary_TreeNode(int val) {
		this.val = val;
	}
	
	public N_Ary_TreeNode(int val, List<N_Ary_TreeNode> children) {
		this.val = val;
		this.children = children;
	}
	
	@Override
	public String toString() {
		return "N_Ary_TreeNode [val=" + val + ", children=" + children + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(children, val);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		N_Ary_TreeNode other = (N_Ary_TreeNode) obj;
		return Objects.equals(children, other.children) && val == other.val;
	}
	
}
