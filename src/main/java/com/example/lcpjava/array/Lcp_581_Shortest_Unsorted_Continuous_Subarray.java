package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.Stack;

public class Lcp_581_Shortest_Unsorted_Continuous_Subarray {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * int length <- nums length
	 * int start <- length
	 * int end <- 0
	 * 
	 * for int left <- 0; if left is lower than length minus one; left++
	 * 		for int right <- left plus one; if right is lower than length; right++
	 * 			if nums[left] is lower than or equal to nums[right]
	 * 				continue
	 * 			end if
	 * 			
	 * 			start <- Math min(start, left)
	 * 			end <- Math max(end, right)
	 * 		end for
	 * end for
	 * 
	 * return if end minus start is lower than zero then zero else end minus start plus one
	 * */
	public int findUnsortedSubarray_1(int[] nums) {
		int length = nums.length;
		int start = length;
		int end = 0;
		
		for (int left = 0; left < length - 1; left++) {																// T : O(n - 1)
			for (int right = left + 1; right < length; right++) {													// T : O(n - 1)
				if (nums[left] <= nums[right]) { continue; }
				start = Math.min(start, left);
				end = Math.max(end, right);
			}
		}
		
		return end - start < 0 ? 0 : end - start + 1;
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * int length <- nums length
	 * int start <- length
	 * int end <- 0
	 * int[] sorted <- new int[length]
	 * copy original array to sorted
	 * sort sorted
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		if nums[i] is equal to sorted[i]
	 * 			continue
	 * 		end if
	 * 		
	 * 		start <- Math min(start, i)
	 * 		end <- Math max(end, i)
	 * end for
	 * 
	 * return if end minus start is lower than zero then zero else end minus start plus one
	 * */
	public int findUnsortedSubarray_2(int[] nums) {
		int length = nums.length;																					// n
		int start = length;
		int end = 0;
		int[] sorted = new int[length];																				// S : O(n)
		System.arraycopy(nums, 0, sorted, 0, length);
		Arrays.sort(sorted);																						// T : O(n log n)
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			if (nums[i] == sorted[i]) { continue; }
			start = Math.min(start, i);
			end = Math.max(end, i);
		}
		
		return end - start < 0 ? 0 : end - start + 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * int length <- nums length
	 * int start <- length
	 * int end <- 0
	 * Stack<Integer> stack <- new Stack
	 * 
	 * for int right <- 0; if right is lower than length; right++
	 * 		while stack is not empty && nums[stack peek] is greater than nums[right]
	 * 			start <- Math min(start, stack pop)
	 * 		end while
	 * 		
	 * 		stack push(right)
	 * end for
	 * 
	 * clear stack
	 * 
	 * for int left <- length minus one; if left is greater than or equal to zero; left--
	 * 		while stack is not empty && nums[left] is greater than nums[stack peek]
	 * 			end <- Math max(end, stack pop)
	 * 		end while
	 * 		
	 * 		stack push(left)
	 * end for
	 * 
	 * return if end minus start is lower than zero then zero else end minus start plus one
	 * */
	public int findUnsortedSubarray_3(int[] nums) {
		int length = nums.length;
		int start = length;
		int end = 0;
		Stack<Integer> stack = new Stack<>();																		// S : O(n)
		
		for (int right = 0; right < length; right++) {																// T : O(n)
			while (!stack.isEmpty() && nums[stack.peek()] > nums[right]) { start = Math.min(start, stack.pop()); }
			stack.push(right);
		}
		
		stack.clear();																								// T : O(n)
		
		for (int left = length - 1; left >= 0; left--) {															// T : O(n)
			while (!stack.isEmpty() && nums[left] > nums[stack.peek()]) { end = Math.max(end, stack.pop()); }
			stack.push(left);
		}
		
		return end - start < 0 ? 0 : end - start + 1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/Java-O(n)-Time-O(1)-Space
	 * 
	 * int length <- nums length
	 * int start <- minus one
	 * int end <- minus two
	 * int max <- nums[zero]
	 * int min <- nums[length minus one]
	 * 
	 * for int current <- 1; if current is lower than length; current++
	 * 		max <- Math max(max, nums[current])
	 * 		min <- Math min(min, nums[length minus one minus current])
	 * 		
	 * 		if max is greater than nums[current]
	 * 			end <- current
	 * 		end if
	 * 		
	 * 		if nums[length minus one minus current] is greater than min
	 * 			start <- length minus one minus current
	 * 		end if
	 * end for
	 * 
	 * return end minus start plus one
	 * */
	public int findUnsortedSubarray_(int[] nums) {
		int length = nums.length;
		int start = -1;
		int end = -2;
		int max = nums[0];
		int min = nums[length - 1];
		
		for (int current = 1; current < length; current++) {
			max = Math.max(max, nums[current]);
			min = Math.min(min, nums[length - 1 - current]);
			
			if (max > nums[current]) { end = current; }
			if (nums[length - 1 - current] > min) { start = length - 1 - current; }
		}
		
		return end - start + 1;
	}
	
	/**
	 *     s     e
	 * 2 3 5 1 3 4 4 4 4 6 7 8
	 * 
	 * 1.find start point
	 * 2.find end point
	 * 3.find maximum and minimum between start and end
	 * 4.check whether there is a number lower than the minimum before the start point, if so, move the start point to the left by one
	 * 5.check whether there is a number greater than the maximum after the end point, if so, move the end point to the right by one
	 * */
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * int length <- nums length
	 * 
	 * if length is lower than or equal to one
	 * 		return zero
	 * end if
	 * 
	 * int start <- minus one
	 * int end <- 0
	 * int max <- Integer min value
	 * int min <- Integer max value
	 * 
	 * for int i <- 1; if i is lower than length; i++
	 * 		if nums[i minus one] is greater than nums[i]
	 * 			start <- i minus one
	 * 			break
	 * 		end if
	 * end for
	 * 
	 * if start is equal to minus one
	 * 		return zero
	 * end if
	 * 
	 * for int i <- length minus one; if i is greater than zero; i--
	 * 		if nums[i minus one] is greater than nums[i]
	 * 			end <- i
	 * 			break
	 * 		end if
	 * end for
	 * 
	 * for int i <- start; if i is lower than or equal to end; i++
	 * 		max <- Math max(max, nums[i])
	 * 		min <- Math min(min, nums[i])
	 * end for
	 * 
	 * int temp <- start
	 * for int i <- 0; if i is lower than temp; i++
	 * 		if min is lower than nums[i]
	 * 			start--
	 * 		end if
	 * end for
	 * 
	 * temp <- end
	 * for int i <- length minus one; if i is greater than temp; i--
	 * 		if nums[i] is lower than max
	 * 			end++
	 * 		end if
	 * end for
	 * 
	 * return end minus start plus one
	 * */
	public int findUnsortedSubarray(int[] nums) {
		int length = nums.length;
		if (length <= 1) { return 0; }
		
		int start = -1;
		int end = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i < length; i++) {																			// T : O(n)
			if (nums[i - 1] > nums[i]) {
				start = i - 1;
				break;
			}
		}
		
		if (start == -1) { return 0; }																				// if array is already ascending
		
		for (int i = length - 1; i > 0; i--) {																		// T : O(n)
			if (nums[i - 1] > nums[i]) {
				end = i;
				break;
			}
		}
		
		for (int i = start; i <= end; i++) {																		// T : O(end - start)
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		
		int temp = start;
		for (int i = 0; i < temp; i++) {																			// T : O(start)
			if (min < nums[i]) { start--; }
		}
		
		temp = end;
		for (int i = length - 1; i > temp; i--) {																	// T : O(end)
			if (nums[i] < max) { end++; }
		}
		
		return end - start + 1;
	}
	
}
