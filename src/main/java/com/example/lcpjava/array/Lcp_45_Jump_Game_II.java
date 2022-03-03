package com.example.lcpjava.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lcp_45_Jump_Game_II {
	
	/**
	 * time  : O(n!)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/jump-game-ii/discuss/1192401/Easy-Solutions-w-Explanation-or-Optimizations-from-Brute-Force-to-DP-to-Greedy-BFS
	 * Brute Force
	 * 
	 * return recursion(zero, array)
	 * */
	public int jump_1(int[] nums) {
		return recursion_1(0, nums);
	}
	
	/**
	 * if index is greater than or equal to array length minus one
	 * 		return zero
	 * end if
	 * 
	 * int min <- 10000 plus one
	 * 
	 * for int jump <- 1; if jump is lower than or equal to array[index]; jump++
	 * 		min <- Math min(min, one plus recursion(index plus jump, array))
	 * end for
	 * 
	 * return min
	 * */
	public int recursion_1(int index, int[] nums) {
		if (index >= nums.length - 1) { return 0; }
		int min = 10000 + 1;																						// constraints
		for (int jump = 1; jump <= nums[index]; jump++) {
			min = Math.min(min, 1 + recursion_1(index + jump, nums));
		}
		return min;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * Memoization
	 * 
	 * 
	 * int[] dp <- new int[10000 plus one]
	 * 
	 * Arrays fill(dp, 10001)
	 * 
	 * return recursion(zero, array, dp)
	 * */
	public int jump_2(int[] nums) {
		int[] dp = new int[nums.length];																			// S : O(n)
		Arrays.fill(dp, 10000 + 1);																					// constraints
		return recursion(0, nums, dp);
	}
	
	/**
	 * if index is greater than or equal to array length minus one
	 * 		return zero
	 * end if
	 * 
	 * if dp[index] is not equal to 10001
	 * 		return dp[index]
	 * end if
	 * 
	 * for int jump <- 1; if jump is lower than or equal to array[index]; jump++
	 * 		dp[index] <- Math min(dp[index], one plus recursion(index plus jump, array, dp))
	 * end for
	 * 
	 * return dp[index]
	 * */
	public int recursion(int index, int[] nums, int[] dp) {
		if (index >= nums.length - 1) { return 0; }
		if (dp[index] != 10001) { return dp[index]; }
		for (int jump = 1; jump <= nums[index]; jump++) {
			dp[index] = Math.min(dp[index], 1 + recursion(index + jump, nums, dp));
		}
		return dp[index];
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * Tabulation
	 * 
	 * 
	 * int length <- array length
	 * 
	 * int[] dp <- new int[length]
	 * Arrays fill(dp, 10000 plus one)
	 * 
	 * dp[length minus one] <- zero
	 * 
	 * for int index <- length minus two; if index is greater than or equal to zero; index--
	 * 		for int jump <- 1; if jump is lower than or equal to array[index]; jump++
	 * 			dp[index] <- Math min(dp[index], one plus dp[Math min(length minus one, index plus jump)]
	 * 		end for
	 * end for
	 * 
	 * return dp[0]
	 * */
	public int jump_3(int[] nums) {
		int length = nums.length;
		
		int[] dp = new int[length];
		Arrays.fill(dp, 10000 + 1);
		
		dp[length - 1] = 0;
		
		for (int index = length - 2; index >= 0; index--) {
			for (int jump = 1; jump <= nums[index]; jump++) {
				dp[index] = Math.min(dp[index], 1 + dp[Math.min(length - 1, index + jump)]);
			}
		}
		
		return dp[0];
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * int jump <- 0
	 * int length <- array length
	 * int lastIndex <- length minus one
	 * boolean[] visited <- new boolean[length]
	 * Queue<Integer> queue <- new LinkedList
	 * 
	 * queue offer(0)
	 * visited[0] <- true
	 * 
	 * while queue is not empty
	 * 		int size <- queue size
	 * 		
	 * 		for int i <- 0; if i is lower than size; i++
	 * 			int currentIndex <- queue poll
	 * 			
	 * 			if currentIndex is equal to lastIndex
	 * 				return jump
	 * 			end if
	 * 			
	 * 			for int j <- 1; if j is lower than or equal to array[currentIndex]; j++
	 * 				int nextIndex <- currentIndex plus j
	 * 				
	 * 				if nextIndex is greater than lastIndex
	 * 					break
	 * 				end if
	 * 				
	 * 				if visited[nextIndex] is true
	 * 					continue
	 * 				end if
	 * 				
	 * 				queue offer(nextIndex)
	 * 				visited[nextIndex] <- true
	 * 			end for
	 * 		end for
	 * 		
	 * 		jump++
	 * end while
	 * 
	 * return minus one
	 * */
	public int jump_4(int[] nums) {
		int jump = 0;
		int length = nums.length;
		int lastIndex = length - 1;
		boolean[] visited = new boolean[length];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(0);
		visited[0] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				int currentIndex = queue.poll();
				if (currentIndex == lastIndex) { return jump; }
				
				for (int j = 1; j <= nums[currentIndex]; j++) {
					int nextIndex = currentIndex + j;
					if (nextIndex > lastIndex) { break; }
					if (visited[nextIndex]) { continue; }
					
					queue.offer(nextIndex);
					visited[nextIndex] = true;
				}
			}
			
			jump++;
		}
		
		return -1;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Greedy BFS
	 * 
	 * 
	 * int length <- array length
	 * int currentIndex <- 0
	 * int lastIndex <- 0
	 * int maxIndex <- 0
	 * int jump <- 0
	 * 
	 * while lastIndex is lower than length minus one
	 * 		maxIndex <- Math max(maxIndex, currentIndex plus array[currentIndex])
	 * 		
	 * 		if currentIndex is equal to lastIndex
	 * 			lastIndex <- maxIndex
	 * 			jump++
	 * 		end if
	 * 		
	 * 		currentIndex++
	 * end while
	 * 
	 * return jump
	 * */
	public int jump(int[] nums) {
		int length = nums.length;
		int currentIndex = 0;
		int lastIndex = 0;
		int maxIndex = 0;
		int jump = 0;
		
		while (lastIndex < length - 1) {
			maxIndex = Math.max(maxIndex, currentIndex + nums[currentIndex]);
			if (currentIndex == lastIndex) {
				lastIndex = maxIndex;
				jump++;
			}
			currentIndex++;
		}
		
		return jump;
	}
	
}
