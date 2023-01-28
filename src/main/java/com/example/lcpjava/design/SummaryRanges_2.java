package com.example.lcpjava.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/solutions/2866931/data-stream-as-disjoint-intervals/
 * */
public class SummaryRanges_2 {
	
	private TreeMap<Integer, Integer> treeMap;																		// S : O(n)
	
	public SummaryRanges_2() {
		treeMap = new TreeMap<>();
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public void addNum(int value) {
		int start = value;
		int end = value;
		
		Integer rightStart = treeMap.floorKey(value);																// T : O(log n)
		if (rightStart != null) {
			int rightEnd = treeMap.get(rightStart);
			
			// { 1 : 3 } { 5 : 7 } add value = 6 ; rightStart = 5
			if (value <= rightEnd) { return; }
			
			// { 1 : 3 } { 5 : 6 } add value = 7 ; rightStart = 5
			if (rightEnd == value - 1) { start = rightStart; }
		}
		
		// { 2 : 3 } { 5 : 6 } add value = 1 ; leftStart = 2
		Integer leftStart = treeMap.higherKey(value);																// T : O(log n)
		if (leftStart != null && value + 1 == leftStart) {
			int leftEnd = treeMap.get(leftStart);
			end = leftEnd;
			treeMap.remove(leftStart);																				// T : O(log n)
		}
		
		treeMap.put(start, end);																					// T : O(log n)
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int[][] getIntervals() {
		List<int[]> intervals = new ArrayList<>();
		for (Integer start : treeMap.keySet()) {																	// T : O(n)
			intervals.add(new int[] { start, treeMap.get(start) });
		}
		return intervals.toArray(new int[0][]);
	}
	
}
