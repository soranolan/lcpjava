package com.example.lcpjava.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LockingTree_2 {
	
	private int[] parent;
	
	private int[] status;																							// S : O(n)
	
	private Queue<Integer> locked;																					// S : O(m)
	
	/**
	 * time  : O(1)
	 * space : O(n)
	 * */
	public LockingTree_2(int[] parent) {
		this.parent = parent;
		status = new int[parent.length];
		locked = new LinkedList<>();
	}
	
	/**
	 * time  : O(1)
	 * space : O(1)
	 * */
	public boolean lock(int num, int user) {
		if (status[num] != 0) { return false; }
		
		status[num] = user;
		locked.offer(num);																							// T : O(1)
		return true;
	}
	
	/**
	 * time  : O(m)
	 * space : O(1)
	 * */
	public boolean unlock(int num, int user) {
		if (status[num] != user) { return false; }
		
		status[num] = 0;
		while (locked.peek() != num) { locked.offer(locked.poll()); }												// T : O(m)
		locked.poll();																								// T : O(1)
		return true;
	}
	
	/**
	 * time  : O(m * height + height)
	 * space : O(1)
	 * */
	public boolean upgrade(int num, int user) {
		// The node is unlocked
		if (status[num] != 0) { return false; }
		
		// It does not have any locked ancestors
		int ancestor = num;
		while (ancestor != -1) {																					// T : O(height)
			if (status[ancestor] != 0) { return false; }
			ancestor = parent[ancestor];
		}
		
		// It has at least one locked descendant (by any user)
		int before = locked.size();																					// T : O(1)
		traverseLocked(num);																						// T : O(m * height)
		int after = locked.size();																					// T : O(1)
		if (before == after) { return false; }
		
		// Locks the given node for the given user
		status[num] = user;
		locked.offer(num);																							// T : O(1)
		
		return true;
	}
	
	/**
	 * time  : O(m * height)
	 * space : O(1)
	 * */
	private void traverseLocked(int num) {
		int size = locked.size();																					// T : O(1)
		
		for (int i = size - 1; i >= 0; i--) {																		// T : O(m)
			int lockedNode = locked.poll();																			// T : O(1)
			
			if (isAncestor(num, lockedNode)) {																		// T : O(height)
				// unlocks all of its descendants regardless of who locked it
				status[lockedNode] = 0;
			} else {
				locked.offer(lockedNode);																			// T : O(1)
			}
		}
	}
	
	/**
	 * time  : O(height)
	 * space : O(1)
	 * */
	private boolean isAncestor(int num, int lockedNode) {
		int ancestor = lockedNode;
		
		while (ancestor != -1) {																					// T : O(height)
			if (ancestor == num) { return true; }
			ancestor = parent[ancestor];
		}
		
		return false;
	}
	
}
