package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lcp_1696_Jump_Game_VI {
	
	/**
	 * time  : O(n * k)
	 * space : O(n)
	 * 
	 * Time Limit Exceeded
	 * 
	 * Tabulation Bottom-Up
	 * 
	 * https://leetcode.com/problems/jump-game-vi/discuss/1260737/Optimizations-from-Brute-Force-to-Dynamic-Programming-w-Explanation
	 * */
	public int maxResult_1(int[] nums, int k) {
		int length = nums.length;																					// n
		int[] dp = new int[length];																					// S : O(n)
		Arrays.fill(dp, Integer.MIN_VALUE);																			// T : O(n)
		dp[0] = nums[0];
		
		for (int i = 1; i < length; i++) {																			// T : O(n - 1)
			
			// check previous k number, not next k number
			for (int j = 1; j <= k && i - j >= 0; j++) {															// T : O(k)
				dp[i] = Math.max(dp[i], nums[i] + dp[i - j]);
			}
		}
		
		return dp[length - 1];
	}
	
	/**
	 * time  : O(n log k)
	 * space : O(k)
	 * 
	 * Max Heap Sliding Window
	 * 
	 * https://leetcode.com/problems/jump-game-vi/discuss/1261213/JAVA-Journey-from-Brute-Force-to-Most-Optimized-DP-%2B-Sliding-Window-Algorithm-()
	 * */
	public int maxResult_2(int[] nums, int k) {
		Queue<int[]> maxHeap = new PriorityQueue<>((offer, previous) -> previous[1] - offer[1]);					// S : O(k * 2)
		maxHeap.offer(new int[] { 0, nums[0] });																	// T : O(log k)
		
		int max = nums[0];
		
		for (int i = 1; i < nums.length; i++) {																		// T : O(n - 1)
			while (maxHeap.peek()[0] < i - k) {
				maxHeap.poll();																						// T : O(log k)
			}
			
			max = nums[i] + maxHeap.peek()[1];
			maxHeap.offer(new int[] { i, max });																	// T : O(log k)
		}
		
		return max;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * */
	public int maxResult_3(int[] nums, int k) {
		int length = nums.length;																					// n
		int[] dp = new int[length];																					// S : O(n)
		dp[0] = nums[0];
		
		// head - max - min - tail
		Deque<Integer> deque = new LinkedList<>();																	// S : O(k)
		deque.offer(0);																								// T : O(1)
		
		for (int i = 1; i < length; i++) {																			// T : O(n - 1)
			if (deque.peekFirst() < i - k) { deque.pollFirst(); }													// T : O(1)
			
			dp[i] = nums[i] + dp[deque.peekFirst()];																// T : O(1)
			
			while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {												// T : O(k)
				deque.pollLast();																					// T : O(1)
			}
			
			deque.offerLast(i);																						// T : O(1)
		}
		
		return dp[length - 1];
	}
	
	/**
	 * time  : O(n * k)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int maxResult(int[] nums, int k) {
		int length = nums.length;
		if (length == 1) { return nums[0]; }
		
		int[] dp = new int[length];																					// S : O(n)
		Arrays.fill(dp, Integer.MIN_VALUE);																			// T : O(n)
		dp[0] = nums[0];
		
		for (int i = 0; i < length; i++) {																			// T : O(n)
			for (int j = i + 1; j < length && j <= i + k; j++) {													// T : O(k)
				int max = dp[i] + nums[j];
				
				if (max > dp[j]) { dp[j] = max; }
				
				// branch and cut
				if (dp[j] >= dp[i]) { break; }
			}
		}
		
		return dp[length - 1];
	}
	
}
