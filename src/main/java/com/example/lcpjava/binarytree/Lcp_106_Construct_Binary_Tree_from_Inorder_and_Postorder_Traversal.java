package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.example.lcpjava.common.TreeNode;

public class Lcp_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation
	 * 
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
	public TreeNode buildTree_1(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
		
		int inIdx = inorder.length - 1;
		int postIdx = postorder.length - 1;
		
		TreeNode root = new TreeNode(postorder[postIdx]);
		postIdx--;
		
		Stack<TreeNode> stack = new Stack<>();																		// S : O(n)
		stack.push(root);
		
		while (postIdx >= 0) {																						// T : O(n)
			TreeNode current = stack.peek();
			if (current.val != inorder[inIdx]) {
				TreeNode right = new TreeNode(postorder[postIdx]);
				current.right = right;
				stack.push(right);
				postIdx--;
			} else {
				while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]) {
					current = stack.pop();
					inIdx--;
				}
				
				TreeNode left = new TreeNode(postorder[postIdx]);
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
	 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space
	 * 
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
	public TreeNode buildTree_2(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
		
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();												// S : O(n)
		for (int i = 0; i < inorder.length; i++) { memo.put(inorder[i], i); }										// T : O(n)
		
		return build_2(0, inorder.length - 1, postorder, 0, postorder.length - 1, memo);
	}
	
	/**
	 * if inStart is greater than inEnd || postStart is greater than postEnd
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
	private TreeNode build_2(int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> memo) {
		if (inStart > inEnd || postStart > postEnd) { return null; }
		
		TreeNode current = new TreeNode(postorder[postEnd]);
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
	 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space
	 * 
	 * 
	 * if inorder is equal to null || postorder is equal to null || inorder length is not equal to postorder length
	 * 		return null
	 * end if
	 * 
	 * int length <- postorder length
	 * postIndex <- length minus one
	 * 
	 * Map<Integer, Integer> memo <- new HashMap
	 * for int i <- 0; if i is lower than inorder length; i++
	 * 		memo put(inorder[i], i)
	 * end for
	 * 
	 * return build(postorder, zero, length minus one, memo)
	 * */
	public TreeNode buildTree_3(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
		
		int length = postorder.length;
		postIndex = length - 1;
		
		Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) { memo.put(inorder[i], i); }
		
		return build_3(postorder, 0, length - 1, memo);
	}
	
	/**
	 * if inStart is greater than inEnd
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(postorder[postIndex])
	 * 
	 * postIndex--
	 * 
	 * int rootIndex <- memo get(current val)
	 * 
	 * current left <- build(postorder, rootIndex plus one, inEnd, memo)
	 * current right <- build(postorder, inStart, rootIndex minus one, memo)
	 * 
	 * return current
	 * */
	private TreeNode build_3(int[] postorder, int inStart, int inEnd, Map<Integer, Integer> memo) {
		if (inStart > inEnd) { return null; }
		
		TreeNode current = new TreeNode(postorder[postIndex--]);
		
		int rootIndex = memo.get(current.val);
		
		current.right = build_3(postorder, rootIndex + 1, inEnd, memo);
		current.left = build_3(postorder, inStart, rootIndex - 1, memo);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution ?
	 * 
	 * 
	 * inIndex <- inorder length minus one
	 * postIndex <- postorder length minus one
	 * 
	 * return build(inorder, postorder, -3001)
	 * */
	private int inIndex;
	private int postIndex;
	public TreeNode buildTree_4(int[] inorder, int[] postorder) {
		inIndex = inorder.length - 1;
		postIndex = postorder.length - 1;
		return build_4(inorder, postorder, -3001);
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
	private TreeNode build_4(int[] inorder, int[] postorder, int rootValue) {
		if (postIndex < 0) { return null; }
		
		if (inorder[inIndex] == rootValue) {
			inIndex--;
			return null;
		}
		
		TreeNode current = new TreeNode(postorder[postIndex]);
		postIndex--;
		
		current.right = build_4(inorder, postorder, current.val);
		current.left = build_4(inorder, postorder, rootValue);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/1589310/C%2B%2BPython-2-Simple-Solutions-w-Images-and-Detailed-Explanation-or-Recursion-%2B-Hashmap
	 * 
	 * if inorder is equal to null || postorder is equal to null || inorder length is not equal to postorder length
	 * 		return null
	 * end if
	 * 
	 * postIndex <- postorder length minus one
	 * 
	 * return build(inorder, postorder, zero, postIndex)
	 * */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) { return null; }
		
		postIndex = postorder.length - 1;
		
		return build(inorder, postorder, 0, postIndex);
	}
	
	/**
	 * if inStart is greater than inEnd
	 * 		return null
	 * end if
	 * 
	 * TreeNode current <- new TreeNode(postorder[postIndex])
	 * 
	 * postIndex--
	 * 
	 * if inStart is equal to inEnd
	 * 		return current
	 * end if
	 * 
	 * int rootIndex <- find(inEnd, current val, inorder)
	 * 
	 * current right <- build(inorder, postorder, rootIndex plus one, inEnd)
	 * current left <- build(inorder, postorder, inStart, rootIndex minus one)
	 * 
	 * return current
	 * */
	private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd) {
		if (inStart > inEnd) { return null; }
		
		TreeNode current = new TreeNode(postorder[postIndex--]);
		
		if (inStart == inEnd) { return current; }
		
		int rootIndex = find(inEnd, current.val, inorder);
		
		current.right = build(inorder, postorder, rootIndex + 1, inEnd);											// why ? postorder : left -> right -> root, and we traverse from end to start : root -> right -> left
		current.left = build(inorder, postorder, inStart, rootIndex - 1);
		
		return current;
	}
	
	/**
	 * for int i <- inEnd; if i is greater than or equal to zero; i--
	 * 		if inorder[i] is equal to target
	 * 			return i
	 * 		end if
	 * end for
	 * 
	 * return zero
	 * */
	private int find(int inEnd, int target, int[] inorder) {
		for (int i = inEnd; i >= 0; i--) {
			if (inorder[i] == target) { return i; }
		}
		return 0;
	}
	
}
