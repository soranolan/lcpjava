package com.example.lcpjava.array;

public class Lcp_1578_Minimum_Time_to_Make_Rope_Colorful {
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/discuss/2229072/Java-Solution-or-DP-or-Greedy
	 * */
	public int minCost_1(String colors, int[] neededTime) {
		int result = 0;
		int n = colors.length();
		int[] dp = new int[n];																						// S : O(n)
		
		for (int i = 1; i < n; i++) {																				// T : O(n - 1)
			if (colors.charAt(i - 1) == colors.charAt(i)) {
				if (dp[i - 1] == 0) {
					dp[i] = Math.max(neededTime[i - 1], neededTime[i]);
					result += Math.min(neededTime[i - 1], neededTime[i]);
				} else {
					dp[i] = Math.max(dp[i - 1], neededTime[i]);
					result += Math.min(dp[i - 1], neededTime[i]);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Solution Tab & Hint
	 * */
	public int minCost_2(String colors, int[] neededTime) {
		int n = colors.length();
		int result = 0;
		int left = 0;
		int right = 0;
		
		while (right < n) {																							// T : O(n)
			int total = 0;
			int max = 0;
			
			while (right < n && colors.charAt(left) == colors.charAt(right)) {
				total += neededTime[right];
				max = Math.max(max, neededTime[right]);
				right++;
			}
			
			result += (total - max);
			left = right;																							// T : O(n)
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Solution Tab
	 * */
	public int minCost_3(String colors, int[] neededTime) {
		int n = colors.length();
		int result = 0;
		int max = neededTime[0];
		
		for (int i = 1; i < n; i++) {																				// T : O(n - 1)
			if (colors.charAt(i - 1) != colors.charAt(i)) { max = 0; }
			
			result += Math.min(max, neededTime[i]);
			max = Math.max(max, neededTime[i]);
		}
		
		return result;
	}
	
	/**
	 * time  : O(n)
	 * space : O(n)
	 * 
	 * Accepted Solutions Runtime Distribution
	 * */
	public int minCost(String colors, int[] neededTime) {
		int n = colors.length();
		int result = 0;
		int maxIndex = 0;
		char[] arr = colors.toCharArray();																			// S : O(n)
		
		for (int i = 1; i < n; i++) {																				// T : O(n - 1)
			if (arr[maxIndex] != arr[i]) {
				maxIndex = i;
			} else {
				if (neededTime[maxIndex] < neededTime[i]) {
					result += neededTime[maxIndex];
					maxIndex = i;
				} else {
					result += neededTime[i];
				}
			}
		}
		
		return result;
	}
	
}
