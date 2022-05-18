package com.example.lcpjava.array;

import java.util.Stack;

public class Lcp_42_Trapping_Rain_Water {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(1)
	 * 
	 * Brute Force
	 * 
	 * for each point,
	 * we can check left side highest mountain and right side highest mountain,
	 * and determine which one is lower,
	 * then we can know the trapped water by the lower one mountain minus current altitude
	 * 
	 * 
	 * int length <- height length
	 * 
	 * if length is lower than three
	 * 		return zero
	 * end if
	 * 
	 * int waters <- zero
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		int leftMax <- 0
	 * 		
	 * 		for int left <- 0; if left is lower than i; left++
	 * 			leftMax <- Math max(leftMax, height[left])
	 * 		end for
	 * 		
	 * 		int rightMax <- 0
	 * 		
	 * 		for int right <- i + 1; if right is lower than length; right++
	 * 			rightMax <- Math max(rightMax, height[right])
	 * 		end for
	 * 		
	 * 		int trapped <- Math min(leftMax, rightMax) minus height[i]
	 * 		waters <- waters plus (if trapped is greater than zero then trapped else zero)
	 * end for
	 * 
	 * return waters
	 * */
	public int trap_1(int[] height) {
		int length = height.length;																					// n
		if (length < 3) { return 0; }
		
		int waters = 0;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			int leftMax = 0;
			for (int left = 0; left < i; left++) { leftMax = Math.max(leftMax, height[left]); }						// T : O(i)
			
			int rightMax = 0;
			for (int right = i + 1; right < length; right++) { rightMax = Math.max(rightMax, height[right]); }		// T : O(n - i)
			
			int trapped = Math.min(leftMax, rightMax) - height[i];
			waters += (trapped > 0) ? trapped : 0;
		}
		
		return waters;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/trapping-rain-water/discuss/178028/Stack-with-Explanation-(Java-Python-Scala)
	 * 
	 * store index in stack, view it as left side and bottom,
	 * while current running right side is greater than stack top (previous),
	 * then calculate trapped water
	 * 
	 * 
	 * int length <- height length
	 * 
	 * if length is lower than three
	 * 		return zero
	 * end if
	 * 
	 * int waters <- 0
	 * Stack<Integer> stack <- new Stack
	 * 
	 * for int right <- 0; if right is lower than length; right++
	 * 		while stack is not empty && height[right] is greater than height[stack peek]
	 * 			int bottom <- stack pop
	 * 			
	 * 			if stack is empty
	 * 				break
	 * 			end if
	 * 			
	 * 			int left <- stack peek
	 * 			int wid <- right minus left minus one
	 * 			int hei <- Math min(height[left], height[right]) minus height[bottom]
	 * 			int trapped <- wid times hei
	 * 			
	 * 			waters <- waters plus (if trapped is greater than zero then trapped else zero) 
	 * 		end while
	 * 		
	 * 		stack push(right)
	 * end for
	 * 
	 * return waters
	 * */
	public int trap_2(int[] height) {
		int length = height.length;																					// n
		if (length < 3) { return 0; }
		
		int waters = 0;
		Stack<Integer> stack = new Stack<>();																		// S : O(n)
		
		for (int right = 0; right < length; right++) {																// T : O(n)
			while (!stack.isEmpty() && height[right] > height[stack.peek()]) {
				int bottom = stack.pop();
				if (stack.isEmpty()) { break; }
				
				int left = stack.peek();
				int wid = right - left - 1;
				int hei = Math.min(height[left], height[right]) - height[bottom];
				int trapped = wid * hei;
				
				waters += (trapped > 0) ? trapped : 0;
			}
			
			stack.push(right);
		}
		
		return waters;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Dynamic Programming
	 * 
	 * store left max and right max in array
	 * 
	 * 
	 * int length <- height length
	 * 
	 * if length is lower than three
	 * 		return zero
	 * end if
	 * 
	 * int[] leftMax <- new int[length]
	 * int[] rightMax <- new int[length]
	 * 
	 * for int i <- 1; if i is lower than length; i++
	 * 		leftMax[i] <- Math max(leftMax[i minus one], height[i minus one])
	 * end for
	 * 
	 * for int i <- length minus two; if i is greater than or equal to zero; i--
	 * 		rightMax[i] <- Math max(rightMax[i plus one], height[i plus one])
	 * end for
	 * 
	 * int waters <- 0
	 * 
	 * for int i <- 0; if i is lower than length; i++
	 * 		int trapped <- Math min(leftMax[i], rightMax[i]) minus height[i]
	 * 		waters <- waters plus (if trapped is greater than zero then trapped else zero)
	 * end for
	 * 
	 * return waters
	 * */
	public int trap_3(int[] height) {
		int length = height.length;																					// n
		if (length < 3) { return 0; }
		
		int[] leftMax = new int[length];																			// S : O(n)
		int[] rightMax = new int[length];																			// S : O(n)
		
		for (int i = 1; i < length; i++) { leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]); }					// T : O(n - 1)
		for (int i = length - 2; i >= 0; i--) { rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]); }			// T : O(n - 1)
		
		int waters = 0;
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			int trapped = Math.min(leftMax[i], rightMax[i]) - height[i];
			waters += (trapped > 0) ? trapped : 0;
		}
		
		return waters;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Two Pointers
	 * 
	 * 
	 * int length <- height length
	 * 
	 * if length is lower than three
	 * 		return zero
	 * end if
	 * 
	 * int waters <- 0
	 * int left <- 0
	 * int right <- length minus one
	 * int leftMax <- 0
	 * int rightMax <- 0
	 * 
	 * while left is lower than right
	 * 		if height[left] is lower than height[right]
	 * 			leftMax <- Math max(leftMax, height[left])
	 * 			waters <- waters plus leftMax minus height[left]
	 * 			left++
	 * 		else
	 * 			rightMax <- Math max(rightMax, height[right])
	 * 			waters <- waters plus rightMax minus height[right]
	 * 			right--
	 * 		end if
	 * end while
	 * 
	 * return waters
	 * */
	public int trap(int[] height) {
		int length = height.length;																					// n
		if (length < 3) { return 0; }
		
		int waters = 0;
		int left = 0;
		int right = length - 1;
		int leftMax = 0;
		int rightMax = 0;
		
		while (left < right) {																						// T : O(n)
			if (height[left] < height[right]) {
				leftMax = Math.max(leftMax, height[left]);
				waters += leftMax - height[left];
				left++;
			} else {
				rightMax = Math.max(rightMax, height[right]);
				waters += rightMax - height[right];
				right--;
			}
		}
		
		return waters;
	}
	
}
