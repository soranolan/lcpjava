package com.example.lcpjava.array;

public class Lcp_718_Maximum_Length_of_Repeated_Subarray {
	
	/**
	 * time  : O(m * n * min(m, n))
	 * space : O(1)
	 * 
	 * Brute Force
	 * 
	 * Time Limit Exceeded
	 * 
	 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/1324737/Optimization-from-Brute-Force-to-DP-to-Space-Optimized-DP-Explained!
	 * */
	public int findLength_1(int[] nums1, int[] nums2) {
		int result = 0;
		int m = nums1.length;
		int n = nums2.length;
		
		for (int i = 0; i < m; i++) {																				// T : O(m)
			for (int j = 0; j < n; j++) {																			// T : O(n)
				int count = 0;
				
				while (i + count < m && j + count < n && nums1[i + count] == nums2[j + count]) { count++; }
				
				result = Math.max(result, count);
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * */
	public int findLength_2(int[] nums1, int[] nums2) {
		int result = 0;
		int m = nums1.length;
		int n = nums2.length;
		int[][] dp = new int[m][n];																					// S : O(m * n)
		
		// if exist same number, there might be a start point
		for (int i = 0; i < m; i++) {																				// T : O(m)
			for (int j = 0; j < n; j++) {																			// T : O(n)
				if (nums1[i] == nums2[j]) { dp[i][j] = 1; }
			}
		}
		
		// if exist same number, check if previous number is same too
		for (int i = 1; i < m; i++) {																				// T : O(m - 1)
			for (int j = 1; j < n; j++) {																			// T : O(n - 1)
				if (nums1[i] == nums2[j]) { dp[i][j] = dp[i - 1][j - 1] + 1; }
			}
		}
		
		for (int i = 0; i < m; i++) {																				// T : O(m)
			for (int j = 0; j < n; j++) {																			// T : O(n)
				result = Math.max(result, dp[i][j]);
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(m * n)
	 * 
	 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109039/Concise-Java-DP:-Same-idea-of-Longest-Common-Substring/257406
	 * */
	public int findLength_3(int[] nums1, int[] nums2) {
		int result = 0;
		int m = nums1.length;
		int n = nums2.length;
		int[][] dp = new int[m + 1][n + 1];																			// S : O((m + 1) * (n + 1))
		
		for (int i = 1; i <= m; i++) {																				// T : O(m)
			for (int j = 1; j <= n; j++) {																			// T : O(n)
				if (nums1[i - 1] == nums2[j - 1]) { dp[i][j] = dp[i - 1][j - 1] + 1; }
				result = Math.max(result, dp[i][j]);
			}
		}
		
		return result;
	}
	
	/**
	 * time  : O(m * n)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/1324248/C%2B%2BPython-DP-KMP-Hashing-Solutions-Clean-and-Concise-O(NlogN)
	 * */
	public int findLength(int[] nums1, int[] nums2) {
		int result = 0;
		int m = nums1.length;
		int n = nums2.length;
		if (m < n) { return findLength(nums2, nums1); }
		
		int[] previous = new int[n + 1];																			// S : O(n + 1)
		int[] current = new int[n + 1];																				// S : O(n + 1)
		
		for (int i = 1; i <= m; i++) {																				// T : O(m)
			for (int j = 1; j <= n; j++) {																			// T : O(n)
				if (nums1[i - 1] == nums2[j - 1]) {
					current[j] = previous[j - 1] + 1;
				} else {
					current[j] = 0;
				}
				result = Math.max(result, current[j]);
			}
			
			int[] temp = previous;
			previous = current;
			current = temp;
		}
		
		return result;
	}
	
	/**
	 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109059/O(mn)-time-O(1)-space-solution
	 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/1324248/C%2B%2BPython-DP-KMP-Hashing-Solutions-Clean-and-Concise-O(NlogN)
	 * */
	
}
