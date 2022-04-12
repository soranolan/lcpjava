package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.example.lcpjava.common.Lcp_236_TreeNode;
import com.example.lcpjava.common.Pair;

public class Lcp_236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * Stack<TreeNode> stack <- new Stack
	 * Map<TreeNode, TreeNode> parent <- new HashMap
	 * Set<TreeNode> ancestor <- new HashSet
	 * 
	 * stack push(root)
	 * parent put(root, null)
	 * 
	 * while parent does not contain key p || parent does not contain key q
	 * 		TreeNode current <- stack pop
	 * 		if current left is not equal to null
	 * 			stack push(current left)
	 * 			parent put(current left, current)
	 * 		end if
	 * 		
	 * 		if current right is not equal to null
	 * 			stack push(current right)
	 * 			parent put(current right, current)
	 * 		end if
	 * end while
	 * 
	 * while p is not equal to null
	 * 		ancestor add(p)
	 * 		p <- parent get(p)
	 * end while
	 * 
	 * while ancestor does not contain q
	 * 		q <- parent get(q)
	 * end while
	 * 
	 * return q
	 * */
	public Lcp_236_TreeNode lowestCommonAncestor_1(Lcp_236_TreeNode root, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		if (root == null) { return null; }
		
		Stack<Lcp_236_TreeNode> stack = new Stack<>();																// S : O(n)
		Map<Lcp_236_TreeNode, Lcp_236_TreeNode> parent = new HashMap<>();											// S : O(n)
		Set<Lcp_236_TreeNode> ancestor = new HashSet<>();															// S : O(n)
		
		stack.push(root);																							// T : O(1)
		parent.put(root, null);																						// T : O(1)
		
		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			Lcp_236_TreeNode current = stack.pop();																	// T : O(1)
			if (current.left != null) {
				stack.push(current.left);																			// T : O(1)
				parent.put(current.left, current);																	// T : O(1)
			}
			if (current.right != null) {
				stack.push(current.right);																			// T : O(1)
				parent.put(current.right, current);																	// T : O(1)
			}
		}
		
		while (p != null) {																							// T : O(n)
			ancestor.add(p);																						// T : O(1)
			p = parent.get(p);																						// T : O(1)
		}
		
		while (!ancestor.contains(q)) {																				// T : O(1)
			q = parent.get(q);																						// T : O(1)
		}
		
		return q;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * if root is equal to null
	 * 		return null
	 * end if
	 * 
	 * Stack<Pair> stack <- new Stack
	 * stack push(new Pair(root, BOTH_PENDING))
	 * 
	 * boolean foundOne <- false
	 * TreeNode lca <- null
	 * TreeNode child <- null
	 * 
	 * while stack is not empty
	 * 		Pair top <- stack pop
	 * 		TreeNode current <- top getNode
	 * 		int state <- top getState
	 * 		
	 * 		if state is equal to BOTH_PENDING && (current is equal to p || current is equal to q)
	 * 			if foundOne is true
	 * 				return lca
	 * 			end if
	 * 			foundOne <- true
	 * 			lca <- current
	 * 		end if
	 * 		
	 * 		if state is equal to BOTH_PENDING
	 * 			child <- current left
	 * 		end if
	 * 		
	 * 		if state is equal to LEFT_DONE
	 * 			child <- current right
	 * 		end if
	 * 		
	 * 		if state is equal to BOTH_PENDING || state is equal to LEFT_DONE
	 * 			stack push(new Pair(current, state minus one))
	 * 			if child is not equal to null
	 * 				stack push(new Pair(child, BOTH_PENDING))
	 * 			end if
	 * 		end if
	 * 		
	 * 		if state is equal to BOTH_DONE && current is equal to lca && foundOne is true
	 * 			lca <- stack peek getNode
	 * 		end if
	 * end while
	 * 
	 * return null
	 * */
	private static int BOTH_PENDING = 2;
	private static int LEFT_DONE = 1;
	private static int BOTH_DONE = 0;
	public Lcp_236_TreeNode lowestCommonAncestor_2(Lcp_236_TreeNode root, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		if (root == null) { return null; }
		
		Stack<Pair> stack = new Stack<Pair>();																		// S : O(n)
		stack.push(new Pair(root, BOTH_PENDING));																	// T : O(1)
		
		boolean foundOne = false;
		Lcp_236_TreeNode lca = null;
		Lcp_236_TreeNode child = null;
		
		while (!stack.isEmpty()) {
			Pair top = stack.pop();																					// T : O(1)
			Lcp_236_TreeNode current = top.getNode();
			int state = top.getState();
			
			if (state == BOTH_PENDING && (current == p || current == q)) {
				if (foundOne) { return lca; }
				foundOne = true;
				lca = current;
			}
			
			if (state == BOTH_PENDING) { child = current.left; }
			if (state == LEFT_DONE) { child = current.right; }
			
			if (state == BOTH_PENDING || state == LEFT_DONE) {
				stack.push(new Pair(current, state - 1));															// T : O(1)
				if (child != null) { stack.push(new Pair(child, BOTH_PENDING)); }									// T : O(1)
				continue;
			}
			
			if (state == BOTH_DONE && lca == current && foundOne) { lca = stack.peek().getNode(); }					// T : O(1)
		}
		
		return null;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * DFS(root, p, q)
	 * */
	public Lcp_236_TreeNode lowestCommonAncestor_3(Lcp_236_TreeNode root, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		return DFS_1(root, p, q);
	}
	
	/**
	 * if current is equal to null || current is equal to p || current is equal to q
	 * 		return current
	 * end if
	 * 
	 * TreeNode left <- DFS(current left, p, q)
	 * 
	 * TreeNode right <- DFS(current right, p, q)
	 * 
	 * if left is equal to null
	 * 		return right
	 * end if
	 * 
	 * if right is equal to null
	 * 		return left
	 * end if
	 * 
	 * return current
	 * */
	public Lcp_236_TreeNode DFS_1(Lcp_236_TreeNode current, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		if (current == null || current == p || current == q) { return current; }
		Lcp_236_TreeNode left = DFS_1(current.left, p, q);
		Lcp_236_TreeNode right = DFS_1(current.right, p, q);
		if (left == null) { return right; }
		if (right == null) { return left; }
		return current;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Prefer this one
	 * 
	 * lca <- null
	 * DFS(root, p, q)
	 * return lca
	 * */
	Lcp_236_TreeNode lca_1;
	public Lcp_236_TreeNode lowestCommonAncestor_4(Lcp_236_TreeNode root, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		lca_1 = null;
		DFS_1(root, p, q);
		return lca_1;
	}
	
	/**
	 * if current is equal to null || lca is not equal to null
	 * 		return false
	 * end if
	 * 
	 * int left <- if DFS(current left, p, q) is true then one else zero
	 * int right <- if DFS(current right, p, q) is true then one else zero
	 * int mid <- if (current is equal to p || current is equal to q) then one else zero
	 * int sum <- left plus right plus mid
	 * 
	 * if sum is equal to two && lca is equal to null
	 * 		lca <- current
	 * end if
	 * 
	 * return if sum is greater than zero
	 * */
	public boolean DFS_2(Lcp_236_TreeNode current, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		if (current == null || lca_1 != null) { return false; }
		int left = DFS_2(current.left, p, q) ? 1 : 0;
		int right = DFS_2(current.right, p, q) ? 1 : 0;
		int mid = (current == p || current == q) ? 1 : 0;
		int sum = left + right + mid;
		if (sum == 2 && lca_1 == null) { lca_1 = current; }
		return sum > 0;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * DFS(root, p, q)
	 * */
	Lcp_236_TreeNode lca = null;
	public Lcp_236_TreeNode lowestCommonAncestor(Lcp_236_TreeNode root, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		DFS(root, p, q);
		return lca;
	}
	
	/**
	 * if current is equal to null
	 * 		return false
	 * end if
	 * 
	 * boolean mid <- (if current is equal to p || if current is equal to q)
	 * 
	 * boolean left <- DFS(current left, p, q)
	 * 
	 * boolean right <- DFS(current right, p, q)
	 * 
	 * if (left && right) || (mid && left) || (mid && right)
	 * 		lca <- current
	 * end if
	 * 
	 * return mid || left || right
	 * */
	public boolean DFS(Lcp_236_TreeNode current, Lcp_236_TreeNode p, Lcp_236_TreeNode q) {
		if (current == null) { return false; }
		boolean mid = (current == p || current == q);
		boolean left = DFS(current.left, p, q);
		boolean right = DFS(current.right, p, q);
		if ((left && right) || (mid && left) || (mid && right)) { lca = current; }
		return mid || left || right;
	}
	
}
