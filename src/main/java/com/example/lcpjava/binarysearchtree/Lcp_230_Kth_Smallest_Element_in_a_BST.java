package com.example.lcpjava.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_230_TreeNode;

public class Lcp_230_Kth_Smallest_Element_in_a_BST {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * return traversal(root, k)
	 * */
	public int kthSmallest_1(Lcp_230_TreeNode root, int k) {
		return traversal(root, k);
	}
	
	/**
	 * int leftCount <- count(current left)
	 * 
	 * if leftCount is equal to k minus one
	 * 		return current val
	 * end if
	 * 
	 * if leftCount is greater than or equal to k
	 * 		return traversal(current left, k)
	 * end if
	 * 
	 * return traversal(current right, k minus one minus leftCount)
	 * */
	public int traversal(Lcp_230_TreeNode current, int k) {
		int leftCount = count(current.left);
		if (leftCount == k - 1) { return current.val; }																// mid
		if (leftCount >= k) { return traversal(current.left, k); }													// left subtree
		return traversal(current.right, k - 1 - leftCount);															// right subtree
	}
	
	/**
	 * if current is equal to null
	 * 		return zero
	 * end if
	 * 
	 * return one plus count(current left) plus count(current right)
	 * */
	public int count(Lcp_230_TreeNode current) {
		if (current == null) { return 0; }
		return 1 + count(current.left) + count(current.right);
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> bucket <- new ArrayList
	 * 
	 * inorder(root, bucket)
	 * 
	 * return bucket get(k minus one)
	 * */
	public int kthSmallest_2(Lcp_230_TreeNode root, int k) {
		List<Integer> bucket = new ArrayList<>();																	// S : O(n)
		inorder_1(root, bucket);
		return bucket.get(k - 1);																					// T : O(1)
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * inorder(current left, bucket)
	 * 
	 * bucket add(current val)
	 * 
	 * inorder(current right, bucket)
	 * */
	public void inorder_1(Lcp_230_TreeNode current, List<Integer> bucket) {
		if (current == null) { return; }
		inorder_1(current.left, bucket);
		bucket.add(current.val);																					// T : O(1)
		inorder_1(current.right, bucket);
	}
	
	/**
	 * time  : O(height)
	 * space : O(height)
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * TreeNode current <- root
	 * int count <- k
	 * 
	 * while current is not equal to null || stack is not empty
	 * 		while current is not equal to null
	 * 			stack push(current)
	 * 			current <- current left
	 * 		end while
	 * 		
	 * 		current <- stack pop
	 * 		
	 * 		count--
	 * 		if count is equal to zero
	 * 			return current val
	 * 		end if
	 * 		
	 * 		current <- current right
	 * end while
	 * 
	 * return minus one
	 * */
	public int kthSmallest_3(Lcp_230_TreeNode root, int k) {
		Stack<Lcp_230_TreeNode> stack = new Stack<>();
		Lcp_230_TreeNode current = root;
		int count = k;
		
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			
			count--;
			if (count == 0) { return current.val; }
			
			current = current.right;
		}
		
		return -1;
	}
	
	/**
	 * time  : O(height)
	 * space : O(n)
	 * 
	 * follow up, if we add count field
	 * 
	 * 
	 * TreeNode newRoot <- fillCount(root)
	 * 
	 * return find(newRoot, k)
	 * */
	public int kthSmallest(Lcp_230_TreeNode root, int k) {
		Lcp_230_TreeNode newRoot = fillCount(root);
		return find(newRoot, k);
	}
	
	/**
	 * if current is equal to null
	 * 		return null
	 * end if
	 * 
	 * TreeNode newRoot <- new TreeNode(current val)
	 * 
	 * newRoot left <- fillCount(current left)
	 * newRoot right <- fillCount(current right)
	 * 
	 * if newRoot left is not equal to null
	 * 		newRoot count <- newRoot count plus newRoot left count
	 * end if
	 * 
	 * if newRoot right is not equal to null
	 * 		newRoot count <- newRoot count plus newRoot right count
	 * end if
	 * 
	 * return newRoot
	 * */
	public Lcp_230_TreeNode fillCount(Lcp_230_TreeNode current) {
		if (current == null) { return null; }
		
		Lcp_230_TreeNode newRoot = new Lcp_230_TreeNode(current.val);
		
		newRoot.left = fillCount(current.left);
		newRoot.right = fillCount(current.right);
		
		if (newRoot.left != null) { newRoot.count += newRoot.left.count; }
		if (newRoot.right != null) { newRoot.count += newRoot.right.count; }
		
		return newRoot;
	}
	
	/**
	 * if k is lower than or equal to zero || k is greater than current count
	 * 		return minus one
	 * end if
	 * 
	 * if current left is not equal to null
	 * 		int leftCount <- current left count
	 * 		
	 * 		if leftCount is equal to k minus one
	 * 			return current val
	 * 		end if
	 * 		
	 * 		if leftCount is greater than or equal to k
	 * 			return find(current left, k)
	 * 		end if
	 * 		
	 * 		return find(current right, k minus one minus leftCount)
	 * else
	 * 		if k is equal to one
	 * 			return current val
	 * 		end if
	 * 		
	 * 		return find(current right, k minus one)
	 * end if
	 * */
	public int find(Lcp_230_TreeNode current, int k) {
		if (k <= 0 || k > current.count) { return -1; }
		if (current.left != null) {
			int leftCount = current.left.count;
			if (leftCount == k - 1) { return current.val; }
			if (leftCount >= k) { return find(current.left, k); }
			return find(current.right, k - 1 - leftCount);															// k minus mid minus left subtree count = right subtree count
		} else {
			if (k == 1) { return current.val; }
			return find(current.right, k - 1);
		}
	}
	
}
