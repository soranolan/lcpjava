package com.example.lcpjava.binarytree;

import com.example.lcpjava.common.TreeNode;

public class Lcp_2236_Root_Equals_Sum_of_Children {
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public boolean checkTree(TreeNode root) {
		return root.val == root.left.val + root.right.val;
	}
	
}
