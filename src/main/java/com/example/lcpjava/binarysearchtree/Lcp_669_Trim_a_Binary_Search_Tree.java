package com.example.lcpjava.binarysearchtree;

public class Lcp_669_Trim_a_Binary_Search_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * return trim(root, low, high)
	 * */
	public TreeNode trimBST_1(TreeNode root, int low, int high) {
		return trim(root, low, high);
	}
	
	/**
	 * if current is equal to null
	 * 		return current
	 * end if
	 * 
	 * if current val is greater than high
	 * 		return trim(current left, low, high)
	 * end if
	 * 
	 * if current val is lower than low
	 * 		return trim(current right, low, high)
	 * end if
	 * 
	 * current left <- trim(current left, low, high)
	 * current right <- trim(current right, low, high)
	 * 
	 * return current
	 * */
	public TreeNode trim(TreeNode current, int low, int high) {
		if (current == null) { return current; }
		
		if (current.val > high) { return trim(current.left, low, high); }
		if (current.val < low) { return trim(current.right, low, high); }
		
		current.left = trim(current.left, low, high);
		current.right = trim(current.right, low, high);
		
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * while root is not equal to null && (root val is greater than high || root val is lower than low)
	 * 		if root val is greater than high
	 * 			root <- root left
	 * 		else if root val is lower than low
	 * 			root <- root right
	 * 		end if
	 * end while
	 * 
	 * TreeNode current <- root
	 * while current is not equal to null
	 * 		while current left is not equal to null && current left val is lower than low
	 * 			current left <- current left right
	 * 		end while
	 * 		
	 * 		current <- current left
	 * end while
	 * 
	 * current <- root
	 * while current is not equal to null
	 * 		while current right is not equal to null && current right val is greater than high
	 * 			current right <- current right left
	 * 		end while
	 * 		
	 * 		current <- current right
	 * end while
	 * 
	 * return root
	 * */
	public TreeNode trimBST(TreeNode root, int low, int high) {
		while (root != null && (root.val > high || root.val < low)) {
			if (root.val > high) {
				root = root.left;
			} else if (root.val < low) {
				root = root.right;
			}
		}
		
		TreeNode current = root;
		while (current != null) {
			while (current.left != null && current.left.val < low) {
				current.left = current.left.right;
			}
			current = current.left;
		}
		
		current = root;
		while (current != null) {
			while (current.right != null && current.right.val > high) {
				current.right = current.right.left;
			}
			current = current.right;
		}
		
		return root;
	}
	
}
