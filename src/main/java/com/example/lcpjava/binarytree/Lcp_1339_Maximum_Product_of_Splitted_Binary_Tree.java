package com.example.lcpjava.binarytree;

import com.example.lcpjava.common.TreeNode;

public class Lcp_1339_Maximum_Product_of_Splitted_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/discuss/496549/JavaC%2B%2BPython-Easy-and-Concise
	 * */
	public int maxProduct_1(TreeNode root) {
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
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * */
	public int maxProduct(TreeNode root) {
		long[] product = new long[1];
		
		long sum = getSum(root);
		
		getProduct(root, sum, product);
		
		return (int) (product[0] % 1000000007);
	}
	
	private long getSum(TreeNode current) {
		if (current == null) { return 0L; }
		
		long left = getSum(current.left);
		long right = getSum(current.right);
		
		return current.val + left + right;
	}
	
	private long getProduct(TreeNode current, long sum, long[] product) {
		if (current == null) { return 0L; }
		
		long left = getProduct(current.left, sum, product);
		long right = getProduct(current.right, sum, product);
		long subtreeSum = current.val + left + right;
		
		product[0] = Math.max(product[0], (sum - subtreeSum) * subtreeSum);
		
		return subtreeSum;
	}
	
}
