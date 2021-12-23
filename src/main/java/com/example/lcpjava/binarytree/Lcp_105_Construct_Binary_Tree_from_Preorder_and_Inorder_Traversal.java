package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.Map;

public class Lcp_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if preorder is equal to null || inorder is equal to null || preorder length is not equal to inorder length
	 * 		return null
	 * end if
	 * 
	 * preIndex <- 0
	 * Map<Integer, Integer> memo <- new HashMap
	 * for int i <- 0; if i is lower than inorder length; i++
	 * 		memo put(inorder[i], i)
	 * end for
	 * 
	 * return build(preorder, 0, inorder length minus one, memo)
	 * */
	public TreeNode buildTree_1(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) { return null; }
		
		preIndex = 0;
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(n)
		for (int i = 0; i < inorder.length; i++) { memo.put(inorder[i], i); }										// T : O(n)
		
		return build_1(preorder, 0, inorder.length - 1, memo);
	}
	
	/**
	 * if inStart is greater than inEnd
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(preorder[preIndex])
	 * preIndex++
	 * 
	 * int rootIndex <- memo get(current val)
	 * 
	 * current left <- build(preorder, inStart, rootIndex minus one, memo)
	 * current right <- build(preorder, rootIndex plus one, inEnd, memo)
	 * 
	 * return current
	 * */
	public TreeNode build_1(int[] preorder, int inStart, int inEnd, Map<Integer, Integer> memo) {
		if (inStart > inEnd) { return null; }
		
		TreeNode current = new TreeNode(preorder[preIndex]);
		preIndex++;
		
		int rootIndex = memo.get(current.val);
		
		current.left = build_1(preorder, inStart, rootIndex - 1, memo);
		current.right = build_1(preorder, rootIndex + 1, inEnd, memo);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if preorder is equal to null || inorder is equal to null || preorder length is not equal to inorder length
	 * 		return null
	 * end if
	 * 
	 * preIndex <- 0
	 * inIndex <- 0
	 * 
	 * return build(preorder, inorder, -3001)
	 * */
	int preIndex;
	int inIndex;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) { return null; }
		
		preIndex = 0;
		inIndex = 0;
		
		return build(preorder, inorder, -3001);
	}
	
	/**
	 * if preIndex is greater than or equal to preorder length
	 * 		return null
	 * end if
	 * 
	 * if inorder[inIndex] is equal to rootValue
	 * 		inIndex++
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(preorder[preIndex])
	 * preIndex++
	 * 
	 * current left <- build(preorder, inorder, current val)
	 * current right <- build(preorder, inorder, rootValue)
	 * 
	 * return current
	 * */
	public TreeNode build(int[] preorder, int[] inorder, int rootValue) {
		if (preIndex >= preorder.length) { return null; }
		
		if (inorder[inIndex] == rootValue) {
			inIndex++;
			return null;
		}
		
		TreeNode current = new TreeNode(preorder[preIndex]);
		preIndex++;
		
		current.left = build(preorder, inorder, current.val);
		current.right = build(preorder, inorder, rootValue);
		
		return current;
	}
	
}
