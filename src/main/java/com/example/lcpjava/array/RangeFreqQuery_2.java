package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/range-frequency-queries/discuss/1589019/Java-or-Binary-Search-or-Log(n)-for-every-query
 * */
public class RangeFreqQuery_2 {
	
	public Map<Integer, List<Integer>> memo;																		// S : O(n)
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public RangeFreqQuery_2(int[] arr) {
		memo = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {																		// T : O(n)
			if (!memo.containsKey(arr[i])) { memo.put(arr[i], new ArrayList<>()); }									// T : O(1)
			memo.get(arr[i]).add(i);																				// T : O(1)
		}
	}
	
	/**
	 * time  : O(log m)
	 * space : O(1)
	 * */
	public int query(int left, int right, int value) {
		List<Integer> indices = memo.get(value);																	// T : O(1)
		if (indices == null || left > indices.get(indices.size() - 1) || right < indices.get(0)) { return 0; }
		
		int lowerIndex = lowerBoundBinarySearch(indices, left);														// T : O(log m)
		int upperIndex = upperBoundBinarySearch(indices, right);													// T : O(log m)
		
		return upperIndex - lowerIndex + 1;
	}
	
	public int lowerBoundBinarySearch(List<Integer> indices, int left) {
		int start = 0;
		int end = indices.size() - 1;
		
		if (left < indices.get(start)) { return 0; }
		
		while (start < end) {
			int mid = start + (end - start) / 2;
			int pivot = indices.get(mid);
			
			if (left > pivot) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return start;
	}
	
	public int upperBoundBinarySearch(List<Integer> indices, int right) {
		int start = 0;
		int end = indices.size() - 1;
		
		if (right > indices.get(end)) { return end; }
		
		while (start < end) {
			int mid = start + (end - start) / 2 + 1;
			int pivot = indices.get(mid);
			
			if (right < pivot) {
				end = mid - 1;
			} else {
				start = mid;
			}
		}
		
		return start;
	}
	
}
