package com.example.lcpjava.array;

import java.util.Arrays;

public class Lcp_1235_Maximum_Profit_in_Job_Scheduling {
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/733167/Thinking-process-Top-down-DP-Bottom-up-DP
	 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/733167/Thinking-process-Top-down-DP-Bottom-up-DP/725955
	 * */
	public int jobScheduling_1(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];																				// S : O(n * 3)
		for (int i = 0; i < n; i++) { jobs[i] = new int[] { startTime[i], endTime[i], profit[i] }; }				// T : O(n)
		
		Arrays.sort(jobs, (offer, previous) -> offer[0] - previous[0]);												// T : O(n log n)
		
		int[] memo = new int[n];																					// S : O(n)
		Arrays.fill(memo, -1);																						// T : O(n)
		
		DFS(0, jobs, memo);
		
		return memo[0];
	}
	
	private int DFS(int currentJobIndex, int[][] jobs, int[] memo) {
		if (currentJobIndex == jobs.length) { return 0; }
		if (memo[currentJobIndex] != -1) { return memo[currentJobIndex]; }
		
		int addCurrentProfit = jobs[currentJobIndex][2] + DFS(findNextJobIndex(currentJobIndex, jobs), jobs, memo);
		int skipCurrentProfit = DFS(currentJobIndex + 1, jobs, memo);
		
		return memo[currentJobIndex] = Math.max(addCurrentProfit, skipCurrentProfit);
	}
	
	private int findNextJobIndex(int currentJobIndex, int[][] jobs) {
		for (int nextJobIndex = currentJobIndex + 1; nextJobIndex < jobs.length; nextJobIndex++) {					// T : O(n)
			if (jobs[nextJobIndex][0] >= jobs[currentJobIndex][1]) {
				return nextJobIndex;
			}
		}
		return jobs.length;
	}
	
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/733167/Thinking-process-Top-down-DP-Bottom-up-DP
	 * */
	public int jobScheduling_2(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];																				// S : O(n * 3)
		for (int i = 0; i < n; i++) { jobs[i] = new int[] { startTime[i], endTime[i], profit[i] }; }				// T : O(n)
		
		Arrays.sort(jobs, (offer, previous) -> offer[0] - previous[0]);												// T : O(n log n)
		
		int[] dp = new int[n + 1];																					// S : O(n)
		dp[n - 1] = jobs[n - 1][2];
		
		for (int currentJobIndex = n - 2; currentJobIndex >= 0; currentJobIndex--) {								// T : O(n - 1)
			int nextJobIndex = findNextJobIndex(currentJobIndex, jobs);												// T : O(n)
			dp[currentJobIndex] = Math.max(jobs[currentJobIndex][2] + dp[nextJobIndex], dp[currentJobIndex + 1]);
		}
		
		return dp[0];
	}
	
	/**
	 * time  : O(n log n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/733167/Thinking-process-Top-down-DP-Bottom-up-DP
	 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/733167/Thinking-process-Top-down-DP-Bottom-up-DP/879008
	 * */
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];																				// S : O(n * 3)
		for (int i = 0; i < n; i++) { jobs[i] = new int[] { startTime[i], endTime[i], profit[i] }; }				// T : O(n)
		
		Arrays.sort(jobs, (offer, previous) -> offer[0] - previous[0]);												// T : O(n log n)
		
		int[] dp = new int[n + 1];																					// S : O(n)
		dp[n - 1] = jobs[n - 1][2];
		
		for (int currentJobIndex = n - 2; currentJobIndex >= 0; currentJobIndex--) {								// T : O(n - 1)
			int nextJobIndex = binarySearch(currentJobIndex, jobs);													// T : O(log n)
			dp[currentJobIndex] = Math.max(jobs[currentJobIndex][2] + dp[nextJobIndex], dp[currentJobIndex + 1]);
		}
		
		return dp[0];
	}
	
	private int binarySearch(int currentJobIndex, int[][] jobs) {
		int start = currentJobIndex + 1;
		int end = jobs.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (jobs[mid][0] >= jobs[currentJobIndex][1]) {
				if (jobs[mid - 1][0] >= jobs[currentJobIndex][1]) {
					end = mid - 1;
				} else {
					return mid;
				}
			} else {
				start = mid + 1;
			}
		}
		
		return jobs.length;
	}
	
}
