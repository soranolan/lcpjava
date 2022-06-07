package com.example.lcpjava.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import com.example.lcpjava.common.TreeNode;

public class Lcp_95_Unique_Binary_Search_Trees_II {
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/1023791/Java-Recursion-Along-with-Recursion-Tree-Figure-Explanation
	 * */
	public List<TreeNode> generateTrees_1(int n) {
		if (n == 0) { return new ArrayList<>(); }
		return generate(1, n);
	}
	
	private List<TreeNode> generate(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		
		if (start > end) {
			result.add(null);
			return result;
		}
		
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubtree = generate(start, i - 1);
			List<TreeNode> rightSubtree = generate(i + 1, end);
			for (TreeNode left : leftSubtree) {
				for (TreeNode right : rightSubtree) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					result.add(root);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31493/Java-Solution-with-DP
	 * https://leetcode.wang/leetCode-95-Unique-Binary-Search-TreesII.html#%E8%A7%A3%E6%B3%95%E4%B8%89-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92
	 * */
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) { return new ArrayList<>(); }
		
		List<List<TreeNode>> dp = new ArrayList<>(n + 1);
		dp.add(new ArrayList<>());
		dp.get(0).add(null);
		
		for (int nodes = 1; nodes <= n; nodes++) {
			dp.add(new ArrayList<>());
			
			for (int rootValue = 1; rootValue <= nodes; rootValue++) {
				int leftNodes = rootValue - 1;
				int rightNodes = nodes - rootValue;
				
				for (TreeNode left : dp.get(leftNodes)) {
					for (TreeNode right : dp.get(rightNodes)) {
						TreeNode root = new TreeNode(rootValue);
						root.left = left;
						root.right = generate(right, rootValue);
						dp.get(nodes).add(root);
					}
				}
			}
		}
		
		return dp.get(n);
	}
	
	/**
	 * total nodes ( n ) = 6
	 * root = 4
	 * we need two more right nodes ( n ) = 2
	 * if we get previous subproblem total nodes ( n ) = 2 will return                           [ 1, null, 2 ] [ 2, null, 1 ]
	 * but due to binary search tree, right subtree should be greater than root, what we want is [ 5, null, 6 ] [ 6, null, 5 ]
	 * so we need to add the offset ( 4 ) to build the valid subtree
	 * */
	private TreeNode generate(TreeNode oldNode, int offset) {
		if (oldNode == null) { return null; }
		
		TreeNode newNode = new TreeNode(oldNode.val + offset);
		newNode.left = generate(oldNode.left, offset);
		newNode.right = generate(oldNode.right, offset);
		
		return newNode;
	}
	
}
