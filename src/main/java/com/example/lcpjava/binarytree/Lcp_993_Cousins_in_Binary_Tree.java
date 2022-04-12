package com.example.lcpjava.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.example.lcpjava.common.Lcp_993_TreeNode;

public class Lcp_993_Cousins_in_Binary_Tree {
	
	/**
	 * time  : O(n)
	 * space : O(2 ^ depth)
	 * 
	 * Queue<TreeNode> queue <- new LinkedList
	 * queue offer(root)
	 * 
	 * while queue is not empty
	 * 		int size <- queue size
	 * 		boolean isX <- false
	 * 		boolean isY <- false
	 * 		
	 * 		for int i <- 0; if i is lower than size; i++
	 * 			TreeNode current <- queue poll
	 * 			
	 * 			if current val is equal to x
	 * 				isX <- true
	 * 			end if
	 * 			
	 * 			if current val is equal to y
	 * 				isY <- true
	 * 			end if
	 * 			
	 * 			if current left is not equal to null && current right is not equal to null
	 * 				if current left val is equal to x && current right val is equal to y
	 * 					return false
	 * 				end if
	 * 				
	 * 				if current left val is equal to y && current right val is equal to x
	 * 					return false
	 * 				end if
	 * 			end if
	 * 			
	 * 			if current left is not equal to null
	 * 				queue offer(current left)
	 * 			end if
	 * 			
	 * 			if current right is not equal to null
	 * 				queue offer(current right)
	 * 			end if
	 * 		end for
	 * 		
	 * 		if isX && isY
	 * 			return true
	 * 		end if
	 * 		
	 * 		if isX || isY
	 * 			return false
	 * 		end if
	 * 		
	 * end while
	 * 
	 * return false
	 * */
	public boolean isCousins_1(Lcp_993_TreeNode root, int x, int y) {
		Queue<Lcp_993_TreeNode> queue = new LinkedList<>();															// S : O(2 ^ depth)
		queue.offer(root);																							// T : O(1)
		
		while (!queue.isEmpty()) {																					// T : O(n)
			int size = queue.size();																				// T : O(1)
			boolean isX = false;
			boolean isY = false;
			
			for (int i = 0; i < size; i++) {																		// T : O(2 ^ depth)
				Lcp_993_TreeNode current = queue.poll();															// T : O(1)
				
				if (current.val == x) { isX = true; }
				if (current.val == y) { isY = true; }
				
				if (current.left != null && current.right != null) {
					if (current.left.val == x && current.right.val == y) { return false; }
					if (current.left.val == y && current.right.val == x) { return false; }
				}
				
				if (current.left != null) { queue.offer(current.left); }											// T : O(1)
				if (current.right != null) { queue.offer(current.right); }											// T : O(1)
			}
			
			if (isX && isY) { return true; }
			if (isX || isY) { return false; }
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Map<Integer, Integer> parentMap <- new HashMap
	 * Map<Integer, Integer> depthMap <- new HashMap
	 * 
	 * parentMap put(root val, null)
	 * depthMap put(root val, 0)
	 * 
	 * DFS(root left, root, 1, parentMap, depthMap)
	 * DFS(root left, root, 1, parentMap, depthMap)
	 * 
	 * if depthMap get(x) is not equal to depthMap get(y)
	 * 		return false
	 * end if
	 * 
	 * if parentMap get(x) is equal to parentMap get(y)
	 * 		return false
	 * end if
	 * 
	 * return true
	 * */
	public boolean isCousins_2(Lcp_993_TreeNode root, int x, int y) {
		Map<Integer, Integer> parentMap = new HashMap<>();															// S : O(n)
		Map<Integer, Integer> depthMap = new HashMap<>();															// S : O(n)
		
		parentMap.put(root.val, null);																				// T : O(1)
		depthMap.put(root.val, 0);																					// T : O(1)
		
		DFS_1(root.left, root, 1, parentMap, depthMap);
		DFS_1(root.right, root, 1, parentMap, depthMap);
		
		if (depthMap.get(x) != depthMap.get(y)) { return false; }													// T : O(1)
		if (parentMap.get(x) == parentMap.get(y)) { return false; }													// T : O(1)
		
		return true;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * parentMap put(current val, parent val)
	 * depthmap put(current val, depth)
	 * 
	 * DFS(current left, current, depth plus one, parentMap, depthMap)
	 * DFS(current right, current, depth plus one, parentMap, depthMap)
	 * */
	public void DFS_1(Lcp_993_TreeNode current, Lcp_993_TreeNode parent, int depth, Map<Integer, Integer> parentMap, Map<Integer, Integer> depthMap) {
		if (current == null) { return; }
		
		parentMap.put(current.val, parent.val);																		// T : O(1)
		depthMap.put(current.val, depth);																			// T : O(1)
		
		DFS_1(current.left, current, depth + 1, parentMap, depthMap);
		DFS_1(current.right, current, depth + 1, parentMap, depthMap);
	}
	
	/**
	 * time  : O(n)
	 * space : O(202)
	 * 
	 * int[] parents <- new int[101]
	 * int[] depths <- new int[101]
	 * 
	 * parents[root val] <- minus one
	 * depths[root val] <- zero
	 * 
	 * DFS(root left, root, 1, parents, depths)
	 * DFS(root left, root, 1, parents, depths)
	 * 
	 * if depths[x] is not equal to depths[y]
	 * 		return false
	 * end if
	 * 
	 * if parents[x] is equal to parents[y]
	 * 		return false
	 * end if
	 * 
	 * return true
	 * */
	public boolean isCousins(Lcp_993_TreeNode root, int x, int y) {
		int[] parents = new int[100 + 1];																			// S : O(101)
		int[] depths = new int[100 + 1];																			// S : O(101)
		
		parents[root.val] = -1;
		depths[root.val] = 0;
		
		DFS(root.left, root, 1, parents, depths);
		DFS(root.right, root, 1, parents, depths);
		
		if (depths[x] != depths[y]) { return false; }
		if (parents[x] == parents[y]) { return false; }
		
		return true;
	}
	
	/**
	 * if current is equal to null
	 * 		return
	 * end if
	 * 
	 * parents[current val] <- parent val
	 * depths[current val] <- depth
	 * 
	 * DFS(current left, current, depth plus one, parents, depths)
	 * DFS(current right, current, depth plus one, parents, depths)
	 * */
	public void DFS(Lcp_993_TreeNode current, Lcp_993_TreeNode parent, int depth, int[] parents, int[] depths) {
		if (current == null) { return; }
		
		parents[current.val] = parent.val;
		depths[current.val] = depth;
		
		DFS(current.left, current, depth + 1, parents, depths);
		DFS(current.right, current, depth + 1, parents, depths);
	}
	
}
