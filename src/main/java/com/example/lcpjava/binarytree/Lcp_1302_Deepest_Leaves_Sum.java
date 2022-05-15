package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.example.lcpjava.common.TreeNode;

public class Lcp_1302_Deepest_Leaves_Sum {
	
	/**
	 * time  : O(n)
	 * space : O(depth)
	 * 
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * recursive(zero, root, memo)
	 * 
	 * int maxDepth <- minus one
	 * int sum <- zero
	 * 
	 * for int depth in memo keySet()
	 * 		if depth is greater than maxDepth
	 * 			sum <- memo get(depth)
	 * 			maxDepth <- depth
	 * 		end if
	 * end for
	 * 
	 * return sum
	 * */
	public int deepestLeavesSum_1(TreeNode root) {
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(depth)
		
		recursive_1(0, root, memo);																					// T : O(n)
		
		int maxDepth = -1;
		int sum = 0;
		
		for (int depth : memo.keySet()) {																			// T : O(depth)
			if (depth > maxDepth) {
				sum = memo.get(depth);
				maxDepth = depth;
			}
		}
		
		return sum;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * memo put(depth, memo getOrDefault(depth, zero) plus current val)
	 * 
	 * recursive(depth plus one, current left, memo)
	 * recursive(depth plus one, current right, memo)
	 * */
	private void recursive_1(int depth, TreeNode current, Map<Integer, Integer> memo) {
		if (current == null) { return; }
		
		memo.put(depth, memo.getOrDefault(depth, 0) + current.val);
		
		recursive_1(depth + 1, current.left, memo);
		recursive_1(depth + 1, current.right, memo);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/deepest-leaves-sum/discuss/463239/JavaC%2B%2BPython-Level-Traversal
	 * 
	 * 
	 * int result <- zero
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * while queue is not empty
	 * 		int size <- queue size
	 * 		int sum <- zero
	 * 		
	 * 		for int i <- 0; if i is lower than size; i++
	 * 			TreeNode current <- queue poll
	 * 			
	 * 			if current is equal to null
	 * 				continue
	 * 			end if
	 * 			
	 * 			sum <- sum plus current val
	 * 			
	 * 			if current left is not equal to null
	 * 				queue offer(current left)
	 * 			end if
	 * 			
	 * 			if current right is not equal to null
	 * 				queue offer(current right)
	 * 			end if
	 * 		end for
	 * 		
	 * 		result <- sum
	 * end while
	 * 
	 * return result
	 * */
	public int deepestLeavesSum_2(TreeNode root) {
		int result = 0;
		
		Queue<TreeNode> queue = new LinkedList<>();																	// S : O(n)
		queue.offer(root);
		
		while (!queue.isEmpty()) {																					// T : O(n)
			int size = queue.size();
			int sum = 0;
			
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if (current == null) { continue; }
				
				sum += current.val;
				
				if (current.left != null) { queue.offer(current.left); }
				if (current.right != null) { queue.offer(current.right); }
			}
			
			result = sum;
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(depth)
	 * 
	 * List<Integer> memo <- new ArrayList
	 * memo add(zero)
	 * 
	 * recursive(zero, root, memo)
	 * 
	 * return memo get(memo size minus one)
	 * */
	public int deepestLeavesSum_3(TreeNode root) {
		List<Integer> memo = new ArrayList<>();																		// S : O(depth)
		memo.add(0);																								// T : O(1)
		
		recursive_3(0, root, memo);																					// T : O(n)
		
		return memo.get(memo.size() - 1);																			// T : O(1)
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * while depth is greater than or equal to memo size
	 * 		memo add(zero)
	 * end while
	 * 
	 * memo set(depth, memo get(depth) plus current val)
	 * 
	 * recursive(depth plus one, current left, memo)
	 * recursive(depth plus one, current right, memo)
	 * */
	private void recursive_3(int depth, TreeNode current, List<Integer> memo) {
		if (current == null) { return; }
		
		while (depth >= memo.size()) { memo.add(0); }
		
		memo.set(depth, memo.get(depth) + current.val);																// T : O(1)
		
		recursive_3(depth + 1, current.left, memo);
		recursive_3(depth + 1, current.right, memo);
	}
	
	/**
	 * time  : O(n)
	 * space : O(10001)
	 * 
	 * int[] memo <- new int[10000 plus one]
	 * 
	 * recursive(zero, root, memo)
	 * 
	 * for int i <- 10000; if i is greater than or equal to zero; i--
	 * 		if memo[i] is not equal to zero
	 * 			return memo[i]
	 * 		end if
	 * end for
	 * 
	 * return minus one
	 * */
	public int deepestLeavesSum_4(TreeNode root) {
		int[] memo = new int[10000 + 1];																			// S : O(10001)
		
		recursive_4(0, root, memo);																					// T : O(n)
		
		for (int i = 10000; i >= 0; i--) {																			// T : O(10001 - depth)
			if (memo[i] != 0) { return memo[i]; }
		}
		
		return -1;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * memo[depth] <- memo[depth] plus current val
	 * 
	 * recursive(depth plus one, current left, memo)
	 * recursive(depth plus one, current right, memo)
	 * */
	private void recursive_4(int depth, TreeNode current, int[] memo) {
		if (current == null) { return; }
		
		memo[depth] += current.val;
		
		recursive_4(depth + 1, current.left, memo);
		recursive_4(depth + 1, current.right, memo);
	}
	
	/**
	 * time  : O(n)
	 * space : O(2)
	 * 
	 * https://leetcode.com/problems/deepest-leaves-sum/discuss/565187/Java-Recursive-faster-than-100.00
	 * 
	 * 
	 * int[] maxDepth <- new int[one]
	 * int[] sum <- new int[one]
	 * 
	 * recursive(zero, root, maxDepth, sum)
	 * 
	 * return sum[zero]
	 * */
	public int deepestLeavesSum(TreeNode root) {
		int[] maxDepth = new int[1];																				// S : O(1)
		int[] sum = new int[1];																						// S : O(1)
		
		recursive(0, root, maxDepth, sum);																			// T : O(n)
		
		return sum[0];
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * if depth is equal to maxDepth[zero]
	 * 		sum[zero] <- sum[zero] plus current val
	 * end if
	 * 
	 * if depth is greater than maxDepth[zero]
	 * 		maxDepth[zero] <- depth
	 * 		sum[zero] <- current val
	 * end if
	 * 
	 * recursive(depth plus one, current left, maxDepth, sum)
	 * recursive(depth plus one, current right, maxDepth, sum)
	 * */
	private void recursive(int depth, TreeNode current, int[] maxDepth, int[] sum) {
		if (current == null) { return; }
		
		if (depth == maxDepth[0]) {
			sum[0] += current.val;
		}
		
		if (depth > maxDepth[0]) {
			maxDepth[0] = depth;
			sum[0] = current.val;
		}
		
		recursive(depth + 1, current.left, maxDepth, sum);
		recursive(depth + 1, current.right, maxDepth, sum);
	}
	
}
