package com.example.lcpjava.binarysearchtree;

public class Lcp_96_Unique_Binary_Search_Trees {
	
	/**
	 * DP(0) = 1
	 * DP(1) = 1
	 * DP(2) = F(1, 2) + F(2, 2)
	 * DP(3) = F(1, 3) + F(2, 3) + F(3, 3)
	 * DP(n) = F(1, n) + ... + F(n, n)
	 *       = DP(1 - 1) * DP(n - 1) + DP(2 - 1) * DP(n - 2) + ... + DP(n - 1) * DP(n - n)
	 * 
	 * F(j, i) : 1 2 | 3 | 4 5 6 7
	 * F(3, 7) : 3 as root, total 7 nodes
	 * = DP(2) * DP(4)
	 * = DP(j - 1) * DP(i - j)
	 * */
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
	 * https://www.youtube.com/watch?v=YDf982Lb84o
	 * 
	 * 
	 * if n is lower than or equal to one
	 * 		return one
	 * end if
	 * 
	 * int[] dp <- new int[n plus one]
	 * dp[0] <- one
	 * dp[1] <- one
	 * 
	 * for int i <- 2; if i is lower than or equal to n; i++
	 * 		for int j <- 1; if j is lower than or equal to i; j++
	 * 			dp[i] <- dp[i] plus dp[j minus one] plus dp[i minus j]
	 * 		end for
	 * end for
	 * 
	 * return dp[n]
	 * */
	public int numTrees_1(int n) {
		if (n <= 1) { return 1; }
		
		int[] dp = new int[n + 1];																					// S : O(n)
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {																				// T : O(n)
			for (int j = 1; j <= i; j++) {																			// T : O(n)
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		
		return dp[n];
	}
	
	/**
	 * n = 0, count[0] = 1
	 * 
	 * n = 1, count[1] = 1
	 * 
	 * n = 2, count[2] = count[1] + count[1] = 1 + 1 = 2
	 * 		1					  2
	 * 		 \					 /
	 * 		  count[1]			count[1]
	 * 
	 * n = 3, count[3] = count[2] + count[1] * count[1] + count[2] = 2 + 1 * 1 + 2 = 5
	 * 		1						 2					 3
	 * 		 \						/ \					/
	 * 		  count[2]		count[1]	count[1]		count[2]
	 * 
	 * n = 4, count[4] = count[3] + count[2] * count[1] + count[1] * count[2] + count[3] = 5 + 1 * 2 + 2 * 1 + 5 = 14
	 * 		1						 2							 3					 4
	 * 		 \						/ \							/ \					/
	 * 		  count[3]		count[1]	count[2]		count[2]	count[1]		count[3]
	 * */
	/**
	 * time  : O(n ^ 2)
	 * space : O(n)
	 * 
	 * if n is lower than or equal to one
	 * 		return one
	 * end if
	 * 
	 * int[] dp <- new int[n plus one]
	 * dp[0] <- one
	 * dp[1] <- one
	 * 
	 * for int total <- 2; if total is lower than or equal to n; total++
	 * 		for int left <- 0; if left is lower than total; left++
	 * 			int leftSubTree <- dp[left]
	 * 			int rightSubTree <- dp[total minus left minus one]
	 * 			int structures <- leftSubTree times rightSubTree
	 * 			dp[total] <- dp[total] plus structures
	 * 		end for
	 * end for
	 * 
	 * return dp[n]
	 * */
	public int numTrees_2(int n) {
		if (n <= 1) { return 1; }
		
		int[] dp = new int[n + 1];																					// S : O(n)
		dp[0] = 1;
		dp[1] = 1;
		
		for (int total = 2; total <= n; total++) {																	// T : O(n)
			for (int left = 0; left < total; left++) {																// T : O(n)
				int leftSubTree = dp[left];
				int rightSubTree = dp[total - left - 1];															// total node - left node - root node = right node
				int structures = leftSubTree * rightSubTree;
				dp[total] += structures;
			}
		}
		
		return dp[n];
	}
	
	/**
	 * time  : O(n)
	 * space : O(1)
	 * 
	 * Math is the king!
	 * 
	 * Catalan number
	 * https://leetcode.com/problems/unique-binary-search-trees/discuss/1565543/C%2B%2BPython-5-Easy-Solutions-w-Explanation-or-Optimization-from-Brute-Force-to-DP-to-Catalan-O(N)
	 * 
	 * int result <- one
	 * 
	 * for int i <- 0; if i is lower than n; i++
	 * 		result <- result times (four times i plus two) divide (i plus (double) 2)
	 * end for
	 * 
	 * return result
	 * */
	public int numTrees(int n) {
		int result = 1;
		
		for (int i = 0; i < n; i++) {																				// T : O(n)
			result *= (4 * i + 2) / (i + (double) 2);
		}
		
		return result;
	}
	
}
