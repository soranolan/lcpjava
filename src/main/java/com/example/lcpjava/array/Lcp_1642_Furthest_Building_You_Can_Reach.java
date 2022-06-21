package com.example.lcpjava.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1642_Furthest_Building_You_Can_Reach {
	
	/**
	 * time  : O(n log k)
	 * space : O(k)
	 * 
	 * https://leetcode.com/problems/furthest-building-you-can-reach/discuss/918515/JavaC%2B%2BPython-Priority-Queue
	 * */
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		Queue<Integer> minHeap = new PriorityQueue<>();																// S : O(k)
		
		for (int i = 0; i < heights.length - 1; i++) {																// T : O(n - 1)
			int jumps = heights[i + 1] - heights[i];
			
			// Use PriorityQueue to maintain an active set of height-difference we've seen so far. 
			// Because in the end, anyhow, we need to use both ladders and bricks.
			if (jumps > 0) { minHeap.offer(jumps); }																// T : O(log k)
			
			// We can use bricks when we run out of ladders by using the sorting functionality provided by PriorityQueue.
			if (minHeap.size() > ladders) { bricks -= minHeap.poll(); }												// T : O(log k)
			
			if (bricks < 0) { return i; }
		}
		
		return heights.length - 1;
	}
	
}
