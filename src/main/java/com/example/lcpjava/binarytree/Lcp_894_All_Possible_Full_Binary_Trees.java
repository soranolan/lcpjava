package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.example.lcpjava.common.Lcp_894_TreeNode;

public class Lcp_894_All_Possible_Full_Binary_Trees {
	
	/**
	 * time  : O(N!)
	 * space : O(N!)
	 * 
	 * https://leetcode.com/problems/all-possible-full-binary-trees/discuss/618779/Python-3-solution-(Recursion-Memoization-DP)-with-explantions
	 * 
	 * 
	 * return recursion(n)
	 * */
	public List<Lcp_894_TreeNode> allPossibleFBT_1(int n) {
		return recursion(n);
	}
	
	/**
	 * List<TreeNode> result <- new ArrayList
	 * 
	 * if nodes modulo two is equal to zero
	 * 		return result
	 * end if
	 * 
	 * if nodes is equal to one
	 * 		result add(new TreeNode(zero))
	 * 		return result
	 * end if
	 * 
	 * for int leftNode <- 0; if leftNode is lower than nodes; leftNode++
	 * 		int rightNode <- nodes minus root minus leftNode
	 * 		
	 * 		for TreeNode left in recursion(leftNode)
	 * 			for TreeNode right in recursion(rightNode)
	 * 				TreeNode current <- new TreeNode(0)
	 * 				current left <- left
	 * 				current right <- right
	 * 				result add(current)
	 * 			end for
	 * 		end for
	 * end for
	 * 
	 * return result
	 * */
	public List<Lcp_894_TreeNode> recursion(int nodes) {
		List<Lcp_894_TreeNode> result = new ArrayList<>();
		
		if (nodes % 2 == 0) { return result; }
		if (nodes == 1) {
			result.add(new Lcp_894_TreeNode(0));
			return result;
		}
		
		for (int leftNode = 0; leftNode < nodes; leftNode++) {
			int rightNode = nodes - 1 - leftNode;																	// total - root - left
			
			for (Lcp_894_TreeNode left : recursion(leftNode)) {
				for (Lcp_894_TreeNode right : recursion(rightNode)) {
					Lcp_894_TreeNode current = new Lcp_894_TreeNode(0);
					current.left = left;
					current.right = right;
					result.add(current);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * Recursion Memoization
	 * 
	 * 
	 * Map<Integer, List<TreeNode>> memo <- new HashMap
	 * 
	 * return recursion(n, memo)
	 * */
	public List<Lcp_894_TreeNode> allPossibleFBT_2(int n) {
		Map<Integer, List<Lcp_894_TreeNode>> memo = new HashMap<>();
		return recursion(n, memo);
	}
	
	/**
	 * if memo contains nodes
	 * 		return memo get(nodes)
	 * end if
	 * 
	 * List<TreeNode> result <- new ArrayList
	 * 
	 * if nodes is equal to one
	 * 		result add(new TreeNode(0))
	 * else if nodes modulo two is equal to one
	 * 		for int leftNode <- 0; if leftNode is lower than nodes; leftNode++
	 * 			int rightNode <- nodes minus root minus leftNode
	 * 			
	 * 			for TreeNode left in recursion(leftNode, memo)
	 * 				for TreeNode right in recursion(rightNode, memo)
	 * 					TreeNode current <- new TreeNode(0)
	 * 					current left <- left
	 * 					current right <- right
	 * 					result add(current)
	 * 				end for
	 * 			end for
	 * 		end for
	 * end if
	 * 
	 * memo put(nodes, result)
	 * 
	 * return memo get(nodes)
	 * */
	public List<Lcp_894_TreeNode> recursion(int nodes, Map<Integer, List<Lcp_894_TreeNode>> memo) {
		if (memo.containsKey(nodes)) { return memo.get(nodes); }
		
		List<Lcp_894_TreeNode> result = new ArrayList<>();
		
		if (nodes == 1) {
			result.add(new Lcp_894_TreeNode(0));
		} else if (nodes % 2 == 1) {
			for (int leftNode = 0; leftNode < nodes; leftNode++) {
				int rightNode = nodes - 1 - leftNode;																// total - root - left
				
				for (Lcp_894_TreeNode left : recursion(leftNode, memo)) {
					for (Lcp_894_TreeNode right : recursion(rightNode, memo)) {
						Lcp_894_TreeNode current = new Lcp_894_TreeNode(0);
						current.left = left;
						current.right = right;
						result.add(current);
					}
				}
			}
		}
		
		memo.put(nodes, result);
		return memo.get(nodes);
	}
	
	/**
	 * time  : O(2 ^ n)
	 * space : O(2 ^ n)
	 * 
	 * Bottom-Up
	 * 
	 * 
	 * if n modulo two is equal to zero
	 * 		return new ArrayList
	 * end if
	 * 
	 * List<List<TreeNode>> dp <- new ArrayList<List<TreeNode>>(n plus one)
	 * fill dp with new ArrayList
	 * 
	 * dp get(one) add(new TreeNode(0))
	 * 
	 * for int nodes <- 3; if nodes is lower than n plus one; nodes <- nodes plus two
	 * 		for int leftNode <- 1; if leftNode is lower than nodes; leftNode <- leftNode plus two
	 * 			int rightNode <- nodes minus root minus leftNode
	 * 			
	 * 			for TreeNode left in dp get(leftNode)
	 * 				for TreeNode right in dp get(rightNode)
	 * 					TreeNode current <- new TreeNode(0)
	 * 					current left <- left
	 * 					current right <- right
	 * 					dp get(nodes) add(current)
	 * 				end for
	 * 			end for
	 * 		end for
	 * end for
	 * 
	 * return dp get(n)
	 * */
	public List<Lcp_894_TreeNode> allPossibleFBT_3(int n) {
		if (n % 2 == 0) { return new ArrayList<>(); }
		
		List<List<Lcp_894_TreeNode>> dp = new ArrayList<List<Lcp_894_TreeNode>>(n + 1);
		for (int i = 0; i < n + 1; i++) { dp.add(new ArrayList<>()); }
		
		dp.get(1).add(new Lcp_894_TreeNode(0));
		
		for (int nodes = 3; nodes < n + 1; nodes += 2) {
			for (int leftNode = 1; leftNode < nodes; leftNode += 2) {
				int rightNode = nodes - 1 - leftNode;																// total - root - left
				
				for (Lcp_894_TreeNode left : dp.get(leftNode)) {
					for (Lcp_894_TreeNode right : dp.get(rightNode)) {
						Lcp_894_TreeNode current = new Lcp_894_TreeNode(0);
						current.left = left;
						current.right = right;
						dp.get(nodes).add(current);
					}
				}
			}
		}
		
		return dp.get(n);
	}
	
	/**
	 * time  : O(n * 2 ^ n)
	 * space : O(n * 2 ^ n)
	 * 
	 * Beware of the link between binary tree
	 * 
	 * https://leetcode.com/problems/all-possible-full-binary-trees/discuss/167402/c%2B%2B-c-java-and-pything-recursive-and-iterative-solutions.-Doesn't-create-Frankenstein-trees
	 * */
	public List<Lcp_894_TreeNode> allPossibleFBT_4(int n) {
		List<Lcp_894_TreeNode> result = new ArrayList<>();
		
		if (n % 2 == 0) { return result; }
		if (n == 1) {
			result.add(new Lcp_894_TreeNode(0));
			return result;
		}
		
		for (int leftNode = 1; leftNode < n; leftNode += 2) {
			List<Lcp_894_TreeNode> branchL = allPossibleFBT_4(leftNode);
			List<Lcp_894_TreeNode> branchR = allPossibleFBT_4(n - 1 - leftNode);
			Iterator<Lcp_894_TreeNode> itL = branchL.iterator();
			
			while (itL.hasNext()) {
				Lcp_894_TreeNode left = itL.next();
				Iterator<Lcp_894_TreeNode> itR = branchR.iterator();
				
				while (itR.hasNext()) {
					Lcp_894_TreeNode right = itR.next();
					
					Lcp_894_TreeNode current = new Lcp_894_TreeNode(0);
					
					current.left = itR.hasNext() ? clone(left) : left;
					current.right = itL.hasNext() ? clone(right) : right;
					
					result.add(current);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n * 2 ^ n)
	 * space : O(n * 2 ^ n)
	 * */
	public List<Lcp_894_TreeNode> allPossibleFBT(int n) {
		List<Lcp_894_TreeNode> result = new ArrayList<>();
		if (n % 2 == 0) { return result; }
		if (n == 1) {
			result.add(new Lcp_894_TreeNode(0));
			return result;
		}
		
		List<List<Lcp_894_TreeNode>> memo = new ArrayList<List<Lcp_894_TreeNode>>();
		memo.add(new ArrayList<>());
		memo.get(0).add(new Lcp_894_TreeNode(0));
		
		int childNodes = n / 2;
		
		for (int childNode = 1; childNode < childNodes; childNode++) {
			List<Lcp_894_TreeNode> temp = new ArrayList<>();
			
			for (int leftNodeIndex = 0; leftNodeIndex < childNode; leftNodeIndex++) {
				for (Lcp_894_TreeNode left : memo.get(leftNodeIndex)) {
					for (Lcp_894_TreeNode right : memo.get(childNode - leftNodeIndex - 1)) {
						Lcp_894_TreeNode current = new Lcp_894_TreeNode(0);
						current.left = left;
						current.right = right;
						temp.add(current);
					}
				}
			}
			
			memo.add(temp);
		}
		
		for (int leftNodeIndex = 0; leftNodeIndex < childNodes; leftNodeIndex++) {
			for (Lcp_894_TreeNode left : memo.get(leftNodeIndex)) {
				for (Lcp_894_TreeNode right : memo.get(childNodes - leftNodeIndex - 1)) {
					Lcp_894_TreeNode current = new Lcp_894_TreeNode(0);
					current.left = clone(left);
					current.right = clone(right);
					result.add(current);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public Lcp_894_TreeNode clone(Lcp_894_TreeNode oldTree) {
		if (oldTree == null) { return null; }
		
		Lcp_894_TreeNode newTree = new Lcp_894_TreeNode(oldTree.val);
		newTree.left = clone(oldTree.left);
		newTree.right = clone(oldTree.right);
		
		return newTree;
	}
	
}
