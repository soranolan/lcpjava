package com.example.lcpjava.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.lcpjava.common.TreeNode;

public class Lcp_897_Increasing_Order_Search_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * in-order
	 * https://leetcode.com/problems/increasing-order-search-tree/discuss/200938/c%2B%2B-recursive-and-iterative
	 * 
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * 
	 * TreeNode head <- null
	 * TreeNode tail <- null
	 * TreeNode current <- root
	 * 
	 * while stack is not empty or current is not equal to null
	 * 		while current is not equal to null
	 * 			stack push(current)
	 * 			current <- current left
	 * 		end while
	 * 		
	 * 		current <- stack pop
	 * 		
	 * 		if head is equal to null
	 * 			head <- new TreeNode(current val)
	 * 			tail <- head
	 * 		else
	 * 			tail right <- new TreeNode(current val)
	 * 			tail <- tail right
	 * 		end if
	 * 		
	 * 		current <- current right
	 * end while
	 * 
	 * return head
	 * */
	public TreeNode increasingBST_1(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();																		// S : O(height)
		
		TreeNode head = null;
		TreeNode tail = null;
		TreeNode current = root;
		
		while (!stack.isEmpty() || current != null) {																// T : O(n)
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			
			if (head == null) {
				head = new TreeNode(current.val);
				tail = head;
			} else {
				tail.right = new TreeNode(current.val);
				tail = tail.right;
			}
			
			current = current.right;
		}
		
		return head;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * List<Integer> nodes <- new ArrayList
	 * inorder(root, nodes)
	 * 
	 * TreeNode head <- new TreeNode(0)
	 * TreeNode tail <- head
	 * 
	 * for int node in nodes
	 * 		tail right <- new TreeNode(node)
	 * 		tail <- tail right
	 * end for
	 * 
	 * return head right
	 * */
	public TreeNode increasingBST_2(TreeNode root) {
		List<Integer> nodes = new ArrayList<>();																	// S : O(n)
		inorder_1(root, nodes);
		
		TreeNode head = new TreeNode(0);
		TreeNode tail = head;
		
		for (int node : nodes) {																					// T : O(n)
			tail.right = new TreeNode(node);
			tail = tail.right;
		}
		
		return head.right;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * inorder(current left, nodes)
	 * 
	 * nodes add(current val)
	 * 
	 * inorder(current right, nodes)
	 * */
	public void inorder_1(TreeNode current, List<Integer> nodes) {
		if (current == null) { return; }
		
		inorder_1(current.left, nodes);
		nodes.add(current.val);
		inorder_1(current.right, nodes);
	}
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * TreeNode head <- new TreeNode(0)
	 * tail <- head
	 * 
	 * inorder(root)
	 * 
	 * return head right
	 * */
	TreeNode tail;
	public TreeNode increasingBST_3(TreeNode root) {
		TreeNode head = new TreeNode(0);
		tail = head;
		
		inorder_2(root);
		
		return head.right;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * inorder(current left)
	 * 
	 * current left <- null
	 * tail right <- current
	 * tail <- tail right
	 * 
	 * inorder(current right)
	 * */
	public void inorder_2(TreeNode current) {
		if (current == null) { return; }
		
		inorder_2(current.left);
		
		current.left = null;
		tail.right = current;
		tail = tail.right;
		
		inorder_2(current.right);
	}
	
	/**
	 * time  : O(n)
	 * space : O(height)
	 * 
	 * https://leetcode.com/problems/increasing-order-search-tree/discuss/165885/C%2B%2BJavaPython-Self-Explained-5-line-O(N)
	 * 
	 * return inorder(root, null)
	 * */
	public TreeNode increasingBST(TreeNode root) {
		return inorder(root, null);
	}
	
	/**
	 * if current is equal to null
	 * 		return tail
	 * end if
	 * 
	 * TreeNode node <- inorder(current left, current)
	 * current left <- null
	 * current right <- inorder(current right, tail)
	 * 
	 * return node
	 * */
	public TreeNode inorder(TreeNode current, TreeNode tail) {
		if (current == null) { return tail; }
		
		TreeNode node = inorder(current.left, current);
		current.left = null;
		current.right = inorder(current.right, tail);
		
		return node;
	}
	
}
