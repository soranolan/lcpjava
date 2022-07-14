package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.example.lcpjava.common.TreeNode;

public class Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34555/The-iterative-solution-is-easier-than-you-think!
	 * */
	public TreeNode buildTree_1(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length) { return null; }
		
		int preIndex = 0;
		int inIndex = 0;
		
		TreeNode root = new TreeNode(preorder[preIndex]);
		preIndex++;
		
		Stack<TreeNode> stack = new Stack<>();																		// S : O(n)
		stack.push(root);																							// T : O(1)
		
		while (preIndex < preorder.length) {																		// T : O(n)
			TreeNode current = stack.peek();																		// T : O(1)
			
			if (current.val != inorder[inIndex]) {
				TreeNode left = new TreeNode(preorder[preIndex]);
				current.left = left;
				stack.push(left);																					// T : O(1)
				preIndex++;
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
					current = stack.pop();																			// T : O(1)
					inIndex++;
				}
				
				TreeNode right = new TreeNode(preorder[preIndex]);
				current.right = right;
				stack.push(right);																					// T : O(1)
				preIndex++;
			}
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
	 * */
	public TreeNode buildTree_2(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length) { return null; }
		
		int[] preIndex = new int[1];
		
		Map<Integer, Integer> value2Index = new HashMap<>();														// S : O(n)
		for (int i = 0; i < inorder.length; i++) { value2Index.put(inorder[i], i); }								// T : O(n)
		
		return build_1(preIndex, preorder, 0, inorder.length - 1, value2Index);
	}
	
	private TreeNode build_1(int[] preIndex, int[] preorder, int inStart, int inEnd, Map<Integer, Integer> value2Index) {
		if (inStart > inEnd) { return null; }
		
		TreeNode root = new TreeNode(preorder[preIndex[0]]);
		preIndex[0]++;
		
		int rootIndex = value2Index.get(root.val);
		
		root.left = build_1(preIndex, preorder, inStart, rootIndex - 1, value2Index);
		root.right = build_1(preIndex, preorder, rootIndex + 1, inEnd, value2Index);
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public TreeNode buildTree_3(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length) { return null; }
		
		int[] preIndex = new int[1];
		int[] inIndex = new int[1];
		
		return build_2(preIndex, inIndex, preorder, inorder, -3001);
	}
	
	private TreeNode build_2(int[] preIndex, int[] inIndex, int[] preorder, int[] inorder, int rootValue) {
		if (preIndex[0] >= preorder.length) { return null; }
		
		if (inorder[inIndex[0]] == rootValue) {
			inIndex[0]++;
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[preIndex[0]]);
		preIndex[0]++;
		
		root.left = build_2(preIndex, inIndex, preorder, inorder, root.val);
		root.right = build_2(preIndex, inIndex, preorder, inorder, rootValue);
		
		return root;
	}
	
	/**
	 * Accepted Solutions Runtime Distribution
	 * */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length != inorder.length) { return null; }
		
		int[] preIndex = new int[1];
		
		return build(preIndex, preorder, 0, inorder.length - 1, inorder);
	}
	
	private TreeNode build(int[] preIndex, int[] preorder, int inStart, int inEnd, int[] inorder) {
		if (inStart > inEnd) { return null; }
		
		TreeNode root = new TreeNode(preorder[preIndex[0]]);
		preIndex[0]++;
		
		int rootIndex = findIndex(inStart, inEnd, root.val, inorder);
		
		root.left = build(preIndex, preorder, inStart, rootIndex - 1, inorder);
		root.right = build(preIndex, preorder, rootIndex + 1, inEnd, inorder);
		
		return root;
	}
	
	private int findIndex(int inStart, int inEnd, int target, int[] inorder) {
		while (inStart < inEnd && inorder[inStart] != target && inorder[inEnd] != target) {
			inStart++;
			inEnd--;
		}
		return inorder[inStart] == target ? inStart : inEnd;
	}
	
}
