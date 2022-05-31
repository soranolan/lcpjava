package com.example.lcpjava.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Lcp_1562_Find_Latest_Group_of_Size_M {
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806942/JAVA-Using-Tree-Set
	 * */
	public int findLatestStep_1(int[] arr, int m) {
		int length = arr.length;																					// n
		if (length == m) { return length; }
		
		TreeSet<Integer> set = new TreeSet<>();																		// S : O(n)
		set.add(0);
		set.add(length + 1);
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int mid = arr[i];
			int left = set.floor(mid);																				// T : O(log n)
			int right = set.ceiling(mid);																			// T : O(log n)
			
			if (mid - left - 1 == m || right - mid - 1 == m) { return i; }
			
			set.add(mid);																							// T : O(log n)
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806914/Java-Think-in-a-different-direction%3A-Set-bit-to-0
	 * */
	public int findLatestStep_2(int[] arr, int m) {
		int length = arr.length;																					// n
		if (length == m) { return length; }
		
		TreeSet<int[]> minTree = new TreeSet<>((offer, previous) -> offer[0] - previous[0]);						// S : O(n * 2)
		minTree.add(new int[] { 1, length });
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int mid = arr[i];
			int[] floor = minTree.floor(new int[] { mid });															// T : O(log n)
			
			if (floor == null || mid > floor[1]) { continue; }
			
			minTree.remove(floor);
			
			int left = floor[0];
			int right = floor[1];
			
			if (mid - left == m || right - mid == m) { return i; }
			if (mid - left > m) { minTree.add(new int[] { left, mid - 1 }); }
			if (right - mid > m) { minTree.add(new int[] { mid + 1, right }); }
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * similar to hint
	 * 
	 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806871/C%2B%2B-No-other-algorithm-We-just-iterativly-do-it-from-back-to-front-Very-intuitive-and-clean-!!
	 * */
	public int findLatestStep_3(int[] arr, int m) {
		int length = arr.length;																					// n
		int step = 0;
		Queue<int[]> queue = new LinkedList<>();																	// S : O(n * 2)
		queue.offer(new int[] { 1, length });
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int size = queue.size();
			
			for (int j = 0; j < size; j++) {
				int[] pair = queue.poll();
				int left = pair[0];
				int right = pair[1];
				int interval = right - left + 1;
				
				if (interval == m) { return length - step; }
				if (interval < m) { continue; }
				
				int mid = arr[i];
				if (left <= mid && mid <= right) {
					if (mid - left >= m) { queue.offer(new int[] { left, mid - 1 }); }
					if (right - mid >= m) { queue.offer(new int[] { mid + 1, right }); }
				} else {
					queue.offer(pair);
				}
			}
			
			step++;
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/find-latest-group-of-size-m/discuss/806786/JavaC%2B%2BPython-Count-the-Length-of-Groups-O(N)
	 * */
	public int findLatestStep_4(int[] arr, int m) {
		int result = -1;
		int length = arr.length;																					// n
		
		// view it as bit
		// index : bit position
		// value : contiguous cumulative count
		// 0101010 -> [ 0 1 0 1 0 1 0 ]
		// 0111010 -> [ 0 3 3 3 0 1 0 ]
		int[] bitLength = new int[length + 2];																		// S : O(n + 2)
		
		// index : length
		// value : count
		// 0101010 -> [ 0 3 0 0 0 0 0 ]
		// 0111010 -> [ 0 1 0 1 0 0 0 ]
		int[] groupCount = new int[length + 1];																		// S : O(n + 1)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			int mid = arr[i];
			int left = bitLength[mid - 1];
			int right = bitLength[mid + 1];
			
			// contiguous part, update mid, left, right to same bit length
			bitLength[mid] = left + right + 1;
			bitLength[mid - left] = left + right + 1;
			bitLength[mid + right] = left + right + 1;
			
			// due to contiguous, left side count and right side count need to minus one
			groupCount[left]--;
			groupCount[right]--;
			groupCount[bitLength[mid]]++;
			
			// if m length count is exist, then update step result
			if (groupCount[m] > 0) { result = i + 1; }
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int findLatestStep(int[] arr, int m) {
		int result = -1;
		int length = arr.length;																					// n
		if (length == m) { return length; }
		
		int[] bitLength = new int[length + 2];																		// S : O(n + 2)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			int mid = arr[i];
			int left = bitLength[mid - 1];
			int right = bitLength[mid + 1];
			
			bitLength[mid] = left + right + 1;
			bitLength[mid - left] = left + right + 1;
			bitLength[mid + right] = left + right + 1;
			
			if (left == m || right == m) { result = i; }
		}
		
		return result;
	}
	
}
