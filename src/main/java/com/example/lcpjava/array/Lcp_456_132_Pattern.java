package com.example.lcpjava.array;

import java.util.Stack;

public class Lcp_456_132_Pattern {
	
	/**
	 * Time Limit Exceeded
	 * 
	 * time  : O(n ^ 3)
	 * space : O(1)
	 * 
	 * https://leetcode.com/problems/132-pattern/discuss/94089/Java-solutions-from-O(n3)-to-O(n)-for-%22132%22-pattern-(updated-with-one-pass-slution)
	 * 
	 * int length <- nums length
	 * 
	 * if length is lower than three
	 * 		return false
	 * end if
	 * 
	 * for int i <- 0; if i is lower than length minus two; i++
	 * 		for int j <- i plus one; if j is lower than length minus one; j++
	 * 			for int k <- j plus one; if k is lower than length; k++
	 * 				if nums[i] is lower than nums[k] && nums[k] is lower than nums[j]
	 * 					return true
	 * 				end if
	 * 			end for
	 * 		end for
	 * end for
	 * 
	 * return false
	 * */
	public boolean find132pattern_1(int[] nums) {
		int length = nums.length;																					// n
		if (length < 3) { return false; }
		
		for (int i = 0; i < length - 2; i++) {																		// T : O(n - 2)
			for (int j = i + 1; j < length - 1; j++) {																// T : O(n - 2)
				for (int k = j + 1; k < length; k++) {																// T : O(n - 2)
					if (nums[i] < nums[k] && nums[k] < nums[j]) { return true; }
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Time Limit Exceeded
	 * 
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * int length <- nums length
	 * 
	 * if length is lower than three
	 * 		return false
	 * end if
	 * 
	 * int minI <- nums[0]
	 * 
	 * for int j <- 1; if j is lower than length minus one; j++
	 * 		if minI is equal to nums[j]
	 * 			continue
	 * 		end if
	 * 		
	 * 		minI <- Math min(minI, nums[j minus one])
	 * 		
	 * 		for int k <- j plus one; if k is lower than length; k++
	 * 			if minI is lower than nums[k] && nums[k] is lower than nums[j]
	 * 				return true
	 * 			end if
	 * 		end for
	 * end for
	 * 
	 * return false
	 * */
	public boolean find132pattern_2(int[] nums) {
		int length = nums.length;																					// n
		if (length < 3) { return false; }
		
		int minI = nums[0];
		
		for (int j = 1; j < length - 1; j++) {																		// T : O(n - 2)
			if (minI == nums[j]) { continue; }
			
			minI = Math.min(minI, nums[j - 1]);
			
			for (int k = j + 1; k < length; k++) {																	// T : O(n - 2)
				if (minI < nums[k] && nums[k] < nums[j]) { return true; }
			}
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/132-pattern/discuss/94071/Single-pass-C%2B%2B-O(n)-space-and-time-solution-(8-lines)-with-detailed-explanation.
	 * 
	 * int length <- nums length
	 * 
	 * if length is lower than three
	 * 		return false
	 * end if
	 * 
	 * Stack<Integer> stack <- new Stack
	 * int numK <- Integer minimum value
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		int numI <- nums[i]
	 * 		
	 * 		if numI is lower than numK
	 * 			return true
	 * 		end if
	 * 		
	 * 		int numJ <- nums[i]
	 * 		
	 * 		while stack is not empty && numJ is greater than stack peek
	 * 			numK <- stack pop
	 * 		end while
	 * 		
	 * 		stack push(numJ)
	 * end for
	 * 
	 * return false
	 * */
	public boolean find132pattern_3(int[] nums) {
		int length = nums.length;																					// n
		if (length < 3) { return false; }
		
		// bottom - j - k - top
		Stack<Integer> stack = new Stack<>();																		// S : O(n)
		int numK = Integer.MIN_VALUE;
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int numI = nums[i];
			if (numI < numK) { return true; }
			
			int numJ = nums[i];
			while (!stack.isEmpty() && numJ > stack.peek()) { numK = stack.pop(); }
			
			stack.push(numJ);
		}
		
		return false;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * it will change input
	 * 
	 * 
	 * int length <- nums length
	 * 
	 * if length is lower than three
	 * 		return false
	 * end if
	 * 
	 * int top <- length
	 * int numK <- Integer minimum value
	 * 
	 * for int i <- length minus one; if i is greater than or equal to zero; i--
	 * 		int numI <- nums[i]
	 * 		
	 * 		if numI is lower than numK
	 * 			return true
	 * 		end if
	 * 		
	 * 		int numJ <- nums[i]
	 * 		
	 * 		while top is lower than length && numJ is greater than nums[top]
	 * 			numK <- nums[top]
	 * 			top++
	 * 		end while
	 * 		
	 * 		top--
	 * 		nums[top] <- numJ
	 * end for
	 * 
	 * return false
	 * */
	public boolean find132pattern(int[] nums) {
		int length = nums.length;																					// n
		if (length < 3) { return false; }
		
		int top = length;
		int numK = Integer.MIN_VALUE;
		
		for (int i = length - 1; i >= 0; i--) {																		// T : O(n)
			int numI = nums[i];
			if (numI < numK) { return true; }
			
			// view as stack, array[top] < array[top + 1] < array[top + 2]
			int numJ = nums[i];
			while (top < length && numJ > nums[top]) { numK = nums[top++]; }
			
			// push to stack
			nums[--top] = numJ;
		}
		
		return false;
	}
	
}
