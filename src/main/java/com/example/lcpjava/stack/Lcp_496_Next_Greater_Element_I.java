package com.example.lcpjava.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lcp_496_Next_Greater_Element_I {
	
	/**
	 * time  : O(m + n)
	 * space : O(m)
	 * 
	 * Monotonic Stack
	 * 
	 * 
	 * Stack<Integer> stack <- new Stack
	 * Map<Integer, Integer> memo <- new HashMap
	 * 
	 * for int number in nums2
	 * 		while stack is not empty && number is greater than stack peek
	 * 			memo put(stack pop, number)
	 * 		end while
	 * 		
	 * 		stack push(number)
	 * end for
	 * 
	 * for int i <- 0; if i is lower than nums1 length; i++
	 * 		nums1[i] <- memo getOrDefault(nums1[i], minus one)
	 * end for
	 * 
	 * return nums1
	 * */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();																		// S : O(m - 1)
		Map<Integer, Integer> memo = new HashMap<>();																// S : O(m - 1)
		
		for (int num : nums2) {																						// T : O(m)
			while (!stack.isEmpty() && num > stack.peek()) {														// T : O(m - 1)
				memo.put(stack.pop(), num);																			// T : O(1)
			}
			
			stack.push(num);																						// T : O(1)
		}
		
		for (int i = 0; i < nums1.length; i++) { nums1[i] = memo.getOrDefault(nums1[i], -1); }						// T : O(n)
		
		return nums1;
	}
	
}
