package com.example.lcpjava.binarytree;

import java.util.LinkedList;
import java.util.List;

import com.example.lcpjava.common.TreeNode;

public class Lcp_113_Path_Sum_II {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/path-sum-ii/discuss/36695/Java-Solution%3A-iterative-and-recursive
	 * https://leetcode.com/problems/path-sum-ii/discuss/36683/DFS-with-one-LinkedList-accepted-java-solution
	 * https://leetcode.com/problems/path-sum-ii/discuss/1382332/C%2B%2BPython-DFS-Clean-and-Concise-Time-complexity-explained
	 * */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> bucket = new LinkedList<>();
		
		traverse(0, targetSum, root, bucket, result);
		
		return result;
	}
	
	private void traverse(int sum, int targetSum, TreeNode current, List<Integer> bucket, List<List<Integer>> result) {
		if (current == null) { return; }
		
		sum += current.val;
		bucket.add(current.val);
		
		if (current.left == null && current.right == null) {
			if (sum == targetSum) { result.add(new LinkedList<Integer>(bucket)); }
			return;
		}
		
		if (current.left != null) {
			traverse(sum, targetSum, current.left, bucket, result);
			bucket.remove(bucket.size() - 1);
		}
		
		if (current.right != null) {
			traverse(sum, targetSum, current.right, bucket, result);
			bucket.remove(bucket.size() - 1);
		}
	}
	
}
