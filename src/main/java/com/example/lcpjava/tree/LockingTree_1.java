package com.example.lcpjava.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/operations-on-tree/discuss/1444087/Just-do-what-question-ask-for-Java-Accepted-Easy-Implementation
 * */
public class LockingTree_1 {
	
	private int[] parent;
	
	private List<List<Integer>> descendants;																		// S : O(n)
	
	private Map<Integer, Integer> locked;																			// S : O(m)
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public LockingTree_1(int[] parent) {
		this.parent = parent;
		descendants = new ArrayList<List<Integer>>(parent.length);
		locked = new HashMap<>();
		
		for (int i = 0; i < parent.length; i++) { descendants.add(new ArrayList<>()); }								// T : O(n)
		for (int i = 1; i < parent.length; i++) { descendants.get(parent[i]).add(i); }								// T : O(n)
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public boolean lock(int num, int user) {
		if (locked.containsKey(num)) { return false; }																// T : O(1)
		locked.put(num, user);																						// T : O(1)
		return true;
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public boolean unlock(int num, int user) {
		if (locked.getOrDefault(num, 0) != user) { return false; }													// T : O(1)
		locked.remove(num);																							// T : O(1)
		return true;
	}
	
	/**
	 * time  : O(child node + height)
	 * space : O(1)
	 * */
	public boolean upgrade(int num, int user) {
		// The node is unlocked
		if (locked.containsKey(num)) { return false; }																// T : O(1)
		
		// It does not have any locked ancestors
		int ancestor = num;
		while (ancestor != -1) {																					// T : O(height)
			ancestor = parent[ancestor];
			if (locked.containsKey(ancestor)) { return false; }														// T : O(1)
		}
		
		// It has at least one locked descendant (by any user)
		int before = locked.size();																					// T : O(1)
		traverseDescendant(num);																					// T : O(child node)
		int after = locked.size();																					// T : O(1)
		if (before == after) { return false; }
		
		// Locks the given node for the given user
		locked.put(num, user);																						// T : O(1)
		
		return true;
	}
	
	/**
	 * time  : O(child node)
	 * space : O(child node)
	 * */
	private void traverseDescendant(int num) {
		Stack<Integer> stack = new Stack<>();																		// S : O(child node)
		stack.push(num);
		
		while (!stack.isEmpty()) {																					// T : O(child node)
			int node = stack.pop();																					// T : O(1)
			
			// unlocks all of its descendants regardless of who locked it
			if (locked.containsKey(node)) { locked.remove(node); }													// T : O(1)
			
			for (int descendant : descendants.get(node)) { stack.push(descendant); }								// T : O(descendant)
		}
	}
	
}
