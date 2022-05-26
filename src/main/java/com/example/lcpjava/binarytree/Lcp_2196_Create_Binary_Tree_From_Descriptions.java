package com.example.lcpjava.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.lcpjava.common.TreeNode;

public class Lcp_2196_Create_Binary_Tree_From_Descriptions {
	
	/**
	 * time  : O(node)
	 * space : O(descriptions)
	 * */
	public TreeNode createBinaryTree_1(int[][] descriptions) {
		int root = findRoot(descriptions);
		
		Map<Integer, List<int[]>> graph = new HashMap<>();															// S : O(descriptions)
		buildGraph(graph, descriptions);
		
		return buildTree(root, graph);																				// T : O(node)
	}
	
	private int findRoot(int[][] descriptions) {
		int root = -1;
		Set<Integer> childSet = new HashSet<>();																	// S : O(node - root)
		
		for (int[] desc : descriptions) { childSet.add(desc[1]); }													// T : O(node - root)
		
		for (int[] desc : descriptions) {																			// T : O(node - root) 
			if (!childSet.contains(desc[0])) {
				return desc[0];
			}
		}
		
		return root;
	}
	
	private void buildGraph(Map<Integer, List<int[]>> graph, int[][] descriptions) {
		for (int[] desc : descriptions) {																			// T : O(node - root) 
			int parentValue = desc[0];
			int childValue = desc[1];
			int isLeft = desc[2];
			
			if (!graph.containsKey(parentValue)) { graph.put(parentValue, new ArrayList<>()); }
			graph.get(parentValue).add(new int[] { childValue, isLeft });
		}
	}
	
	/**
	 * 50 20,1 80,0
	 * 20 15,1 17,0
	 * 80 19,1
	 */
	private TreeNode buildTree(int root, Map<Integer, List<int[]>> graph) {
		TreeNode current = new TreeNode(root);
		if (!graph.containsKey(root)) { return current; }
		
		for (int[] child : graph.get(root)) {
			int value = child[0];
			int isLeft = child[1];
			
			if (isLeft == 1) {
				current.left = buildTree(value, graph);
			} else {
				current.right = buildTree(value, graph);
			}
		}
		
		return current;
	}
	
	/**
	 * time  : O(node)
	 * space : O(node)
	 * 
	 * https://leetcode.com/problems/create-binary-tree-from-descriptions/discuss/1823716/Simple-Java-Solution-or-HashMap
	 * */
	public TreeNode createBinaryTree_2(int[][] descriptions) {
		Map<Integer, TreeNode> memo = new HashMap<>();																// S : O(node)
		Set<Integer> childSet = new HashSet<>();																	// S : O(node - root)
		
		for (int[] desc : descriptions) {																			// T : O(node - root) 
			int parentValue = desc[0];
			int childValue = desc[1];
			int isLeft = desc[2];
			
			childSet.add(childValue);
			
			TreeNode parent = memo.getOrDefault(parentValue, new TreeNode(parentValue));
			TreeNode child = memo.getOrDefault(childValue, new TreeNode(childValue));
			
			if (isLeft == 1) {
				parent.left = child;
			} else {
				parent.right = child;
			}
			
			memo.put(childValue, child);
			memo.put(parentValue, parent);
		}
		
		int root = -1;
		
		for (int[] desc : descriptions) {																			// T : O(node - root) 
			if (!childSet.contains(desc[0])) {
				root = desc[0];
				break;
			}
		}
		
		return memo.get(root);
	}
	
	/**
	 * time  : O(node)
	 * space : O(node)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public TreeNode createBinaryTree_3(int[][] descriptions) {
		Map<Integer, TreeNode> memo = new HashMap<>();																// S : O(node)
		Set<Integer> childSet = new HashSet<>();																	// S : O(node - root)
		for (int[] desc : descriptions) { childSet.add(desc[1]); }													// T : O(node - root)
		
		TreeNode root = null;
		for (int[] desc : descriptions) {																			// T : O(node - root) 
			int parentValue = desc[0];
			int childValue = desc[1];
			int isLeft = desc[2];
			
			if (!memo.containsKey(parentValue)) { memo.put(parentValue, new TreeNode(parentValue)); }
			if (!memo.containsKey(childValue)) { memo.put(childValue, new TreeNode(childValue)); }
			
			if (isLeft == 1) {
				memo.get(parentValue).left = memo.get(childValue);
			} else {
				memo.get(parentValue).right = memo.get(childValue);
			}
			
			if (root == null && !childSet.contains(parentValue)) { root = memo.get(parentValue); }
		}
		
		return root;
	}
	
	/**
	 * time  : O(node)
	 * space : O(node)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public TreeNode createBinaryTree(int[][] descriptions) {
		TreeNode[] nodes = new TreeNode[100000 + 1];																// S : O(node)
		for (int[] desc : descriptions) {																			// T : O(node - root)
			int childValue = desc[1];
			if (nodes[childValue] == null) { nodes[childValue] = new TreeNode(childValue); }
		}
		
		TreeNode root = null;
		
		for (int[] desc : descriptions) {																			// T : O(node - root)
			int parentValue = desc[0];
			int childValue = desc[1];
			int isLeft = desc[2];
			
			TreeNode parent = nodes[parentValue];
			TreeNode child = nodes[childValue];
			
			if (parent == null) {
				parent = new TreeNode(parentValue);
				nodes[parentValue] = parent;
				root = parent;
			}
			
			if (isLeft == 1) {
				parent.left = child;
			} else {
				parent.right = child;
			}
		}
		
		return root;
	}
	
}
