package com.example.lcpjava.array;

import java.util.Map;
import java.util.Map.Entry;

import com.example.lcpjava.common.RangeFreqQueryNode;

/**
 * another solution
 * 
 * https://leetcode.com/problems/range-frequency-queries/discuss/1589039/Merge-Sort-Tree-Segment-Tree
 * https://leetcode.com/problems/range-frequency-queries/discuss/1592697/Java-or-Binary-Indexed-Tree-or-Segment-Tree-or-O(nlogn)-or-Detailed-explanation
 * https://leetcode.com/problems/range-frequency-queries/discuss/1589942/Java-Segment-Tree-Based-Solution
 * */
public class RangeFreqQuery_4 {
	
	public RangeFreqQueryNode root;
	
	public RangeFreqQuery_4(int[] arr) {
		root = buildSegmentTree(0, arr.length - 1, arr);
	}
	
	public int query(int left, int right, int value) {
		return querySegmentTree(left, right, value, root);
	}
	
	public RangeFreqQueryNode buildSegmentTree(int start, int end, int[] arr) {
		RangeFreqQueryNode newNode = new RangeFreqQueryNode(start, end);
		if (start == end) {
			newNode.segment.put(arr[start], 1);
			return newNode;
		}
		
		int mid = start + (end - start) / 2;
		RangeFreqQueryNode left = buildSegmentTree(start, mid, arr);
		RangeFreqQueryNode right = buildSegmentTree(mid + 1, end, arr);
		
		for (Entry<Integer, Integer> entry : left.segment.entrySet()) { newNode.segment.put(entry.getKey(), entry.getValue()); }
		
		for (Entry<Integer, Integer> entry : right.segment.entrySet()) {
			Integer number = entry.getKey();
			Integer frequency = entry.getValue();
			Map<Integer, Integer> segment = newNode.segment;
			
			if (segment.containsKey(number)) {
				segment.put(number, segment.get(number) + frequency);
			} else {
				segment.put(number, frequency);
			}
		}
		
		newNode.left = left;
		newNode.right = right;
		
		return newNode;
	}
	
	public int querySegmentTree(int start, int end, int target, RangeFreqQueryNode current) {
		if (!current.segment.containsKey(target) || start > current.end || end < current.start) { return 0; }
		
		if (start <= current.start && end >= current.end) { return current.segment.get(target); }
		
		return querySegmentTree(start, end, target, current.left) + querySegmentTree(start, end, target, current.right);
	}
	
}
