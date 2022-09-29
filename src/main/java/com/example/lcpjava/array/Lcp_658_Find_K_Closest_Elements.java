package com.example.lcpjava.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_658_Find_K_Closest_Elements {
	
	/**
	 * time  : O(n log k + k log k)
	 * space : O(k)
	 * */
	public List<Integer> findClosestElements_1(int[] arr, int k, int x) {
		// S : O(k)
		Queue<int[]> maxHeap = new PriorityQueue<>( (offer, previous) -> offer[1] == previous[1] ? previous[0] - offer[0] : previous[1] - offer[1]);
		
		for (int num : arr) {																						// T : O(n)
			maxHeap.offer(new int[] { num, Math.abs(x - num) });													// T : O(log k)
			if (maxHeap.size() > k) { maxHeap.poll(); }
		}
		
		List<Integer> result = new ArrayList<>();																	// S : O(k)
		
		while (!maxHeap.isEmpty()) {																				// T : O(k)
			result.add(maxHeap.poll()[0]);																			// T : O(log k)
		}
		
		Collections.sort(result);																					// T : O(k log k)
		
		return result;
	}
	
	/**
	 * time  : O(n - k)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/find-k-closest-elements/discuss/1310981/Simple-Solutions-w-Explanation-or-All-Possible-Approaches-Explained!
	 * */
	public List<Integer> findClosestElements_2(int[] arr, int k, int x) {
		int left = 0;
		int right = arr.length - 1;
		
		while (right - left >= k) {																					// T : O(n - k)
			if (x - arr[left] <= arr[right] - x) {
				right--;
			} else {
				left++;
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = left; i <= right; i++) {																		// T : O(k)
			result.add(arr[i]);
		}
		
		return result;
	}
	
	/**
	 * time  : O(log n + k)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/find-k-closest-elements/discuss/1310981/Simple-Solutions-w-Explanation-or-All-Possible-Approaches-Explained!
	 * */
	public List<Integer> findClosestElements_3(int[] arr, int k, int x) {
		int n = arr.length;
		int right = lowerBound(0, n - 1, x, arr);																	// T : O(log n)
		int left = right - 1;
		
		while (k > 0) {																								// T : O(k)
			if (right >= n || left >= 0 && (x - arr[left] <= arr[right] - x)) {
				left--;
			} else {
				right++;
			}
			k--;
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = left + 1; i < right; i++) {																	// T : O(k)
			result.add(arr[i]);
		}
		
		return result;
	}
	
	/**
	 * https://medium.com/@ssrivastava990/alternative-implementation-of-lower-bound-in-java-23ec40a825ec
	 * */
	private int lowerBound(int start, int end, int target, int[] arr) {
		while (start < end) {
			int mid = start + (end - start) / 2;
			int pivot = arr[mid];
			
			if (pivot < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return start;
	}
	
	/**
	 * time  : O(log (n - k) + k)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/find-k-closest-elements/discuss/1310981/Simple-Solutions-w-Explanation-or-All-Possible-Approaches-Explained!
	 * */
	public List<Integer> findClosestElements_4(int[] arr, int k, int x) {
		int n = arr.length;
		int right = lowerBound(0, n - k, x, arr);																	// T : O(log (n - k))
		int left = right - 1;
		
		while (k > 0) {																								// T : O(k)
			if (right >= n || left >= 0 && (x - arr[left] <= arr[right] - x)) {
				left--;
			} else {
				right++;
			}
			k--;
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = left + 1; i < right; i++) {																	// T : O(k)
			result.add(arr[i]);
		}
		
		return result;
	}
	
	/**
	 * time  : O(log (n - k))
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/find-k-closest-elements/discuss/1310981/Simple-Solutions-w-Explanation-or-All-Possible-Approaches-Explained!
	 * https://leetcode.com/problems/find-k-closest-elements/discuss/106426/JavaC%2B%2BPython-Binary-Search-O(log(N-K)-%2B-K)
	 * */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int n = arr.length;
		int left = 0;
		int right = n - k;
		
		while (left < right) {																						// T : O(log (n - k))
			int mid = left + (right - left) / 2;
			
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = left; i < left + k; i++) {																		// T : O(k)
			result.add(arr[i]);
		}
		
		return result;
	}
	
}
