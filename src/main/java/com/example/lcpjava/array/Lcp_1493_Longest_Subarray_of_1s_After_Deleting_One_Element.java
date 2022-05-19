package com.example.lcpjava.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lcp_1493_Longest_Subarray_of_1s_After_Deleting_One_Element {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Sliding Window
	 * 
	 * set to check if zero exist
	 * 
	 * queue to maintain the order of numbers
	 * 
	 * after each number, use queue size to determine the longest sub array
	 * */
	public int longestSubarray_1(int[] nums) {
		Set<Integer> set = new HashSet<>();																			// S : O(zero)
		Queue<Integer> queue = new LinkedList<>();																	// S : O(n)
		
		int max = 0;
		
		for (int num : nums) {																						// T : O(n)
			while (num == 0 && !queue.isEmpty() && set.contains(num)) {
				int zero = queue.poll();																			// T : O(1)
				set.remove(zero);																					// T : O(1)
			}
			
			queue.offer(num);																						// T : O(1)
			set.add(num);																							// T : O(1)
			max = Math.max(max, queue.size() - 1);
		}
		
		return max;
	}
	
	/**
	 * D store count without zero
	 * P store count with zero
	 * 
	 * when P encounter zero, will use D previous accumulate one's count
	 * 
	 *  [ 0, 1, 1, 1, 0, 1, 1, 0, 1 ]
	 *  D 0  1  2  3  0  1  2  0  1
	 *  P 0  1  2  3  3  4  5  2  3
	 *  
	 *   1, 1, 0, 1
	 * D 1  2  0  1
	 * P 0  1  2  3
	 * */
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Dynamic Programming
	 * 
	 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/discuss/708109/Python-O(n)-dynamic-programming-detailed-explanation
	 * */
	public int longestSubarray_2(int[] nums) {
		int result = 0;
		int length = nums.length;																					// n
		
		int[] D = new int[length];																					// S : O(n)
		D[0] = (nums[0] == 1) ? 1 : 0;
		int[] P = new int[length];																					// S : O(n)
		
		for (int i = 1; i < length; i++) {																			// T : O(n)
			if (nums[i] == 1) {
				D[i] += D[i - 1] + 1;
				P[i] = Math.max(P[i - 1] + 1, D[i - 1]);
			} else {
				P[i] = D[i - 1];
			}
			result = Math.max(result, P[i]);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Sliding Window
	 * 
	 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/discuss/708112/JavaC%2B%2BPython-Sliding-Window-at-most-one-0
	 * 
	 * zeros = 0
	 *     r
	 * [ 0,1,1,1,0,1,1,0,1 ]
	 *   l
	 * */
	public int longestSubarray_3(int[] nums) {
		int result = 0;
		int left = 0;
		int zeros = nums[left] == 0 ? 1 : 0;
		
		for (int right = 1; right < nums.length; right++) {
			if (nums[right] == 0) { zeros++; }
			
			while (zeros > 1) {
				if (nums[left] == 0) { zeros--; }
				left++;
			}
			
			result = Math.max(result, right - left);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Sliding Window
	 * */
	public int longestSubarray_4(int[] nums) {
		int left = 0;
		int right = 1;
		int zeros = (nums[left] == 0) ? 1 : 0;
		
		for (; right < nums.length; right++) {
			if (nums[right] == 0) { zeros++; }
			
			if (zeros > 1) {
				if (nums[left] == 0) { zeros--; }
				left++;
			}
		}
		
		return right - left - 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * without Sliding Window
	 * 
	 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/discuss/708531/Java-O(n)-time-O(1)-space-no-sliding-window
	 * 
	 *     p p p   c c
	 * [ 0,1,1,1,0,1,1,0,1 ]
	 *             p p   c
	 * */
	public int longestSubarray(int[] nums) {
		int result = 0;
		int previous = 0;
		int current = 0;
		
		for (int num : nums) {
			current++;
			
			if (num == 0) {
				previous = current;
				current = 0;
			}
			
			result = Math.max(result, previous + current - 1);
		}
		
		return result;
	}
	
}
