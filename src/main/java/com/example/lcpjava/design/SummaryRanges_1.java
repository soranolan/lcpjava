package com.example.lcpjava.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/solutions/2866931/data-stream-as-disjoint-intervals/
 * */
public class SummaryRanges_1 {
	
	private Set<Integer> treeSet;																					// S : O(n)
	
	public SummaryRanges_1() {
		treeSet = new TreeSet<>();
	}
	
	/**
	 * time  : O(log n)
	 * space : O(1)
	 * */
	public void addNum(int value) {
		treeSet.add(value);																							// T : O(log n)
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * */
	public int[][] getIntervals() {
		if (treeSet.isEmpty()) { return new int[0][2]; }
		
		int start = -1;
		int end = -1;
		List<int[]> intervals = new ArrayList<>();
		
		for (Integer value : treeSet) {																				// T : O(n)
			if (start < 0) {
				start = value;
				end = value;
			} else if (end + 1 == value) {
				end = value;
			} else {
				intervals.add(new int[] { start, end });
				start = value;
				end = value;
			}
		}
		
		intervals.add(new int[] { start, end });
		
		return intervals.toArray(new int[0][]);
	}
	
}
