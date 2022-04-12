package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_106_TreeNode;

public class Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if inorder is equal to null || postorder is equal to null || inorder length is not equal to postorder length
	 * 		return null
	 * end if
	 * 
	 * int inIdx <- inorder length minus one
	 * int postIdx <- postorder length minus one
	 * 
	 * TreeNode root <- new TreeNode(postorder[postIdx])
	 * postIdx--
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * stack push(root)
	 * 
	 * while postIdx is greater than or equal to zero
	 * 		TreeNode current <- stack peek
	 * 		if current val is not equal to inorder[inIdx]
	 * 			TreeNode right <- new TreeNode(postorder[postIdx])
	 * 			current right <- right
	 * 			stack push(right)
	 * 			postIdx--
	 * 		else
	 * 			while stack is not empty && stack peek val is equal to inorder[inIdx]
	 * 				current <- stack pop
	 * 				inIdx--
	 * 			end while
	 * 			
	 * 			TreeNode left <- new TreeNode(postorder[postIdx])
	 * 			current left <- left
	 * 			stack push(left)
	 * 			postIdx--
	 * 		end if
	 * end while
	 * 
	 * return root
	 * */
	public Lcp_106_TreeNode buildTree_1(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
		
		int inIdx = inorder.length - 1;
		int postIdx = postorder.length - 1;
		
		Lcp_106_TreeNode root = new Lcp_106_TreeNode(postorder[postIdx]);
		postIdx--;
		
		Stack<Lcp_106_TreeNode> stack = new Stack<>();																// S : O(n)
		stack.push(root);
		
		while (postIdx >= 0) {
			Lcp_106_TreeNode current = stack.peek();
			if (current.val != inorder[inIdx]) {
				Lcp_106_TreeNode right = new Lcp_106_TreeNode(postorder[postIdx]);
				current.right = right;
				stack.push(right);
				postIdx--;
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]) {
					current = stack.pop();
					inIdx--;
				}
				
				Lcp_106_TreeNode left = new Lcp_106_TreeNode(postorder[postIdx]);
				current.left = left;
				stack.push(left);
				postIdx--;
			}
		}
		
		return root;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if inorder is equal to null || postorder is equal to null || inorder length is not equal to postorder length
	 * 		return null
	 * end if
	 * 
	 * Map<Integer, Integer> memo <- new HashMap
	 * for int i <- 0; if i is lower than inorder length; i++
	 * 		memo put(inorder[i], i)
	 * end for
	 * 
	 * return build(0, inorder length minus one, postorder, 0, postorder length minus one, memo)
	 * */
	public Lcp_106_TreeNode buildTree_2(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
		
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();												// S : O(n)
		for (int i = 0; i < inorder.length; ++i) { memo.put(inorder[i], i); }
		
		return build_2(0, inorder.length - 1, postorder, 0, postorder.length - 1, memo);
	}
	
	/**
	 * if isStart is greater than inEnd || postStart is greater than postEnd
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(postorder[postEnd])
	 * int rootIndex <- memo get(current val)
	 * int leftNodeNum <- rootIndex minus inStart
	 * 
	 * current left <- build(inStart, rootIndex minus one, postorder, postStart, postStart plus leftNodeNum minus one, memo)
	 * current right <- build(rootIndex plus one, inEnd, postorder, postStart plus leftNodeNum, postEnd minus one, memo)
	 * 
	 * return current
	 * */
	public Lcp_106_TreeNode build_2(int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> memo) {
		if (inStart > inEnd || postStart > postEnd) { return null; }
		
		Lcp_106_TreeNode current = new Lcp_106_TreeNode(postorder[postEnd]);
		int rootIndex = memo.get(current.val);
		int leftNodeNum = rootIndex - inStart;
		
		current.left = build_2(inStart, rootIndex - 1, postorder, postStart, postStart + leftNodeNum - 1, memo);
		current.right = build_2(rootIndex + 1, inEnd, postorder, postStart + leftNodeNum, postEnd - 1, memo);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * inIndex <- inorder length minus one
	 * postIndex <- postorder length minus one
	 * 
	 * return build(inorder, postorder, -3001)
	 * */
	int inIndex;
	int postIndex;
	public Lcp_106_TreeNode buildTree(int[] inorder, int[] postorder) {
		inIndex = inorder.length - 1;
		postIndex = postorder.length - 1;
		return build(inorder, postorder, -3001);
	}
	
	/**
	 * if postIndex is lower than zero
	 * 		return null
	 * end if
	 * 
	 * if inorder[inIndex] is equal to rootValue
	 * 		inIndex--
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(postorder[postIndex])
	 * postIndex--
	 * 
	 * current right <- build(inorder, postorder, current val)
	 * current left <- build(inorder, postorder, rootValue)
	 * 
	 * return current
	 * */
	public Lcp_106_TreeNode build(int[] inorder, int[] postorder, int rootValue) {
		if (postIndex < 0) { return null; }
		
		if (inorder[inIndex] == rootValue) {
			inIndex--;
			return null;
		}
		
		Lcp_106_TreeNode current = new Lcp_106_TreeNode(postorder[postIndex]);
		postIndex--;
		
		current.right = build(inorder, postorder, current.val);
		current.left = build(inorder, postorder, rootValue);
		
		return current;
	}
	
}
