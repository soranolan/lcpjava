package com.example.lcpjava.binarytree;

import com.example.lcpjava.common.TreeNode;

public class Lcp_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * result <- null
	 * 
	 * traverse(cloned, target)
	 * 
	 * return result
	 * */
	private TreeNode result;
	public final TreeNode getTargetCopy_1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		result = null;
		
		traverse_1(cloned, target);
		
		return result;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * if result is not equal to null
	 * 		return
	 * end if
	 * 
	 * if current val is equal to target val
	 * 		result <- current
	 * 		return
	 * end if
	 * 
	 * traverse(current left, target)
	 * 
	 * traverse(current right, target)
	 * */
	private void traverse_1(TreeNode current, final TreeNode target) {
		if (current == null) { return; }
		
		if (result != null) { return; }
		
		if (current.val == target.val) {
			result = current;
			return;
		}
		
		traverse_1(current.left, target);
		traverse_1(current.right, target);
	}
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * Follow Up
	 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/discuss/539557/Easy-JAVA-Solution-with-explanation.-Beats-100-!!-O(n)-time
	 * 
	 * 
	 * return traverse(original, cloned, target)
	 * */
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		return traverse(original, cloned, target);
	}
	
	/**
	 * if original is equal to target || original is equal to null
	 * 		return cloned
	 * end if
	 * 
	 * TreeNode result <- null
	 * 
	 * result <- traverse(original left, cloned left, target)
	 * 
	 * if result is not equal to null
	 * 		return result
	 * end if
	 * 
	 * result <- traverse(original right, cloned right, target)
	 * 
	 * return result
	 * */
	private TreeNode traverse(TreeNode original, TreeNode cloned, final TreeNode target) {
		if (original == target || original == null) { return cloned; }
		
		TreeNode result = null;
		
		result = traverse(original.left, cloned.left, target);
		if (result != null) { return result; }
		
		result = traverse(original.right, cloned.right, target);
		return result;
	}
	
}
