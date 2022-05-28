package com.example.lcpjava.binarytree;

import com.example.lcpjava.common.TreeNode;

public class Lcp_1339_Maximum_Product_of_Splitted_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496549/JavaC%2B%2BPython-Easy-and-Concise
	 * */
	public int maxProduct(TreeNode root) {
		long[] max = new long[1];
		long totalSum = 0L;
		
		// get total sum
		totalSum = traversal(root, totalSum, max);
		
		// get max product
		traversal(root, totalSum, max);
		
		return (int) (max[0] % (1e9 + 7));
	}
	
	private long traversal(TreeNode current, long totalSum, long[] max) {
		if (current == null) { return 0L; }
		
		long subtreeSum = current.val + traversal(current.left, totalSum, max) + traversal(current.right, totalSum, max);
		
		max[0] = Math.max(max[0], (totalSum - subtreeSum) * subtreeSum);
		
		return subtreeSum;
	}
	
}
